import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ConsultarPersonasService } from '../../servicios/consultar-personas.service';
import { PersonaModel } from '../../modelos/persona.model';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EliminarPersonaService } from '../../servicios/eliminar.persona.service';
import { ModalService } from '../../../../centro/modal.service';
import { FiltroPersonasPipe } from '../../pipes/filtro.personas.pipe';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { CargandoComponent } from '../../../../compartido/cargando/cargando.component';

@Component({
  selector: 'app-lista',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    FiltroPersonasPipe,
    ReactiveFormsModule,
    NgxPaginationModule,
    CargandoComponent

  ],
  templateUrl: './lista.component.html',
  styleUrl: './lista.component.css'
})
export class ListaComponent implements OnInit{

  public listaPersona:PersonaModel [] = [];
  public pagina !: number;
  titulo:string = "Lista de Personas";
  filtroForm: FormGroup = this.formBuiler.group({
    numeroCedula: [''],
    nombre: [''],
    fechaNacimiento: ['']
  });
  orden: string = '';
  cargando:boolean = false;

  constructor(
    private _consultarPersonasService: ConsultarPersonasService,
    private _eliminarPersonaService: EliminarPersonaService,
    private _modalService:ModalService,
    private formBuiler: FormBuilder
  ){
  }
  ngOnInit(): void {
    this.cargando = true;
    this._consultarPersonasService.consultarPersonas().subscribe(
      (respuesta)=>{
      this.listaPersona = respuesta;
      this.cargando = false;
      this._modalService.mostrarModal("Exitoso!!", "Personas Cargadas Exitosamente.")
      },
      (error)=>{
        this.cargando = false;
        this._modalService.mostrarModal("Error!!", "No fue Posbile Cargar Personas.");
      }
    )
  }

  clickEliminarPersona(numeroCedula:string){
    this.cargando = true;
    this._eliminarPersonaService.eliminarPersona(numeroCedula).subscribe(
      (respuesta) =>{
        this.cargando = false;
        this._modalService.mostrarModalEliminar("Exitoso!!",`Persona con Número de Cedula ${numeroCedula} Eliminado Correctamente.`);
      },
      (error) =>{
        this.cargando = false;
        this._modalService.mostrarModal("Error!!", `No fue Posible Eliminar la Persona con Número de Cedula ${numeroCedula}.`);
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
