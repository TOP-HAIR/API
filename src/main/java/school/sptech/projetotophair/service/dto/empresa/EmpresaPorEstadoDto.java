package school.sptech.projetotophair.service.dto.empresa;

import lombok.Data;
import school.sptech.projetotophair.service.dto.endereco.EnderecoDto;

@Data
public class EmpresaPorEstadoDto {
    private Long idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private EnderecoDto endereco;
}
