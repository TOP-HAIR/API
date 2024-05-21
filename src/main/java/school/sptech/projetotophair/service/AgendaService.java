package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.domain.agenda.repository.RelatorioAgenda;
import school.sptech.projetotophair.service.dto.agenda.UltimosAgendamentosDto;
import school.sptech.projetotophair.service.dto.agenda.mapper.AgendaMapper;
import school.sptech.projetotophair.service.integraveis.fila.Fila;
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
import school.sptech.projetotophair.service.integraveis.pilha.PilhaObj;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.math.BigDecimal;
import java.util.*;

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


    public List<UltimosAgendamentosDto> getUltimosAgendamentosDto(Long idEmpresa) {
        int quantidadeDesejada = 10;
        PilhaObj<Agenda> ultimosAgendamentosPilha = new PilhaObj<>(quantidadeDesejada);

        List<Agenda> todosAgendamentos = agendaRepository.findAllByEmpresaIdEmpresa(idEmpresa);

        // Adicionar os últimos 10 agendamentos à pilha
        int startIndex = Math.max(0, todosAgendamentos.size() - quantidadeDesejada);
        for (int i = startIndex; i < todosAgendamentos.size(); i++) {
            ultimosAgendamentosPilha.push(todosAgendamentos.get(i));
        }

        // Obter os itens da pilha na ordem correta
        List<UltimosAgendamentosDto> dtos = new ArrayList<>();
        while (!ultimosAgendamentosPilha.isEmpty()) {
            Agenda agenda = ultimosAgendamentosPilha.pop();
            if (agenda != null) {
                UltimosAgendamentosDto dto = AgendaMapper.toDto(agenda);
                dtos.add(dto);
            }
        }

        return dtos;
    }

    public Fila mesesOrdenados() {
        Fila mesesOrdenados = new Fila(12);

        String mes1 = "Janeiro";
        String mes2 = "Fevereiro";
        String mes3 = "Março";
        String mes4 = "Abril";
        String mes5 = "Maio";
        String mes6 = "Junho";
        String mes7 = "Julho";
        String mes8 = "Agosto";
        String mes9 = "Setembro";
        String mes10 = "Outubro";
        String mes11 = "Novembro";
        String mes12 = "Dezembro";

        mesesOrdenados.insert(mes1);
        mesesOrdenados.insert(mes2);
        mesesOrdenados.insert(mes3);
        mesesOrdenados.insert(mes4);
        mesesOrdenados.insert(mes5);
        mesesOrdenados.insert(mes6);
        mesesOrdenados.insert(mes7);
        mesesOrdenados.insert(mes8);
        mesesOrdenados.insert(mes9);
        mesesOrdenados.insert(mes10);
        mesesOrdenados.insert(mes11);
        mesesOrdenados.insert(mes12);

        return mesesOrdenados;

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


    public List<RelatorioAgenda> buscarPeriodos(Long id) {
        List<Object[]> resultados = agendaRepository.buscarPeriodosPorEmpresa(id);
        List<RelatorioAgenda> periodos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Escolha o formato que você precisa

        for (Object[] resultado : resultados) {
            String dataInicio = resultado[2] != null ? sdf.format((Timestamp) resultado[2]) : null;
            String dataFinal = resultado[3] != null ? sdf.format((Timestamp) resultado[3]) : null;
            BigDecimal precoTotalBD = (BigDecimal) resultado[4];
            Double precoTotal = precoTotalBD != null ? precoTotalBD.doubleValue() : null;

            // Criar o objeto RelatorioAgenda e adicioná-lo à lista de periodos
            RelatorioAgenda periodo = new RelatorioAgenda(dataInicio, dataFinal, precoTotal);
            periodos.add(periodo);
        }

        return periodos;
    }



}
