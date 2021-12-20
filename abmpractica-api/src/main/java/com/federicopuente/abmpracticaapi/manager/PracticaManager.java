package com.federicopuente.abmpracticaapi.manager;

import com.federicopuente.abmpracticaapi.dao.PracticaAreaJerarquicaDAO;
import com.federicopuente.abmpracticaapi.dao.PracticaDAO;
import com.federicopuente.abmpracticaapi.entity.AreaJerarquica;
import com.federicopuente.abmpracticaapi.entity.Practica;
import com.federicopuente.abmpracticaapi.entity.PracticaAreaJerarquica;
import com.federicopuente.abmpracticaapi.exception.ABMPracticaException;
import com.federicopuente.abmpracticaapi.util.ABMUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookretina
 */
@RestController
@RequestMapping("practica")
public class PracticaManager {
    
    @Autowired
    private PracticaDAO practicaDAO;
    
    @Autowired
    private PracticaAreaJerarquicaDAO practicaAreaJerarquicaDAO;

    @Autowired
    private ABMUtil util;
    
    @PostMapping
    public ResponseEntity<List<Practica>> listarPracticas(@RequestBody Optional<Practica> practica) {
        ResponseEntity<List<Practica>> respuesta = null;
        if (practica.isPresent()) {
            respuesta = ResponseEntity.ok(this.practicaDAO.findAll(Example.of(practica.get())));
        } else {
            respuesta = ResponseEntity.ok(this.practicaDAO.findAll());
        }
                
        return respuesta;
    }
    
    @RequestMapping(value="{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Practica> buscarPracticaPorId(@PathVariable("id") Integer id) {
        Optional<Practica> practica = this.practicaDAO.findById(id);
        if (practica.isPresent()) {
            return ResponseEntity.ok(practica.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }
    
    @PostMapping(value="crear")
    public ResponseEntity<Practica> crearPractica(@RequestBody Practica practica) {
        ResponseEntity respuesta = null;

        try {
            _validarPractica(practica);
            
            Practica practicaEntity =  this.practicaDAO.save(practica);

            respuesta = ResponseEntity.ok().body(practicaEntity);
        } catch (ABMPracticaException error) {
            respuesta = ResponseEntity.badRequest().body(error.getMessage());
        }
        
        return respuesta;
    }
    
    @PostMapping(value="modificar")
    public ResponseEntity<Practica> actualizarPractica(@RequestBody Practica practica) {
        ResponseEntity respuesta = null;

        try {
            _validarPractica(practica);
            
            Practica practicaEntity =  this.practicaDAO.save(practica);

            respuesta = ResponseEntity.ok().body(practicaEntity);
        } catch (ABMPracticaException error) {
            respuesta = ResponseEntity.badRequest().body(error.getMessage());
        }
        
        return respuesta;
    }
    
    @PostMapping(value="borrar/{idPractica}")
    public ResponseEntity<Void> borrarPractica(@PathVariable("idPractica") Integer idPractica) {
        System.out.println("Borrando practica: "+idPractica);
        this.practicaDAO.deleteById(idPractica);
        return ResponseEntity.ok(null);
    }
    
    @PostMapping(value="asignarArea")
    public ResponseEntity<PracticaAreaJerarquica> asignarAreas(@RequestBody PracticaAreaJerarquica practicaAreaJerarquica) {
        PracticaAreaJerarquica resultado = this.practicaAreaJerarquicaDAO.save(practicaAreaJerarquica);
        return ResponseEntity.ok(resultado);
    }





    
    private void _validarPractica(Practica practica) throws ABMPracticaException {
        if (!"S".equals(practica.getPedible()) && !"N".equals(practica.getPedible())) {
            throw new ABMPracticaException("Campo Pedible invalido.");
        } else if (!"S".equals(practica.getRefinaMuestras()) && !"N".equals(practica.getRefinaMuestras())) {
            throw new ABMPracticaException("Campo Refina Muestras invalido.");
        } else if (!"S".equals(practica.getVisible()) && !"N".equals(practica.getVisible())) {
            throw new ABMPracticaException("Campo Visible invalido.");
        }
    }
}
