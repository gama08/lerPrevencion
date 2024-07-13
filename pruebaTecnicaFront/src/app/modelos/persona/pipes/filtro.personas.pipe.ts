import { Pipe, PipeTransform } from '@angular/core';
import { PersonaModel } from '../modelos/persona.model';

@Pipe({
  name: 'filtroPersonas',
  standalone: true
})
export class FiltroPersonasPipe implements PipeTransform {

  transform(personas: PersonaModel[], filtro: any, orden:string): any {
    if (!personas || !filtro) {
      return personas;
    }

    // Aplicar filtro
    let personasFiltradas = personas.filter(persona =>
      persona.numeroCedula.includes(filtro.numeroCedula ?? '') &&
      persona.nombre.toLowerCase().includes(filtro.nombre?.toLowerCase() ?? '') &&
      (filtro.fechaNacimiento ? persona.fechaNacimiento === filtro.fechaNacimiento : true)
    );
        // Aplicar ordenamiento si hay orden especificado
    if (orden === 'asc') {
      personasFiltradas.sort((a, b) => {
        return new Date(a.fechaNacimiento).getTime() - new Date(b.fechaNacimiento).getTime();
      });
    } else if (orden === 'desc') {
      personasFiltradas.sort((a, b) => {
        return new Date(b.fechaNacimiento).getTime() - new Date(a.fechaNacimiento).getTime();
      });
    };
    return personasFiltradas;
  }

}
