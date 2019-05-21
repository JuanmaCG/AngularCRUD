import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonaListComponent } from './persona-list/persona-list.component';
import { CreatePersonaComponent } from './create-persona/create-persona.component';


const routes: Routes = [
  { path: '', redirectTo: 'persona', pathMatch: 'full' },
  { path: 'listaPersona', component: PersonaListComponent },
  { path: 'crear', component: CreatePersonaComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }