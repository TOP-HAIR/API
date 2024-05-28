package school.sptech.projetotophair.service.dto.agenda.mapper;

import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.dto.agenda.*;
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
        dto.setNomeUsuario(primeiroUsuario.getNomeCompleto());
        dto.setStart(agenda.getStart());
        dto.setEnd(agenda.getEnd());
        dto.setTitle(agenda.getTitle());

        return dto;
    }

    public static AgendaEmpresaVinculadaDto toAgendaEmpresaVinculadaDto(Agenda entity){
        AgendaEmpresaVinculadaDto dto = new AgendaEmpresaVinculadaDto();

        dto.setIdAgenda(entity.getIdAgenda());
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getEnd());
        dto.setTitle(entity.getTitle());
        dto.setEmpresa(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));

        return dto;
    }

    public static AgendaComEmpresaDto toAgendaComEmpresaDto(Agenda entity){
        AgendaComEmpresaDto dto = new AgendaComEmpresaDto();

        dto.setEmpresaDto(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));
        dto.setIdAgenda(entity.getIdAgenda());
        dto.setTitle(entity.getTitle());
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getEnd());

        return dto;
    }

    public static AgendaDto toAgendaDto(Agenda entity){
        AgendaDto dto = new AgendaDto();

        dto.setIdAgenda(entity.getIdAgenda());
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getEnd());
        dto.setTitle(entity.getTitle());

        return dto;
    }

    public static AgendaEmpresaDto toAgendaEmpresaDto(Agenda entity) {
        AgendaEmpresaDto dto = new AgendaEmpresaDto();

        // Define data de início e fim diretamente
        dto.setStart(entity.getStart());
        dto.setEnd(entity.getEnd());

        // Configura a cor do status baseado no status da entidade
        if (entity.getTitle() != null) {
            if ("Cancelado".equalsIgnoreCase(entity.getTitle())) {
                dto.setBackground("#DC3545"); // Cor para cancelado
            } else if ("Agendado".equalsIgnoreCase(entity.getTitle())) {
                dto.setBackground("#28A745"); // Cor para agendado
            }
        }

        // Verifica se a lista de usuários não é nula e não está vazia
        if (entity.getUsuarios() != null && !entity.getUsuarios().isEmpty()) {
            Usuario usuario = entity.getUsuarios().get(0); // Pegando o primeiro usuário como exemplo

            // Verifica se o usuário não é nulo e possui um serviço associado não nulo
            if (usuario != null && usuario.getServico() != null && usuario.getNomeCompleto() != null) {
                Servico servico = usuario.getServico();

                // Verifica se a descrição do serviço e o nome do usuário não são nulos
                if (servico.getDescricao() != null) {
                    String servicoCliente = servico.getDescricao() + " - " + usuario.getNomeCompleto();
                    dto.setTitle(servicoCliente);
                }
            }
        }

        return dto;
    }

}
