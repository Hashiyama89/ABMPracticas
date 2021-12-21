/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.federicopuente.abmpracticaapi.manager;

import com.federicopuente.abmpracticaapi.dao.AreaJerarquicaDAO;
import com.federicopuente.abmpracticaapi.dao.PracticaAreaJerarquicaDAO;
import com.federicopuente.abmpracticaapi.entity.AreaJerarquica;
import com.federicopuente.abmpracticaapi.entity.PracticaAreaJerarquica;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("areajerarquica")
public class AreaJerarquicaManager {
    
    @Autowired
    private AreaJerarquicaDAO areaJerarquicaDAO;
    
    @Autowired
    private PracticaAreaJerarquicaDAO practicaAreaJerarquicaDAO;

    @PostMapping
    public ResponseEntity<List<AreaJerarquica>> listarAreasJerarquicas(@RequestBody Optional<AreaJerarquica> areaJerarquica) {
        ResponseEntity<List<AreaJerarquica>> respuesta = null;
        if (areaJerarquica.isPresent()) {
            respuesta = ResponseEntity.ok(this.areaJerarquicaDAO.findByDescripcionLike(areaJerarquica.get().getDescripcion()));
        } else {
            respuesta = ResponseEntity.ok(this.areaJerarquicaDAO.findAll());            
        }
        return respuesta;
    }
    
    @PostMapping(value="practica/{idPractica}")
    public ResponseEntity<List<PracticaAreaJerarquica>> listarAreasJerarquicasPorPractica(@PathVariable("idPractica") Integer idPractica) {
        ResponseEntity<List<PracticaAreaJerarquica>> respuesta =
                ResponseEntity.ok(this.practicaAreaJerarquicaDAO.findByIdPractica(idPractica));            
        return respuesta;
    }

}
