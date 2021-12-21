package com.federicopuente.abmpracticaapi.dao;

import com.federicopuente.abmpracticaapi.entity.AreaJerarquica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaJerarquicaDAO extends JpaRepository<AreaJerarquica , Integer> {
    
    public List<AreaJerarquica> findByDescripcionLike(String descripcion);
    
}
