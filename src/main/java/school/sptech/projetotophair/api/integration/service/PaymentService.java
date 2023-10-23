//package school.sptech.projetotophair.api.integration.service;
//
//import com.mercadopago.MercadoPago;
//import com.mercadopago.exceptions.MPException;
//import com.mercadopago.resources.payment.Payment;
//import com.mercadopago.resources.payment.PaymentStatus;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentService {
//
//    @Value("${mercado-pago.access-token}") // Você pode configurar o token de acesso no application.properties
//    private String accessToken;
//
//    public PaymentService() {
//        MercadoPago.SDK.setAccessToken(accessToken);
//    }
//
//    public Payment createPayment(String cardToken, String description, double amount, int installments, String paymentMethodId, String payerEmail) throws MPException {
//        Payment payment = new Payment()
//                .setTransactionAmount(amount)
//                .setDescription(description)
//                .setInstallments(installments)
//                .setPaymentMethodId(paymentMethodId)
//                .setToken(cardToken)
//                .setPayer(new PaymentPayerRequest().setEmail(payerEmail));
//
//        payment.save();
//
//        return payment;
//    }
//
//    public PaymentStatus getPaymentStatus(String paymentId) throws MPException {
//        Payment payment = Payment.findById(paymentId);
//        return payment.getStatus();
//    }
//}
//
