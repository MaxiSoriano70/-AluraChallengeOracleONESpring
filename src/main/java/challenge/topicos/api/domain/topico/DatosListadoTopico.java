package challenge.topicos.api.domain.topico;

public record DatosListadoTopico(Long id,String titulo,String mensaje, String estatus_del_topico,String autor) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),topico.getEstatus_del_topico().toString(), topico.getAutor());
    }
}
