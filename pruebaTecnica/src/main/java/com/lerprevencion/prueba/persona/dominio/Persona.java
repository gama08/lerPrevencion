package com.lerprevencion.prueba.persona.dominio;

import java.util.Date;

public class Persona {

    private String nombre;
    private String numeroCedula;
    private Date fechaNacimiento;

    public Persona (String numeroCedula, String nombre, Date fechaNacimiento){
        this.numeroCedula = numeroCedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    
}
