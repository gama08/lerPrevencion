package pruebaTecnica.gestionPersona.dto;

import java.util.Date;

public class PersonaDTO {


    private Integer idPersona;
    private String nombrePersona;
    private String numeroCedulaPersona;
    private Date fechaNacimientoPersona;

    
    public String getNombrePersona() {
        return nombrePersona;
    }
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
    public String getNumeroCedulaPersona() {
        return numeroCedulaPersona;
    }
    public void setNumeroCedulaPersona(String numeroCedulaPersona) {
        this.numeroCedulaPersona = numeroCedulaPersona;
    }
    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }
    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    
}
