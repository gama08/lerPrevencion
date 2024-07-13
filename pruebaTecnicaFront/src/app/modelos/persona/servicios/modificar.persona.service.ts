import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PersonaModel } from '../modelos/persona.model';

@Injectable({
  providedIn: 'root'
})
export class ModificarPersonaService {

  private urlEndPointModificarPersona: string = "http://localhost:8080/api/persona/modificar";

  private httpEncabezado: HttpHeaders =  new HttpHeaders({ 'content-tye': 'aplication/json; charset=utf-8' });

  constructor(private http:HttpClient) { }

  modificarPersona(persona: PersonaModel){
    return this.http.put(this.urlEndPointModificarPersona, persona,{ headers: this.httpEncabezado });
  }
}
