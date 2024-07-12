package com.lerprevencion.prueba.persona.aplicacion;

import java.util.List;

import com.lerprevencion.prueba.persona.dominio.Criterio;
import com.lerprevencion.prueba.persona.dominio.Persona;
import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

public class BuscarPersonas {

    private PersonaRepositorio personaRepositorio;

    public BuscarPersonas(PersonaRepositorio personaRepositorio){
        this.personaRepositorio = personaRepositorio;
    }

    public List<Persona> buscar(Criterio criterio){
        return personaRepositorio.consultarTodos(criterio);
    }

}
