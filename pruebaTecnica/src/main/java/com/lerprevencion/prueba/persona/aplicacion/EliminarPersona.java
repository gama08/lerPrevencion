package com.lerprevencion.prueba.persona.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

@Service
public class EliminarPersona {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public void eliminar(String numeroCedula){
        if (numeroCedula != null) {
            this.personaRepositorio.eliminar(numeroCedula);
        }else {
            throw new IllegalArgumentException("El número de cédula no puede ser nulo");
        }
    }
}
