package io.oliveiraordep.picpay.clients;

import io.oliveiraordep.picpay.clients.dto.AuthorizationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "authorization-service", url = "${client.authorization-service.url}")

public interface AuthorizationClient {
    @GetMapping
    AuthorizationResponse isAuthorized();

}
