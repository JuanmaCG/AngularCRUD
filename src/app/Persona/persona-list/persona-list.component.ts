import { Component, OnInit } from '@angular/core';
import { PersonaService } from "../persona.service";
import { Observable } from 'rxjs';
import { Persona } from "../persona";
import { Router } from '@angular/router';

@Component({
  selector: 'app-persona-list',
  templateUrl: './persona-list.component.html',
  styleUrls: ['./persona-list.component.css']
})
export class PersonaListComponent implements OnInit {

  personas : Observable<Persona[]>


  constructor(private personaService : PersonaService, private router : Router) { }

  ngOnInit() {
    this.loadPersonas();
  }

  loadPersonas() {
    this.personas = this.personaService.getPersonaList();
  }

  deletePersona(dni: String) {
    this.personaService.deletePersona(dni)
      .subscribe(
        data => {
          console.log(data);
          this.loadPersonas();
        },
        error => console.log(error));
  }

  

}
