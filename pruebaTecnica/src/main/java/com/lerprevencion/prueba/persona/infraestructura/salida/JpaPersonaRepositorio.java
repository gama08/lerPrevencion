package com.lerprevencion.prueba.persona.infraestructura.salida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void guardar(Persona persona) {

        PersonaEntidad personaEntidad = new PersonaEntidad();
        personaEntidad.setNumeroCedulaPersona(persona.getNumeroCedula());
        personaEntidad.setNombrePersona(persona.getNombre());
        personaEntidad.setFechaNacimientoPersona(persona.getFechaNacimiento());
        entityManager.persist(personaEntidad);
        entityManager.flush();
    }

    @Transactional
    @Override
    public void modificar(Persona persona) {
        PersonaEntidad personaEntidad = new PersonaEntidad();
        personaEntidad.setNumeroCedulaPersona(persona.getNumeroCedula());
        personaEntidad.setNombrePersona(persona.getNombre());
        personaEntidad.setFechaNacimientoPersona(persona.getFechaNacimiento());
        entityManager.merge(personaEntidad);
    }

    @Override
    public List<Persona> consultarTodos(Criterio criterio) {
        List<Persona> listaPersonas = new ArrayList<>(0);
        String consultaSql = "select p from PersonaEntidad p";
        if (criterio.getCampo() != null && criterio.getValor() != null) {
            consultaSql += " where p." + criterio.getCampo() + " = '" + criterio.getValor() + "'";
        }

        if (criterio.getOrden() != null && criterio.getCampoOrden() != null) {
            consultaSql += " order by p." + criterio.getCampoOrden() + " "  + criterio.getOrden();
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

    @Transactional
    @Override
    public void eliminar(String numeroCedula) {
        PersonaEntidad personaEntidad = entityManager.find(PersonaEntidad.class, numeroCedula);
        if (personaEntidad != null) {
            entityManager.remove(personaEntidad);
        } else {
            throw new IllegalArgumentException("No se encontró la persona con número de cédula: " + numeroCedula);
        }
    }

}
