//package school.sptech.projetotophair.api.integration.controller;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class PaymentController {
//
//    @PostMapping("/create-preference")
//    public ResponseEntity<String> createPreference(@RequestBody PaymentRequest paymentRequest) {
//        try {
//            // Configure as credenciais do Mercado Pago
//            MercadoPago.SDK.setAccessToken("SEU_CLIENT_SECRET");
//
//            // Crie um objeto de Preferência de Pagamento
//            Preference preference = new Preference();
//            // Configure os detalhes do pagamento (valor, moeda, itens, etc.) no objeto de Preferência
//
//            // Salve a preferência
//            preference.save();
//
//            // Retorne o ID da preferência gerada como resposta
//            return ResponseEntity.ok(preference.getId());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Erro ao criar a preferência de pagamento.");
//        }
//    }
//}
