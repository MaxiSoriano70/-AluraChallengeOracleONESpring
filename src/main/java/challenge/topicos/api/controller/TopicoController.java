package challenge.topicos.api.controller;

import challenge.topicos.api.domain.topico.*;
import challenge.topicos.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico=topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_de_creacion(),topico.getEstatus_del_topico().toString(),topico.getAutor(),topico.getCurso());
        //RETURN 201 CREATED
        //URL DONDE ENCONTRAR AL MEDICO
        //GET http://localhot:8080/medico/xx
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoMedicos(@PageableDefault(size = 2,sort = "titulo") Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_de_creacion(),topico.getEstatus_del_topico().toString(),topico.getAutor(),topico.getCurso()));
    }

    /*DELETE LOGICO*/
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    /*DELETE BBDD*/
    /*public void eliminarTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornarDatosTopico(@PathVariable Long id){
        Topico topico=topicoRepository.getReferenceById(id);
        DatosRespuestaTopico datosRespuestaTopico=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_de_creacion(),topico.getEstatus_del_topico().toString(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosRespuestaTopico);
    }
}
