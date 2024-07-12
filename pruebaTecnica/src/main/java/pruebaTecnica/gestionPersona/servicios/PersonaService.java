package pruebaTecnica.gestionPersona.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import pruebaTecnica.gestionPersona.modelos.Persona;
import pruebaTecnica.gestionPersona.repositorios.PersonaRepositorio;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    public Page<Persona> obtenerListadoPersonas(Pageable pageable){

        return personaRepositorio.findAll(pageable);
    }

    public Persona guardarPersona(Persona persona){

        return personaRepositorio.save(persona);
    }
    
    public Persona actualizarPersona(Persona  persona){

        return personaRepositorio.save(persona);
    }

    public void eliminarPersona (Long numeroCedulaPersona){

        personaRepositorio.deleteById(numeroCedulaPersona);
    }

}
