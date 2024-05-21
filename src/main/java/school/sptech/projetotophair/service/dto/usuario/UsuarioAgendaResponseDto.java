package school.sptech.projetotophair.service.dto.usuario;

import lombok.Data;
import school.sptech.projetotophair.service.dto.agenda.AgendaDto;

@Data
public class UsuarioAgendaResponseDto {
    private Long idUsuario;
    private String cpf;
    private String nomeCompleto;
    private String email;
    private String senha;
    private String telefone;
    private Boolean isProfissional;
    private AgendaDto agenda;
}
