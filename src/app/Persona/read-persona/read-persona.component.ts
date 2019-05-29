import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Persona } from '../persona';
import { PersonaService } from '../persona.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-read-persona',
  templateUrl: './read-persona.component.html',
  styleUrls: ['./read-persona.component.css']
})
export class ReadPersonaComponent implements OnInit {

  persona : Object = new Persona;


  constructor(private route : ActivatedRoute, private personaService : PersonaService, private location : Location) {  }

  ngOnInit() {
    this.loadPersona();
  }

  loadPersona(){
    this.persona = this.personaService.getPersona(this.route.snapshot.params.dni)
    .subscribe(persona => this.persona = persona, error => console.error(error));
  }

  goBack() {
    this.location.back();
  }


  update() {
    this.personaService.updatePersona(this.route.snapshot.params.dni, this.persona).subscribe();
  }


  onSubmit(){
    this.update();
    this.location.go("/listaPersona");
  }
 
}
