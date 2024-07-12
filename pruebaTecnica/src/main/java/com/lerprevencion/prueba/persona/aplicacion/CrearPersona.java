package com.lerprevencion.prueba.persona.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lerprevencion.prueba.persona.dominio.Persona;
import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

@Service
public class CrearPersona {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public void crear(Persona persona){
        personaRepositorio.guardar(persona);
    }

}
