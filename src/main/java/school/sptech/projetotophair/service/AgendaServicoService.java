package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.agendaservico.AgendaServico;
import school.sptech.projetotophair.domain.agendaservico.repository.AgendaServicoRepository;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.servico.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServicoService {

    @Autowired
    private AgendaServicoRepository agendaServicoRepository;

    public AgendaServico cadastrarServico(AgendaServico agendaServico) {
        try {
            return agendaServicoRepository.save(agendaServico);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public Optional<AgendaServico> buscarServicoPorId(Long id) {
        try {
            Optional<AgendaServico> agendaServico = agendaServicoRepository.findById(id);
            if (agendaServico.isPresent()) {
                return agendaServico;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<AgendaServico> listarTodosServicos() {
        try {
            return agendaServicoRepository.findAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public Optional<AgendaServico> atualizarServico(Long id, AgendaServico agendaServico) {
        try {
            Optional<AgendaServico> servicoExistente = agendaServicoRepository.findById(id);
            if (servicoExistente.isPresent()) {
                agendaServico.setIdAgendaServico(id);
                return Optional.of(agendaServicoRepository.save(agendaServico));
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void deletarServico(Long idServico) {
        agendaServicoRepository.deleteById(idServico);
    }
}
