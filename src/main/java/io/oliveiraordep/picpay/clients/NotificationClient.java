package io.oliveiraordep.picpay.clients;

import io.oliveiraordep.picpay.entities.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-service",
url = "${client.notification-service.url}")
public interface NotificationClient {
    @PostMapping
    ResponseEntity<Void> sendNotification(Transfer transfer);
}
