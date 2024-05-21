package school.sptech.projetotophair.service.dto.usuario;

import lombok.Data;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoDto;

@Data
public class UsuarioComArquivoDto {
    private Long idUsuario;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private Boolean isProfissional;
    private ArquivoDto arquivo;
}
