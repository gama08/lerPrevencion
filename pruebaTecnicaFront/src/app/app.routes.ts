import { Routes } from '@angular/router';
import { ListaComponent } from './modelos/persona/componentes/lista/lista.component';
import { CrearActualizarComponent } from './modelos/persona/componentes/crear-actualizar/crear-actualizar.component';

export const routes: Routes = [
  { path: 'listaPersonas', component: ListaComponent },
  { path: 'listaPersonas/crear-modificar', component: CrearActualizarComponent },
  { path: 'listaPersonas/crear-modificar/:numeroCedula', component: CrearActualizarComponent },
  { path: '**', pathMatch: 'full', redirectTo: '#' }
];
