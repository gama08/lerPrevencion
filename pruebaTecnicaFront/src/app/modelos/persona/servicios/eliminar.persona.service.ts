import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EliminarPersonaService {
  private urlEndPointModificarPersona: string = "http://localhost:8080/api/persona/eliminar";

  private httpEncabezado: HttpHeaders =  new HttpHeaders({ 'content-tye': 'aplication/json; charset=utf-8' });

  constructor(private http:HttpClient) { }

  eliminarPersona(numeroCedula: string){
    return this.http.delete(`${this.urlEndPointModificarPersona}?numeroCedula=${numeroCedula}`,{ headers: this.httpEncabezado });
  }
}
