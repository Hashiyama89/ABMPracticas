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
@Table(name = "practica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practica.findAll", query = "SELECT p FROM Practica p"),
    @NamedQuery(name = "Practica.findByIdPractica", query = "SELECT p FROM Practica p WHERE p.idPractica = :idPractica")})
public class Practica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_practica")
    private Integer idPractica;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "pedible")
    private String pedible;
    @Basic(optional = false)
    @Column(name = "visible")
    private String visible;
    @Basic(optional = false)
    @Column(name = "refina_muestras")
    private String refinaMuestras;

    public Practica() {
    }

    public Practica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public Practica(Integer idPractica, String descripcion, String pedible, String visible, String refinaMuestras) {
        this.idPractica = idPractica;
        this.descripcion = descripcion;
        this.pedible = pedible;
        this.visible = visible;
        this.refinaMuestras = refinaMuestras;
    }

    public Integer getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(Integer idPractica) {
        this.idPractica = idPractica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPedible() {
        return pedible;
    }

    public void setPedible(String pedible) {
        this.pedible = pedible;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getRefinaMuestras() {
        return refinaMuestras;
    }

    public void setRefinaMuestras(String refinaMuestras) {
        this.refinaMuestras = refinaMuestras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPractica != null ? idPractica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Practica)) {
            return false;
        }
        Practica other = (Practica) object;
        if ((this.idPractica == null && other.idPractica != null) || (this.idPractica != null && !this.idPractica.equals(other.idPractica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Practica { "
                + "idPractica: "+this.idPractica
                + ",descripcion: "+this.descripcion
                + ",pedible: "+this.pedible
                + ",refinaMuestras: "+this.refinaMuestras
                + ",visible: "+this.visible
                +"}";
    }
    
}
