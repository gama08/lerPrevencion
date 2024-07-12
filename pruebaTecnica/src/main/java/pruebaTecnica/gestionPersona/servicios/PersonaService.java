package pruebaTecnica.gestionPersona.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lerprevencion.prueba.persona.infraestructura.JpaPersonaRepositorio;
import com.lerprevencion.prueba.persona.infraestructura.PersonaEntidad;

@Service
public class PersonaService {

    @Autowired
    private JpaPersonaRepositorio personaRepositorio;

    public Page<PersonaEntidad> obtenerListadoPersonas(Pageable pageable){

        return personaRepositorio.findAll(pageable);
    }

    public PersonaEntidad guardarPersona(PersonaEntidad persona){

        return personaRepositorio.save(persona);
    }
    
    public PersonaEntidad actualizarPersona(PersonaEntidad  persona){

        return personaRepositorio.save(persona);
    }

    public void eliminarPersona (Long numeroCedulaPersona){

        personaRepositorio.deleteById(numeroCedulaPersona);
    }

}
