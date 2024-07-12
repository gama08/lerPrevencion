package com.lerprevencion.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.lerprevencion.prueba")
public class PruebaLerPrevencionAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(PruebaLerPrevencionAplicacion.class, args);
    }
}
