export class PersonaModel {

  numeroCedula: string;
  nombre: string;
  fechaNacimiento:Date;

  constructor(numeroCedula: string, nombre: string, fechaNacimiento:Date){
    this.numeroCedula = numeroCedula;
    this.nombre = nombre;
    this.fechaNacimiento = fechaNacimiento;
  }

}
