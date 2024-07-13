import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  constructor(private router: Router) { }

  mostrarModal(titulo:string, texto:string, navegar?:string){
    return Swal.fire({
      title: titulo,
      text: texto,
      allowOutsideClick: false,
      confirmButtonText: 'Aceptar'
    }).then((result)=>{
      if(result.isConfirmed){
        if(navegar){
          this.router.navigate([navegar])
        }
      }
    });
  };

  mostrarModalEliminar(titulo:string, texto:string){
    Swal.fire({
      title: titulo,
      text: texto,
      allowOutsideClick: false,
      confirmButtonText: 'Aceptar'
    }).then((result)=>{
      if (result.isConfirmed) {
        window.location.reload();
      }
    });
  };
}
