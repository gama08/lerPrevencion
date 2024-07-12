package pruebaTecnica.gestionPersona.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pruebaTecnica.gestionPersona.modelos.Persona;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Long>{

}
