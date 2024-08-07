import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { PersonaModel } from '../../modelos/persona.model';
import { CrearPersonaService } from '../../servicios/crear.persona.service';
import { ActivatedRoute } from '@angular/router';
import { ConsultarPersonasService } from '../../servicios/consultar-personas.service';
import { ModificarPersonaService } from '../../servicios/modificar.persona.service';
import { ModalService } from '../../../../centro/modal.service';
import { CargandoComponent } from '../../../../compartido/cargando/cargando.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-crear-actualizar',
  standalone: true,
  imports: [ReactiveFormsModule, CargandoComponent,CommonModule],
  templateUrl: './crear-actualizar.component.html',
  styleUrl: './crear-actualizar.component.css'
})
export class CrearActualizarComponent implements OnInit{

  private tituloActualizar:string = "Actualizar Persona";
  titulo:string = "Crear Persona";
  nombreboton: string = "";
  personaModel!:PersonaModel;
  cargando:boolean = false;



  constructor(
    private formBuilder: FormBuilder,
    private _crearPersonaService:CrearPersonaService,
    private activateRouter:ActivatedRoute,
    private _consultarPersonasService: ConsultarPersonasService,
    private _modificarPersonaService:ModificarPersonaService,
    private _modalService:ModalService
  ){

  }
  ngOnInit(): void {
    this.nombreboton = "Guardar";
    this.personaConsultarPorCedulaParaActualizar();
  }

  formularioPersona = this.formBuilder.group({
    numeroCedula: ["", {
      validators: [Validators.required, Validators.minLength(6), Validators.maxLength(12)],
    }],
    nombre: ["", {
      validators: [Validators.required, Validators.minLength(3), Validators.maxLength(40)],
    }],
    fechaNacimiento: ["", {
      validators: [Validators.required],
    }],
  });

  personaGuardar(){

    const numeroCedula = this.formularioPersona.get('numeroCedula')?.value as string;
    const nombre = this.formularioPersona.get('nombre')?.value as string;
    const fechaNacimiento: Date  = this.formularioPersona.get('fechaNacimiento')?.value as any;

    if (numeroCedula && nombre && fechaNacimiento) {

      const personaModel: PersonaModel = new PersonaModel(
        numeroCedula,
        nombre,
        fechaNacimiento
      );
      if(this.titulo === this.tituloActualizar){
        this.cargando = true;
        this._modificarPersonaService.modificarPersona(personaModel).subscribe(respuesta =>{
          this.cargando = false;
          this._modalService.mostrarModal("Exitoso!!", "Persona Actualizada Correctamente.", "/listaPersonas");
        }, error => {
          this.cargando = false;
          this._modalService.mostrarModal("Error!!", "No fue Posible Actualizar la Persona");
        });
      }else{
        this.cargando = true;
        this._crearPersonaService.crearPersona(personaModel).subscribe(respuesta => {
          this.cargando = false;
          this._modalService.mostrarModal("Exitoso!!", "Persona Creada Correctamente.", "/listaPersonas");
        }, error => {
          this.cargando = false;
          this._modalService.mostrarModal("Error!!", "No fue Posible Crear la Persona");
        });
      }
    };
    this.cargando = false;

  };

  personaConsultarPorCedulaParaActualizar(): void {

    this.activateRouter.params.subscribe(params => {

      let numeroCedula = params["numeroCedula"];
      if (numeroCedula) {
        this.cargando = true;
        this._consultarPersonasService.consultarPersonas("numeroCedulaPersona", numeroCedula).subscribe(
          (respuesta: PersonaModel[]) => {
            this.titulo = this.tituloActualizar;
            this.nombreboton = "Actualizar";

            if (respuesta.length > 0) {
              let persona = respuesta[0];

              this.personaModel = new PersonaModel(persona.numeroCedula, persona.nombre, new Date(persona.fechaNacimiento));

              this.formularioPersona.get('numeroCedula')?.setValue(this.personaModel.numeroCedula);
              this.formularioPersona.get('numeroCedula')?.disable();
              this.formularioPersona.get('nombre')?.setValue(this.personaModel.nombre);

              const fechaNacimientoString = this.personaModel.fechaNacimiento.toISOString().substring(0, 10);
              this.formularioPersona.get('fechaNacimiento')?.setValue(fechaNacimientoString);
            }
            this.cargando = false;
            this._modalService.mostrarModal("Exitoso!!", `Persona con Cedula de Ciudadania ${this.personaModel.numeroCedula} Cargada Exitosamente.`)
          },
          (error)=>{
            this.cargando = false;
            this._modalService.mostrarModal("Error!!", `No fue Posible Cargar la Persona con Cedula de Ciudadania ${numeroCedula}.`)

          }
        );
      };
    });

  }

}
