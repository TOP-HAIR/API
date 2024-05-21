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

    public static AgendaComEmpresaDto toAgendaComEmpresaDto(Agenda entity){
        AgendaComEmpresaDto dto = new AgendaComEmpresaDto();

        dto.setEmpresaDto(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));
        dto.setIdAgenda(entity.getIdAgenda());
        dto.setStatus(entity.getStatus());
        dto.setHora(entity.getHora());
        dto.setData(entity.getData());

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

    public static AgendaEmpresaDto toAgendaEmpresaDto(Agenda entity) {
        AgendaEmpresaDto dto = new AgendaEmpresaDto();

        // Define data de início e fim diretamente
        dto.setStart(entity.getDataInicio());
        dto.setEnd(entity.getDataFim());

        // Configura a cor do status baseado no status da entidade
        if (entity.getStatus() != null) {
            if ("Cancelado".equalsIgnoreCase(entity.getStatus())) {
                dto.setBackground("#DC3545"); // Cor para cancelado
            } else if ("Agendado".equalsIgnoreCase(entity.getStatus())) {
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
