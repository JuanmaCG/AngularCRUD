import { Component, OnInit } from '@angular/core';
import { AlumnoService } from '../alumno.service';
import { Alumno } from '../alumno';

@Component({
  selector: 'app-create-alumno',
  templateUrl: './create-alumno.component.html',
  styleUrls: ['./create-alumno.component.css']
})
export class CreateAlumnoComponent implements OnInit {

  alumno : Alumno = new Alumno();
  creado : boolean = false;

  constructor(private alumnoService : AlumnoService) { }

  ngOnInit() {
  }



  save() {
    this.alumnoService.createAlumno(this.alumno)
      .subscribe(data => console.log(data), error => console.log(error));
    this.alumno = new Alumno();
  }

  onSubmit() {
    this.save();
    this.creado = true;
  }
}
