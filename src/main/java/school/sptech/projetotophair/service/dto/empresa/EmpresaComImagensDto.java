package school.sptech.projetotophair.service.dto.empresa;

import lombok.Data;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoDto;

import java.util.List;

@Data
public class EmpresaComImagensDto {
    private Long idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private List<ArquivoDto> arquivos;
}
