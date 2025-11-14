package com.miaraylight.pizzamore.util;

import com.miaraylight.pizzamore.models.Order;
import com.miaraylight.pizzamore.models.OrderItem;
import com.miaraylight.pizzamore.models.Pizza;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    private static final String RECEIPT_FOLDER = "receipts";

    public static void writeReceipt(Order order) {
        try {
            Path folder = Paths.get(RECEIPT_FOLDER);
            if (!Files.exists(folder)) {
                Files.createDirectory(folder);
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String filename = timestamp + ".txt";
            Path filePath = folder.resolve(filename);

            Files.writeString(filePath, buildReceipt(order));

            System.out.println("📄 Receipt created: " + filePath.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ ERROR: Could not write receipt!");
            e.printStackTrace();
        }
    }

    private static String buildReceipt(Order order) {
        StringBuilder sb = new StringBuilder();

        sb.append("╔══════════════════════════════════════╗\n");
        sb.append("║               ORDER RECEIPT           ║\n");
        sb.append("╠══════════════════════════════════════╣\n");

        sb.append("Order ID: ").append(order.getOrderId()).append("\n");
        sb.append("Date: ").append(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n\n");

        sb.append("Items:\n");

        int i = 1;
        for (OrderItem item : order.getOrderItems()) {
            sb.append(String.format("%d) %-20s  $%6.2f%n", i++, item.getName(), item.getPrice()));

            if (item instanceof Pizza pizza) {
                sb.append("     - Size: ").append(pizza.getSize()).append("\n");
            }
            sb.append("\n");
        }

        sb.append("╠══════════════════════════════════════╣\n");
        sb.append(String.format("Subtotal:               $%6.2f%n", order.getSubtotal()));

        if (order.getSubtotal() > order.getTotalPrice()) {
            sb.append(String.format("Discount:              -$%6.2f%n", order.getSubtotal() - order.getTotalPrice() + order.getTax()));
        }

        sb.append(String.format("Tax (7%%):              $%6.2f%n", order.getTax()));
        sb.append("╠══════════════════════════════════════╣\n");

        sb.append(String.format("TOTAL:                 $%6.2f%n", order.getTotalPrice()));
        sb.append("╚══════════════════════════════════════╝\n");

        return sb.toString();
    }
}
