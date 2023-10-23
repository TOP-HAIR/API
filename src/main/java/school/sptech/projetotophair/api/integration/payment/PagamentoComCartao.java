//package school.sptech.projetotophair.api.integration.payment;
//
//import com.mercadopago.MercadoPago;
//import com.mercadopago.exceptions.MPException;
//import com.mercadopago.resources.Payment;
//import com.mercadopago.resources.datastructures.payment.PaymentPayer;
//import com.mercadopago.resources.datastructures.payment.PaymentToken;
//
//public class PagamentoComCartao {
//
//    public Payment processarPagamentoComCartao(String cartaoToken, float valor, String descricao) throws MPException {
//        // Crie um objeto PaymentToken com o token do cartão
//        PaymentToken paymentToken = new PaymentToken();
//        paymentToken.setToken(cartaoToken);
//
//        // Crie um objeto Payment com os detalhes do pagamento
//        Payment payment = new Payment();
//        payment.setTransactionAmount(valor);
//        payment.setDescription(descricao);
//        payment.setPaymentMethodId("visa"); // Substitua pelo método de pagamento desejado
//        payment.setToken(paymentToken);
//
//        // Execute o pagamento
//        payment.save();
//
//        return payment;
//    }
//}
//
