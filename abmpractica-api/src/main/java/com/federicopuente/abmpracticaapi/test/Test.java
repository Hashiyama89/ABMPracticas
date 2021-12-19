/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.federicopuente.abmpracticaapi.test;

import com.federicopuente.abmpracticaapi.dao.PracticaDAO;
import com.federicopuente.abmpracticaapi.entity.Practica;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author macbookretina
 */
@RestController
@RequestMapping("practicas")
public class Test {
    
    @Autowired
    private PracticaDAO practicaDAO;
    @GetMapping
    public ResponseEntity<List<Practica>> getPracticas() {
        return ResponseEntity.ok(this.practicaDAO.findAll());
    }
    
    @RequestMapping(value="{practicaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Practica> getPractica(@PathVariable("practicaId") Integer practicaId) {
        Optional<Practica> practica = this.practicaDAO.findById(practicaId);
        if (practica.isPresent()) {
            System.out.println("asdasdasd: "+practica);
                    
            System.out.println("qweqweqwe: "+practica.get());
            return ResponseEntity.ok(practica.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
//    @GetMapping
//    public String test() {
//        return "Hello world";
//    }
//    
//    @RequestMapping(value="test2", method=RequestMethod.GET)
//    public String test2() {
//        return "Testando dos";
//    }
    
}
