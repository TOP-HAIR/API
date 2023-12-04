package school.sptech.projetotophair.service.dto.agenda.mapper;

import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.dto.agenda.AgendaDto;
import school.sptech.projetotophair.service.dto.agenda.AgendaEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.agenda.UltimosAgendamentosDto;
import school.sptech.projetotophair.service.dto.empresa.mapper.EmpresaMapper;

public class AgendaMapper {

    public static UltimosAgendamentosDto toDto(Agenda agenda) {
        if (agenda == null || agenda.getUsuarios() == null || agenda.getUsuarios().isEmpty()) {
            return null;
        }

        // Assuming you want the first user in the list
        // You might want to adjust this based on your specific logic
        Usuario primeiroUsuario = agenda.getUsuarios().get(0);

        UltimosAgendamentosDto dto = new UltimosAgendamentosDto();
        dto.setIdAgenda(agenda.getIdAgenda());
        dto.setIdUsuario(primeiroUsuario.getIdUsuario());
        dto.setNomeEmpresa(primeiroUsuario.getNomeCompleto());
        dto.setData(agenda.getData());
        dto.setHora(agenda.getHora());
        dto.setStatus(agenda.getStatus());

        return dto;
    }

    public static AgendaEmpresaVinculadaDto toAgendaEmpresaVinculadaDto(Agenda entity){
        AgendaEmpresaVinculadaDto dto = new AgendaEmpresaVinculadaDto();

        dto.setIdAgenda(entity.getIdAgenda());
        dto.setData(entity.getData());
        dto.setHora(entity.getHora());
        dto.setStatus(entity.getStatus());
        dto.setEmpresa(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));

        return dto;
    }

    public static AgendaDto toAgendaDto(Agenda entity){
        AgendaDto dto = new AgendaDto();

        dto.setIdAgenda(entity.getIdAgenda());
        dto.setData(entity.getData());
        dto.setStatus(entity.getStatus());
        dto.setHora(entity.getHora());

        return dto;
    }
}
