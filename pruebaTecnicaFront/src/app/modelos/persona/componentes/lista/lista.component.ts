import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ConsultarPersonasService } from '../../servicios/consultar-personas.service';
import { PersonaModel } from '../../modelos/persona.model';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EliminarPersonaService } from '../../servicios/eliminar.persona.service';
import { ModalService } from '../../../../centro/modal.service';
import { FiltroPersonasPipe } from '../../pipes/filtro.personas.pipe';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-lista',
  standalone: true,
  imports: [CommonModule, RouterLink, FiltroPersonasPipe, ReactiveFormsModule],
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css'
})
export class ListaComponent implements OnInit{

  public listaPersona:PersonaModel [] = [];
  titulo:string = "Lista de Personas";
  filtroForm: FormGroup = this.formBuiler.group({
    numeroCedula: [''],
    nombre: [''],
    fechaNacimiento: ['']
  });
  orden: string = '';

  constructor(
    private _consultarPersonasService: ConsultarPersonasService,
    private _eliminarPersonaService: EliminarPersonaService,
    private _modalService:ModalService,
    private formBuiler: FormBuilder
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

  tipoOrden(event:Event){
    const selectElement = event.target as HTMLSelectElement;
    const selectedValue = selectElement.value;
    this.orden = selectedValue;
    console.log("this.orden: ", this.orden);
  }

}
