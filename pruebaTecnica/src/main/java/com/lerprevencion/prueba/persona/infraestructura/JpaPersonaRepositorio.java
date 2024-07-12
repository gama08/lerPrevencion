package com.lerprevencion.prueba.persona.infraestructura;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lerprevencion.prueba.persona.dominio.Criterio;
import com.lerprevencion.prueba.persona.dominio.Persona;
import com.lerprevencion.prueba.persona.dominio.PersonaRepositorio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class JpaPersonaRepositorio implements PersonaRepositorio{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Persona persona) {

        PersonaEntidad personaEntidad = new PersonaEntidad();
        personaEntidad.setNumeroCedulaPersona(persona.getNumeroCedula());
        personaEntidad.setNombrePersona(persona.getNombre());
        personaEntidad.setFechaNacimientoPersona(persona.getFechaNacimiento());
        entityManager.persist(personaEntidad);
        entityManager.flush();
    }

    @Override
    public List<Persona> consultarTodos(Criterio criterio) {
        List<Persona> listaPersonas = new ArrayList<>(0);
        String consultaSql = "select p from persona p";
        if (criterio.getCampo() != null && criterio.getValor() != null) {
            consultaSql += " where p." + criterio.getCampo() + " = '" + criterio.getValor() + "'";
        }

        if (criterio.getOrden() != null) {
            consultaSql += " order by " + criterio.getOrden();
        }
        TypedQuery<PersonaEntidad> resultadoConsulta = entityManager.createQuery(consultaSql, PersonaEntidad.class);
        for(PersonaEntidad personaEntidad: resultadoConsulta.getResultList()){
            listaPersonas.add(
                new Persona(
                    personaEntidad.getNumeroCedulaPersona(), 
                    personaEntidad.getNombrePersona(), 
                    personaEntidad.getFechaNacimientoPersona()
                )
                
            );
        }

        return listaPersonas;
    }

    @Override
    public void eliminar(String numeroCedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
