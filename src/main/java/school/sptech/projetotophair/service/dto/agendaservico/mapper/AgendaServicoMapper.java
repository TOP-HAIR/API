package school.sptech.projetotophair.service.dto.agendaservico.mapper;

import school.sptech.projetotophair.domain.agendaservico.AgendaServico;
import school.sptech.projetotophair.service.dto.agenda.mapper.AgendaMapper;
import school.sptech.projetotophair.service.dto.agendaservico.AgendaServicoDto;
import school.sptech.projetotophair.service.dto.servico.mapper.ServicoMapper;

public class AgendaServicoMapper {
    public static AgendaServicoDto toAgendaServicoDto(AgendaServico entity){
        AgendaServicoDto dto = new AgendaServicoDto();

        dto.setIdAgendaServico(entity.getIdAgendaServico());
        dto.setServico(ServicoMapper.toServicoDto(entity.getServico()));
        dto.setAgenda(AgendaMapper.toAgendaDto(entity.getAgenda()));

        return dto;
    }
}
