package io.oliveiraordep.picpay.services;

import io.oliveiraordep.picpay.clients.AuthorizationClient;
import io.oliveiraordep.picpay.entities.Transfer;
import io.oliveiraordep.picpay.exceptions.StandardError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    @Autowired
    AuthorizationClient authorizationClient;

    public boolean isAuthorized(Transfer transfer) {
        var resp = authorizationClient.isAuthorized();

        if(resp.getStatusCode().isError()){
            throw new StandardError();
        }
        return resp.getBody().authorized();
    }
}
