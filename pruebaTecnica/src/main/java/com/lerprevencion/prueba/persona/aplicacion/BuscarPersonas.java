package com.lerprevencion.prueba.persona.aplicacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lerprevencion.prueba.persona.dominio.Criterio;
import com.lerprevencion.prueba.persona.dominio.Persona;
import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

@Service
public class BuscarPersonas {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public List<Persona> buscar(Criterio criterio){
        return personaRepositorio.consultarTodos(criterio);
    }

}
