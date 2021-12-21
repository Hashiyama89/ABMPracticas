package com.federicopuente.abmpracticaapi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "area_jerarquica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaJerarquica.findAll", query = "SELECT a FROM AreaJerarquica a"),
    @NamedQuery(name = "AreaJerarquica.findByIdArea", query = "SELECT a FROM AreaJerarquica a WHERE a.idArea = :idArea"),
    @NamedQuery(name = "AreaJerarquica.findByDescripcionLike", query = "SELECT a FROM AreaJerarquica a where descripcion like CONCAT('%',:descripcion,'%')")
})

public class AreaJerarquica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    public AreaJerarquica() {
    }

    public AreaJerarquica(Integer idArea) {
        this.idArea = idArea;
    }

    public AreaJerarquica(Integer idArea, String descripcion) {
        this.idArea = idArea;
        this.descripcion = descripcion;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof AreaJerarquica)) {
            return false;
        }
        AreaJerarquica other = (AreaJerarquica) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.federicopuente.abmpracticaapi.entity.AreaJerarquica[ idArea=" + idArea + " ]";
    }
    
}
