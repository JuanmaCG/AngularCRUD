import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Alumno } from '../alumno';
import { AlumnoService } from '../alumno.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-alumno-details',
  templateUrl: './alumno-details.component.html',
  styleUrls: ['./alumno-details.component.css']
})
export class AlumnoDetailsComponent implements OnInit {

  alumno : Object = new Alumno();


  constructor(private route : ActivatedRoute, private alumnoService : AlumnoService, private location : Location) {  }

  ngOnInit() {
    this.loadAlumno();
  }

  loadAlumno(){
   this.alumnoService.getAlumno(this.route.snapshot.params.dni)
    .subscribe(alumno => {
      this.alumno = alumno
    }, error => console.error(error));

  
    
  }

  goBack() {
    this.location.back();
  }


  update() {
    this.alumnoService.updateAlumno(this.route.snapshot.params.dni, this.alumno).subscribe();
  }


  onSubmit(){
    this.update();
    this.location.go("/listaAlumno");
  }
 
}
