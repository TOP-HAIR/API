package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.agenda.repository.AgendaRepository;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.servico.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public Servico cadastrarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico vincularEmpresa(Long idServico, Long idEmpresa){
        Optional<Servico> servicoById = servicoRepository.findById(idServico);
        Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);
        if (empresaById.isPresent() && servicoById.isPresent()) {
            servicoById.get().setEmpresa(empresaById.get());
            return servicoRepository.save(servicoById.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa ou serviço não encontrados");
    }

    public List<Servico> buscarServicosPorEmpresaId(Long id) {
        List<Servico> servicosByEmpresaId = servicoRepository.findServicosByEmpresaId(id);
        if (servicosByEmpresaId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviços não encontrados para essa empresa");
        }
        return servicosByEmpresaId;
    }

    public List<Servico> buscarServicosPorIdAgenda(Long idAgenda){
        Optional<Agenda> byId = agendaRepository.findById(idAgenda);
        if (byId.isPresent()) {
            List<Servico> allByAgendaIdAgenda = servicoRepository.findAllByAgendaIdAgenda(idAgenda);
            if (allByAgendaIdAgenda.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Esse agendamento não tem serviços");
            }
            return allByAgendaIdAgenda;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada");
    }

    public Optional<Servico> buscarServicoPorId(Long id) {
            Optional<Servico> servico = servicoRepository.findById(id);
            if (servico.isPresent()) {
                return servico;
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
    }

    public List<Servico> listarTodosServicos() {
        List<Servico> all = servicoRepository.findAll();
        if (all.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não há serviços");
        }
        return all;
    }

    public Optional<Servico> atualizarServico(Long id, Servico servico) {
            Optional<Servico> servicoExistente = servicoRepository.findById(id);
            if (servicoExistente.isPresent()) {
                servico.setIdServico(id);
                return Optional.of(servicoRepository.save(servico));
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
            }
        }

    public void deletarServico(Long idServico) {
        Optional<Servico> byId = servicoRepository.findById(idServico);
        if (byId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
        }
        servicoRepository.deleteById(idServico);
    }
}
