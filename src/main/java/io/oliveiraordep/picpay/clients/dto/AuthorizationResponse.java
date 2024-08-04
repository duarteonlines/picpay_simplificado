package io.oliveiraordep.picpay.clients.dto;

public class AuthorizationResponse {
    private String status;
    private Data data;

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }

    public static class Data {
        private Boolean authorization;

        public Boolean getAuthorization() {
            return authorization;
        }
    }
}
