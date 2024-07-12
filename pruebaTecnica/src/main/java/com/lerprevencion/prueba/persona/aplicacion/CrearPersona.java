package com.lerprevencion.prueba.persona.aplicacion;

import org.springframework.stereotype.Service;

import com.lerprevencion.prueba.persona.dominio.Persona;
import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

@Service
public class CrearPersona {

    private PersonaRepositorio personaRepositorio;

    public CrearPersona (PersonaRepositorio personaRepositorio){
        this.personaRepositorio = personaRepositorio;
    }

    public void crear(Persona persona){
        personaRepositorio.guardar(persona);
    }

}
