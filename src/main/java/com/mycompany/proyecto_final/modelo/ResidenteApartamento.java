
package com.mycompany.proyecto_final.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "residente_apartamento")
public class ResidenteApartamento implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResidenteApartamento;
    
    @ManyToOne
    @JoinColumn(name = "residente")
    private Persona residente;
    
    @ManyToOne
    @JoinColumn(name = "apartamento")
    private Apartamento apartamento;
    
    @Column(name = "fecha_inicio")
    private Date fechaInicio = null;
    
    @Column(name = "fecha_fin")
    private Date fechaFin = null;

    public ResidenteApartamento() {
    }

    public ResidenteApartamento(Persona residente, Apartamento apartamento) {
        this.residente = residente;
        this.apartamento = apartamento;
    }

    public Integer getIdResidenteApartamento() {
        return idResidenteApartamento;
    }

    public void setIdResidenteApartamento(Integer idResidenteApartamento) {
        this.idResidenteApartamento = idResidenteApartamento;
    }

    public Persona getResidente() {
        return residente;
    }

    public void setResidente(Persona residente) {
        this.residente = residente;
    }

    public Apartamento getApartamento() {
        return apartamento;
    }

    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
