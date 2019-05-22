import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlumnoService {

  url = "/alumno"

  constructor(private http : HttpClient) { }

  getAlumnosList () : Observable<any>{
    return this.http.get(`${this.url}`);
  }

  getAlumno (idalumno : String) : Observable<Object>{
    return this.http.get(`${this.url}/${idalumno}`);
  }

  createAlumno (alumno : Object) : Observable<Object>{
    return this.http.post(`${this.url}`, alumno);
  }

  deleteAlumno(dni : String) : Observable<Object>{
    return this.http.delete(`${this.url}/${dni}`);
  }

  updateAlumno(idAlumno : String, values : any) : Observable<Object>{
    return this.http.put(`${this.url}/${idAlumno}`, values);
  }
}
