import { Component, OnInit } from '@angular/core';
import { AlumnoService } from '../alumno.service';
import { Observable } from 'rxjs';
import { Alumno } from "../alumno";

@Component({
  selector: 'app-alumno-list',
  templateUrl: './alumno-list.component.html',
  styleUrls: ['./alumno-list.component.css']
})
export class AlumnoListComponent implements OnInit {

  alumnos : Observable<Alumno[]>

  constructor(private alumnoService : AlumnoService) { }

  ngOnInit() {
    this.loadAlumno();
  }

  loadAlumno() {
   this.alumnos = this.alumnoService.getAlumnosList();
  }

  deleteAlumno(dni : String) {
    this.alumnoService.deleteAlumno(dni)
      .subscribe(data =>{
        console.log(data);
        this.loadAlumno();
      }, error => console.error())
  }

}
