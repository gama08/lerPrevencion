package com.lerprevencion.prueba.persona.aplicacion;

import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

public class EliminarPersona {

    private PersonaRepositorio personaRepositorio;

    public EliminarPersona(PersonaRepositorio personaRepositorio){
        this.personaRepositorio = personaRepositorio;
    }

    public void eliminar(String numeroCedula){
        if (numeroCedula != null) {
            this.personaRepositorio.eliminar(numeroCedula);
        }
    }
}
