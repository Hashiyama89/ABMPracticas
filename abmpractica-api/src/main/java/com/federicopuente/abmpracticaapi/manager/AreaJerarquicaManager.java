/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.federicopuente.abmpracticaapi.manager;

import com.federicopuente.abmpracticaapi.dao.AreaJerarquicaDAO;
import com.federicopuente.abmpracticaapi.entity.AreaJerarquica;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("areajerarquica")
public class AreaJerarquicaManager {
    
    @Autowired
    private AreaJerarquicaDAO areaJerarquicaDAO;

    
    @PostMapping
    public ResponseEntity<List<AreaJerarquica>> listarPracticas(@RequestBody Optional<AreaJerarquica> areaJerarquica) {
        ResponseEntity<List<AreaJerarquica>> respuesta = null;
        if (areaJerarquica.isPresent()) {
            respuesta = ResponseEntity.ok(this.areaJerarquicaDAO.findAll(Example.of(areaJerarquica.get())));
        } else {
            respuesta = ResponseEntity.ok(this.areaJerarquicaDAO.findAll());            
        }
        return respuesta;
    }

}
