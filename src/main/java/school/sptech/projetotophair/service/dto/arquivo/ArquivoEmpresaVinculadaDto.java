package school.sptech.projetotophair.service.dto.arquivo;


import lombok.Data;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

import java.time.LocalDate;

@Data
public class ArquivoEmpresaVinculadaDto {
    private Integer id;
    private String nomeArquivoOriginal;
    private String nomeArquivoSalvo;
    private LocalDate dataUpload;
    private EmpresaDto empresaDto;
}
