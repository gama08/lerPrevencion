package com.lerprevencion.prueba.persona.dominio;

import java.util.List;

public interface PersonaRepositorio{

    public void guardar(Persona persona);
    public void modificar(Persona persona);
    public List<Persona> consultarTodos(Criterio criterio);
    public void eliminar(String numeroCedula);
}
