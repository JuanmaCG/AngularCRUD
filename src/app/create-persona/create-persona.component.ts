import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../persona.service';
import { Persona } from '../persona';

@Component({
  selector: 'app-create-persona',
  templateUrl: './create-persona.component.html',
  styleUrls: ['./create-persona.component.css']
})
export class CreatePersonaComponent implements OnInit {

  persona : Persona = new Persona();
  creado : boolean = false;
  
  constructor(private personaService : PersonaService) { }

  ngOnInit() {
  }

  newPersona() : void{
    this.persona = new Persona();
  }

  save() {
    this.personaService.createPersona(this.persona)
      .subscribe(data => console.log(data), error => console.log(error));
      this.persona = new Persona;
  }

  onSubmit() {
    this.creado = true;
    this.save();
  }
}
