package challenge.topicos.api.domain.topico;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        String fecha_de_creacion,
        String estatus_del_topico,
        String autor,
        String curso) {
}
