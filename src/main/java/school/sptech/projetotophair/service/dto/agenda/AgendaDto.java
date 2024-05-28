package school.sptech.projetotophair.service.dto.agenda;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AgendaDto {
    private Long idAgenda;
    private LocalDateTime start;
    private LocalDateTime end;
    private String title;
}
