package com.lerprevencion.prueba.persona.infraestructura.entrada;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lerprevencion.prueba.persona.aplicacion.CrearPersona;
import com.lerprevencion.prueba.persona.dominio.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/persona/crear")
public class PostCrearPersonaControlador {
    
    @Autowired
    private CrearPersona crearPersona;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody Persona persona){
        crearPersona.crear(persona);
    }  

}
