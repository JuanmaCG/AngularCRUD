import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonaListComponent } from './Persona/persona-list/persona-list.component';
import { CreatePersonaComponent } from './Persona/create-persona/create-persona.component';
import { AlumnoListComponent } from './Alumno/alumno-list/alumno-list.component';
import { CreateAlumnoComponent } from './Alumno/create-alumno/create-alumno.component';
import { ReadPersonaComponent } from './Persona/read-persona/read-persona.component';
import { AlumnoDetailsComponent } from './Alumno/alumno-details/alumno-details.component';



const routes: Routes = [
  { path: '', redirectTo: 'listaPersona', pathMatch: 'full' },
  { path: 'listaPersona', component: PersonaListComponent },
  { path: 'crear', component: CreatePersonaComponent },
  { path: 'listaAlumno', component: AlumnoListComponent },
  { path: 'crearAlumno', component: CreateAlumnoComponent },
  { path: 'personaBuscada/:dni', component: ReadPersonaComponent},
  { path: 'alumnoBuscado/:dni', component: AlumnoDetailsComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }