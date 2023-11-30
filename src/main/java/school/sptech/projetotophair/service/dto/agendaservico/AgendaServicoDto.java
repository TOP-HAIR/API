package school.sptech.projetotophair.service.dto.agendaservico;

import lombok.Data;
import school.sptech.projetotophair.service.dto.agenda.AgendaDto;
import school.sptech.projetotophair.service.dto.servico.ServicoDto;

@Data
public class AgendaServicoDto {
    private Long idAgendaServico;
    private AgendaDto agenda;
    private ServicoDto servico;
}
