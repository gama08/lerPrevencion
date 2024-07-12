package com.lerprevencion.prueba.persona.infraestructura.entrada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lerprevencion.prueba.persona.aplicacion.EliminarPersona;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/persona/eliminar")
public class EliminarPersonaControlador {

    @Autowired
    private EliminarPersona eliminarPersona;

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(String numeroCedula){

        eliminarPersona.eliminar(numeroCedula);

    }

}
