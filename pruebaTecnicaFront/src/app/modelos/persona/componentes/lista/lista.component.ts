import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ConsultarPersonasService } from '../../servicios/consultar-personas.service';
import { PersonaModel } from '../../modelos/persona.model';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EliminarPersonaService } from '../../servicios/eliminar.persona.service';
import { ModalService } from '../../../../centro/modal.service';

@Component({
  selector: 'app-lista',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css'
})
export class ListaComponent implements OnInit{

  public listaPersona:PersonaModel [] = [];
  titulo:string = "Lista de Personas";

  constructor(
    private _consultarPersonasService: ConsultarPersonasService,
    private _eliminarPersonaService: EliminarPersonaService,
    private _modalService:ModalService
  ){
  }
  ngOnInit(): void {
    this._consultarPersonasService.consultarPersonas().subscribe( (respuesta)=>{
      this.listaPersona = respuesta;
      this._modalService.mostrarModal("Exitoso!!", "Personas Cargadas Exitosamente.")
    })
  }

  clickEliminarPersona(numeroCedula:string){
    this._eliminarPersonaService.eliminarPersona(numeroCedula).subscribe(
      respuesta =>{
        this._modalService.mostrarModalEliminar("Exitoso!!",`Persona con Número de Cedula ${numeroCedula} Eliminado Correctamente.`);
      }
    );
  }

}
