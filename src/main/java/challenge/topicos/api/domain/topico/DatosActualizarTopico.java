package challenge.topicos.api.domain.topico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String fecha_de_creacion,
        Estatus_del_topico estatus_del_topico,
        String autor,
        String curso
) {
}
