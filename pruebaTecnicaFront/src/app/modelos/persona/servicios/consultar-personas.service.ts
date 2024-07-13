import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PersonaModel } from '../modelos/persona.model';

@Injectable({
  providedIn: 'root'
})
export class ConsultarPersonasService {

  private urlEndPointConsultarPersonas: string = "http://localhost:8080/api/persona/consultar";

  private httpEncabezado: HttpHeaders =  new HttpHeaders({ 'content-tye': 'aplication/json; charset=utf-8' });

  constructor(private http:HttpClient) { }

  consultarPersonas(campo?: string, valor?: string): Observable<PersonaModel[]> {
    let params = new HttpParams();
    if (campo && valor) {
      params = params.set('campo', campo);
      params = params.set('valor', valor);
    }
    return this.http.get<PersonaModel[]>(this.urlEndPointConsultarPersonas, { params, headers: this.httpEncabezado });
  }
}
