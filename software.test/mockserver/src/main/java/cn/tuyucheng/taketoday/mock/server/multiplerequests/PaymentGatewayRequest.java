package cn.tuyucheng.taketoday.mock.server.multiplerequests;

public record PaymentGatewayRequest(String cardNumber, String expiryMonth, String expiryYear, String currency,
                                    int amount, String cvv) {

}
