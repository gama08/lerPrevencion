package com.lerprevencion.prueba.persona.infraestructura.entrada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lerprevencion.prueba.persona.aplicacion.ModificarPersona;
import com.lerprevencion.prueba.persona.dominio.Persona;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/persona/modificar")
public class PutModificarPersonaControlador {

    @Autowired
    private ModificarPersona modificarPersona;

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modificar (@RequestBody Persona persona){
        modificarPersona.modificar(persona);
    }
}
