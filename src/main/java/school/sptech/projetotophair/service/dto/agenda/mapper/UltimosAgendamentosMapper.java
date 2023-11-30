package school.sptech.projetotophair.service.dto.agenda.mapper;

import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.dto.agenda.UltimosAgendamentosDto;

public class UltimosAgendamentosMapper {

    public static UltimosAgendamentosDto toDto(Agenda agenda) {
        if (agenda == null || agenda.getUsuarios() == null || agenda.getUsuarios().isEmpty()) {
            return null;
        }

        // Assuming you want the first user in the list
        // You might want to adjust this based on your specific logic
        Usuario primeiroUsuario = agenda.getUsuarios().get(0);

        UltimosAgendamentosDto dto = new UltimosAgendamentosDto();
        dto.setId(agenda.getIdAgenda());
        dto.setNomeCompleto(primeiroUsuario.getNomeCompleto());
        dto.setData(agenda.getData().toLocalDate());
        dto.setHora(agenda.getHora());
        dto.setStatus(agenda.getStatus());

        return dto;
    }
}
