package com.example.notificationservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    private static final Logger logger = LoggerFactory.getLogger(NotificationListener.class);

    @KafkaListener(topics = "inventory-update", groupId = "notification-group")
    public void onInventoryUpdate(String message) {
        logger.info("Inventory notification received: {}", message);
    }

    @KafkaListener(topics = "supplier-order", groupId = "notification-group")
    public void onSupplierOrder(String message) {
        logger.info("Supplier order notification received: {}", message);
    }
}
