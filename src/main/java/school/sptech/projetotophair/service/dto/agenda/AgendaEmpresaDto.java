package school.sptech.projetotophair.service.dto.agenda;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendaEmpresaDto {
    private LocalDateTime start;
    private LocalDateTime end;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    private String background;
}
