package com.federicopuente.abmpracticaapi.dao;

import com.federicopuente.abmpracticaapi.entity.AreaJerarquica;
import com.federicopuente.abmpracticaapi.entity.PracticaAreaJerarquica;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PracticaAreaJerarquicaDAO extends JpaRepository<PracticaAreaJerarquica , Integer> {
       public List<PracticaAreaJerarquica> findByIdPractica(Integer idPractica);
}
