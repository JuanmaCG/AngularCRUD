import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatePersonaComponent } from './Persona/create-persona/create-persona.component';
import { PersonaListComponent } from './Persona/persona-list/persona-list.component';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { CreateAlumnoComponent } from './Alumno/create-alumno/create-alumno.component';
import { AlumnoListComponent } from './Alumno/alumno-list/alumno-list.component';
import { ReadPersonaComponent } from './Persona/read-persona/read-persona.component';
import { AlumnoDetailsComponent } from './Alumno/alumno-details/alumno-details.component';


@NgModule({
  declarations: [
    AppComponent,
    CreatePersonaComponent,
    PersonaListComponent,
    CreateAlumnoComponent,
    AlumnoListComponent,
    ReadPersonaComponent,
    AlumnoDetailsComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
