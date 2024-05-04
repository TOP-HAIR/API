package school.sptech.projetotophair.service.dto.agenda;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendaEmpresaDto {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String servicoCliente;
    private String status;
}
