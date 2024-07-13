import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PersonaModel } from '../modelos/persona.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrearPersonaService {
  private urlEndPointCrearPersona: string = "http://localhost:8080/api/persona/crear";

  private httpEncabezado: HttpHeaders =  new HttpHeaders({ 'content-tye': 'aplication/json; charset=utf-8' });

  constructor(private http:HttpClient) { }

  crearPersona(persona: PersonaModel){
    return this.http.post(this.urlEndPointCrearPersona, persona,{ headers: this.httpEncabezado });
  }
}
