package io.oliveiraordep.picpay.services;

import io.oliveiraordep.picpay.clients.AuthorizationClient;
import io.oliveiraordep.picpay.controllers.dtos.TransferDto;
import io.oliveiraordep.picpay.exceptions.StandardError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    AuthorizationClient authorizationClient;

    public boolean isAuthorized(TransferDto transfer) {
        var response = authorizationClient.isAuthorized();

        return response.getData().getAuthorization();

    }
}
