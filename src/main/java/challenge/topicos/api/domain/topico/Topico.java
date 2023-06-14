package challenge.topicos.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha_de_creacion;
    @Enumerated(EnumType.STRING)
    private Estatus_del_topico estatus_del_topico;
    private String autor;
    private String curso;
    private Boolean activo;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fecha_de_creacion=datosRegistroTopico.fecha_de_creacion();
        this.estatus_del_topico=datosRegistroTopico.estatus_del_topico();
        this.autor=datosRegistroTopico.autor();
        this.curso=datosRegistroTopico.curso();
        this.activo=true;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo()!=null){
            this.titulo=datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje()!=null){
            this.mensaje=datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.fecha_de_creacion()!=null){
            this.fecha_de_creacion=datosActualizarTopico.fecha_de_creacion();
        }
        if(datosActualizarTopico.estatus_del_topico()!=null){
            this.estatus_del_topico=datosActualizarTopico.estatus_del_topico();
        }
        if(datosActualizarTopico.autor() !=null){
            this.autor=datosActualizarTopico.autor();
        }
        if(datosActualizarTopico.curso()!=null){
            this.curso=datosActualizarTopico.curso();
        }
    }

    public void desactivarTopico() {
        this.activo=false;
    }
}
