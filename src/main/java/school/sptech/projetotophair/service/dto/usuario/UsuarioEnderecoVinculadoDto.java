package school.sptech.projetotophair.service.dto.usuario;

import lombok.Data;
import school.sptech.projetotophair.domain.endereco.Endereco;

@Data
public class UsuarioEnderecoVinculadoDto {
    private Long idUsuario;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private Boolean isProfissional;
    private Endereco endereco;
}
