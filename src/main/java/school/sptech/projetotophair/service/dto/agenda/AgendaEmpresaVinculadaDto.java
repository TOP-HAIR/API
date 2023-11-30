package school.sptech.projetotophair.service.dto.agenda;

import lombok.Data;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

import java.time.LocalDate;

@Data
public class AgendaEmpresaVinculadaDto {
    private Long idAgenda;
    private LocalDate data;
    private String hora;
    private String status;
    private EmpresaDto empresa;
}
