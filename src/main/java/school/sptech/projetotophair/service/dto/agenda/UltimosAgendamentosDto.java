package school.sptech.projetotophair.service.dto.agenda;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UltimosAgendamentosDto {
    private Long idAgenda;
    private Long idUsuario;
    private String nomeEmpresa;
    private LocalDate data;
    private String hora;
    private String status;
}
