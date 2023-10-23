//package school.sptech.projetotophair.api.integration.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//import school.sptech.projetotophair.api.configuration.security.jwt.GerenciadorTokenJwt;
//import school.sptech.projetotophair.domain.usuario.Usuario;
//import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;
//import school.sptech.projetotophair.service.usuario.autenticacao.dto.UsuarioLoginDto;
//import school.sptech.projetotophair.service.usuario.autenticacao.dto.UsuarioTokenDto;
//import school.sptech.projetotophair.service.usuario.dto.UsuarioCriacaoDto;
//import school.sptech.projetotophair.service.usuario.dto.UsuarioMapper;
//
//@Service
//public class UsuarioService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//    @Autowired
//    private GerenciadorTokenJwt gerenciadorTokenJwt;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private PaymentService paymentService; // Injeta o serviço de pagamento
//
//    public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
//        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);
//
//        String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
//        novoUsuario.setSenha(senhaCriptografada);
//
//        this.usuarioRepository.save(novoUsuario);
//    }
//
//    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) {
//
//        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
//                usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());
//
//        final Authentication authentication = this.authenticationManager.authenticate(credentials);
//
//        Usuario usuarioAutenticado =
//                usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
//                        .orElseThrow(
//                                () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
//                        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        final String token = gerenciadorTokenJwt.generateToken(authentication);
//
//        return UsuarioMapper.of(usuarioAutenticado, token);
//    }
//
//    public Payment realizarPagamento(String cardToken, String description, double amount, int installments, String paymentMethodId, String payerEmail) throws MPException {
//        return paymentService.createPayment(cardToken, description, amount, installments, paymentMethodId, payerEmail);
//    }
//
//    public PaymentStatus consultarStatusPagamento(String paymentId) throws MPException {
//        return paymentService.getPaymentStatus(paymentId);
//    }
//}
