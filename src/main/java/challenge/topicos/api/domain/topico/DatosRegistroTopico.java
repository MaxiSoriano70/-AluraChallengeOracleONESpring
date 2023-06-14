package challenge.topicos.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String fecha_de_creacion,
        @NotNull
        Estatus_del_topico estatus_del_topico,
        @NotBlank
        String autor,
        @NotBlank
        String curso
    ) {
}
