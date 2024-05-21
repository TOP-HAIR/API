package school.sptech.projetotophair.service.dto.usuario;


import lombok.Data;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

@Data
public class UsuarioEmpresaVinculadaDto {
    private Long idUsuario;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private Boolean isProfissional;
    private EmpresaDto empresa;
    private Endereco endereco;
}
