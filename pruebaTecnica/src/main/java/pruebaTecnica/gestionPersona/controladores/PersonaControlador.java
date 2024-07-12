package pruebaTecnica.gestionPersona.controladores;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import pruebaTecnica.gestionPersona.dto.PersonaDTO;
import pruebaTecnica.gestionPersona.modelos.Persona;
import pruebaTecnica.gestionPersona.servicios.PersonaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/personas")
public class PersonaControlador {

    private PersonaService personaService;

    @GetMapping
    public List<PersonaDTO> obtenerListadoPersonas(
        @RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "10") int tamanio
    ){

        Pageable pageable = PageRequest.of(pagina, tamanio);
        Page<Persona> personaPage = personaService.obtenerListadoPersonas(pageable);
        return personaPage.getContent().stream().map(this::convertirAModeloDTO).collect(Collectors.toList());
        
    }

    private PersonaDTO convertirAModeloDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setNumeroCedulaPersona(persona.getNumeroCedulaPersona());
        personaDTO.setNombrePersona(persona.getNombrePersona());
        personaDTO.setFechaNacimientoPersona(persona.getFechaNacimientoPersona());
        return personaDTO;
    }

    private Persona convertirADominio(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNumeroCedulaPersona(personaDTO.getNumeroCedulaPersona());
        persona.setNombrePersona(personaDTO.getNombrePersona());
        persona.setFechaNacimientoPersona(personaDTO.getFechaNacimientoPersona());
        return persona;
    }
}
