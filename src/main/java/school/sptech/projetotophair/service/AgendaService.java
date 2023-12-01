package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.service.Integraveis.pilha.PilhaObj;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.agenda.repository.AgendaRepository;
import school.sptech.projetotophair.domain.agendaservico.AgendaServico;
import school.sptech.projetotophair.domain.agendaservico.repository.AgendaServicoRepository;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.servico.repository.ServicoRepository;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private AgendaServicoRepository agendaServicoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Agenda cadastrarAgenda(Agenda agenda) {
        if (agenda == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A agenda não pode ser nula.");
        }
        return agendaRepository.save(agenda);
    }

    public AgendaServico vincularServico(Long idAgenda, Long idServico){
        Optional<Agenda> agendaById = agendaRepository.findById(idAgenda);
        Optional<Servico> servicoById = servicoRepository.findById(idServico);

        if (servicoById.isPresent() && agendaById.isPresent()) {
            AgendaServico agendaServico = new AgendaServico(null, agendaById.get(), servicoById.get());
            return agendaServicoRepository.save(agendaServico);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda ou serço não encontrados");
    }

    public Optional<Agenda> buscarAgendaPorId(Long id) {
        Optional<Agenda> agendaOptional = agendaRepository.findById(id);
        if (agendaOptional.isPresent()) {
            return agendaOptional;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada com o ID: " + id);
        }
    }

    public List<Agenda> listarAgendasPorUsuario(Long idUsuario) {
        Optional<Usuario> usuarioById = usuarioRepository.findById(idUsuario);
        if (usuarioById.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado");
        }
        List<Agenda> allByUsuariosIdUsuario = agendaRepository.findAllByUsuariosIdUsuario(idUsuario);
        if (allByUsuariosIdUsuario.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Este usuario não tem agendamentos");
        }
        return allByUsuariosIdUsuario;
    }

    public List<Agenda> listarAgendasPorEmpresa(Long idEmpresa) {
        Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);
        if (empresaById.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada");
        }
        List<Agenda> allByEmpresaIdEmpresa = agendaRepository.findAllByEmpresaIdEmpresa(idEmpresa);
        if (allByEmpresaIdEmpresa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Esta empresa não tem agendamentos");
        }
        return allByEmpresaIdEmpresa;
    }

    public Agenda vincularEmpresa(Long idAgenda, Long idEmpresa){
        Optional<Agenda> agendaById = agendaRepository.findById(idAgenda);
        Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);

        if (agendaById.isPresent() && empresaById.isPresent()) {
            agendaById.get().setEmpresa(empresaById.get());
            return agendaRepository.save(agendaById.get());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda ou empresa não encontradas");
    }

    public Usuario vincularUsuario(Long idAgenda, Long idUsuario){
        Optional<Agenda> agendaById = agendaRepository.findById(idAgenda);
        Optional<Usuario> usuarioById = usuarioRepository.findById(idUsuario);

        if (agendaById.isPresent() && usuarioById.isPresent()) {
            usuarioById.get().setAgenda(agendaById.get());
            return usuarioRepository.save(usuarioById.get());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda ou usuario não encontrados");
    }

    public Optional<Agenda> atualizarAgenda(Long id, Agenda agenda) {
        if (!agendaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada com o ID: " + id);
        }

        agenda.setIdAgenda(id);

        agenda = agendaRepository.save(agenda);

        return Optional.of(agenda);
    }

    public void deletarAgenda(Long id) {
        if (!agendaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agenda não encontrada com o ID: " + id);
        }
        agendaRepository.deleteById(id);
    }

    public PilhaObj<Agenda> getUltimosAgendamentos() {
        int quantidadeDesejada = 10;

        PilhaObj<Agenda> ultimosAgendamentosPilha = new PilhaObj<>(quantidadeDesejada);

        // Popula a pilha com os últimos agendamentos do banco de dados
        List<Agenda> todosAgendamentos = agendaRepository.findAll();

        // Sort the agendas by date in descending order
        todosAgendamentos.sort(Comparator.comparing(Agenda::getData).reversed());

        // Add the last 10 agendas to the stack
        for (int i = 0; i < Math.min(quantidadeDesejada, todosAgendamentos.size()); i++) {
            ultimosAgendamentosPilha.push(todosAgendamentos.get(i));
        }

        // Retorna a pilha invertida (if needed)
        // inverterOrdemPilha(ultimosAgendamentosPilha);

        return ultimosAgendamentosPilha;
    }



    // Método para inverter a ordem dos elementos na pilha
    private <T> void inverterOrdemPilha(PilhaObj<T> pilha) {
        int tamanho = pilha.getTopo() + 1;
        for (int i = 0; i < tamanho / 2; i++) {
            T temp = pilha.pop();
            pilha.push(pilha.pop());
            pilha.push(temp);
        }

}





}
