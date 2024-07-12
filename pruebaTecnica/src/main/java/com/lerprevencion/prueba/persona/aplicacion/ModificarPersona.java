package com.lerprevencion.prueba.persona.aplicacion;

import org.springframework.stereotype.Service;

import com.lerprevencion.prueba.persona.dominio.Persona;
import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

@Service
public class ModificarPersona {

    //Inyectar dependencia, dependencia es algo que necesito o requiero utilizar.
    private PersonaRepositorio personaRepositorio;

    public ModificarPersona(PersonaRepositorio personaRepositorio){
        this.personaRepositorio = personaRepositorio;
    }

    public void modificar(Persona persona){
        if (persona.getNumeroCedula() != null) {
            personaRepositorio.guardar(persona);
        }
    }

}
