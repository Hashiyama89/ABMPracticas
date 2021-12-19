package com.federicopuente.abmpracticaapi.dao;

import com.federicopuente.abmpracticaapi.entity.Practica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticaDAO extends JpaRepository<Practica , Integer> {
    
}
