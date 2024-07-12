package com.lerprevencion.prueba.persona.infraestructura.salida;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "persona")
public class PersonaEntidad implements Serializable{

    @Id
    @Column(name = "numero_cedula")
    private String numeroCedulaPersona;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombrePersona;
    

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimientoPersona;

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getNumeroCedulaPersona() {
        return numeroCedulaPersona;
    }

    public void setNumeroCedulaPersona(String numeroCedulaPersona) {
        this.numeroCedulaPersona = numeroCedulaPersona;
    }

    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }



}
