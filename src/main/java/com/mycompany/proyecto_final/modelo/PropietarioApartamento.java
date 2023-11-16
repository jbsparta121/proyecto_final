
package com.mycompany.proyecto_final.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "propietario_apartamento")
public class PropietarioApartamento implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropietarioApartamento;
    
    @ManyToOne
    @JoinColumn(name = "propietario")
    private Persona propietario;
    
    @ManyToOne
    @JoinColumn(name = "apartamento")
    private Apartamento apartamento;
    
    @Column(name = "fecha_compra")
    private Date fechaCompra = null;

    public PropietarioApartamento() {
    }

    public PropietarioApartamento(Persona propietario, Apartamento apartamento) {
        this.propietario = propietario;
        this.apartamento = apartamento;
    }

    public Integer getIdPropietarioApartamento() {
        return idPropietarioApartamento;
    }

    public void setIdPropietarioApartamento(Integer idPropietarioApartamento) {
        this.idPropietarioApartamento = idPropietarioApartamento;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
