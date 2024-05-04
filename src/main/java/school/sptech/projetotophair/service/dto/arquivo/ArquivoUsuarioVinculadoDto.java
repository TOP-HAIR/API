package school.sptech.projetotophair.service.dto.arquivo;

import lombok.Data;
import school.sptech.projetotophair.service.dto.usuario.UsuarioDto;
import java.time.LocalDate;

@Data
public class ArquivoUsuarioVinculadoDto {
    private Integer id;
    private String nomeArquivoOriginal;
    private String nomeArquivoSalvo;
    private LocalDate dataUpload;
    private UsuarioDto usuarioDto;
}
