package io.oliveiraordep.picpay.exceptions;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends StandardError{
    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Insufficient Balance");
        pb.setDetail("You cannot transfer a value bigger than your current balance");
        return pb;
    }
}
