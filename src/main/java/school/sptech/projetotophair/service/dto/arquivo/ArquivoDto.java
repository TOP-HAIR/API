package school.sptech.projetotophair.service.dto.arquivo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ArquivoDto {
    private Integer id;
    private String nomeArquivoOriginal;
    private String nomeArquivoSalvo;
    private LocalDate dataUpload;
}
