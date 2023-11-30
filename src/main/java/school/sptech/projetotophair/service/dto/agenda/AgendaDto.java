package school.sptech.projetotophair.service.dto.agenda;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AgendaDto {
    private Long idAgenda;
    private LocalDate data;
    private String hora;
    private String status;
}
