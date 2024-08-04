package io.oliveiraordep.picpay.services;

import io.oliveiraordep.picpay.clients.NotificationClient;
import io.oliveiraordep.picpay.entities.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    NotificationClient notificationClient;

    public void sendNotification(Transfer transfer) {

        try {
            logger.info("Sending notification...");
            var response = notificationClient.sendNotification(transfer);

            if(response.getStatusCode().isError()) {
                logger.error("Error while sending notification");
            }
        } catch (Exception e ){
            logger.error("Error while sending notification", e);
        }
    }
}
