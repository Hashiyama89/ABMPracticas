package com.federicopuente.abmpracticaapi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "practica_area_jerarquica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracticaAreaJerarquica.findByIdPractica", query = "SELECT p FROM PracticaAreaJerarquica p where id_practica = :idPractica")})
public class PracticaAreaJerarquica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_practica_area")
    private Integer idPracticaArea;
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne
    private AreaJerarquica idArea;
    @JoinColumn(name = "id_practica", referencedColumnName = "id_practica")
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Practica idPractica;

    public PracticaAreaJerarquica() {
    }

    public PracticaAreaJerarquica(Integer idPracticaArea) {
        this.idPracticaArea = idPracticaArea;
    }

    public Integer getIdPracticaArea() {
        return idPracticaArea;
    }

    public void setIdPracticaArea(Integer idPracticaArea) {
        this.idPracticaArea = idPracticaArea;
    }

    public AreaJerarquica getIdArea() {
        return idArea;
    }

    public void setIdArea(AreaJerarquica idArea) {
        this.idArea = idArea;
    }

    public Practica getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(Practica idPractica) {
        this.idPractica = idPractica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPracticaArea != null ? idPracticaArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PracticaAreaJerarquica)) {
            return false;
        }
        PracticaAreaJerarquica other = (PracticaAreaJerarquica) object;
        if ((this.idPracticaArea == null && other.idPracticaArea != null) || (this.idPracticaArea != null && !this.idPracticaArea.equals(other.idPracticaArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.federicopuente.abmpracticaapi.entity.PracticaAreaJerarquica[ idPracticaArea=" + idPracticaArea + " ]";
    }
    
}
