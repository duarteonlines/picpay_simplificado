package io.oliveiraordep.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletDataAlreadyExists extends StandardError{

    private String detail;

    public WalletDataAlreadyExists(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Wallet data already exists");
        pb.setDetail(detail);
        return pb;
    }
}
