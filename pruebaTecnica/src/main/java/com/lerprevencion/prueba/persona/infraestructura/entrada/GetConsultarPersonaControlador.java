package com.lerprevencion.prueba.persona.infraestructura.entrada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lerprevencion.prueba.persona.aplicacion.BuscarPersonas;
import com.lerprevencion.prueba.persona.dominio.Criterio;
import com.lerprevencion.prueba.persona.dominio.Persona;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/persona/consultar")
public class GetConsultarPersonaControlador {

    @Autowired
    private BuscarPersonas buscarPersonas;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> consultar(
        @RequestParam(required = false) String campo,
        @RequestParam(required = false) Object valor,
        @RequestParam(required = false) String orden,
        @RequestParam(required = false) String campoOrden
    ){
        Criterio criterio = new Criterio();
        criterio.setCampo(campo);
        criterio.setValor(valor);
        criterio.setOrden(orden);
        criterio.setCampoOrden(campoOrden);
        
        return  buscarPersonas.buscar(criterio);
        
    }
}
