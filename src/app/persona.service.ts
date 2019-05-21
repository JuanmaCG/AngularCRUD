import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  url = '/persona';

  constructor(private http : HttpClient) { }

  getPersona(dni : String) : Observable<Object> {
    return this.http.get(`${this.url}/${dni}`);
  }

  createPersona(persona : Object) : Observable<Object> {
    return this.http.post(`${this.url}`, persona);
  }

  updatePersona(dni : String, value : any) : Observable<Object> {
    return this.http.put(`${this.url}/${dni}`, value);
  }

  deletePersona(dni : String) : Observable<Object>{
    return this.http.delete(`${this.url}/${dni}`, {responseType : 'text'});
  }

  getPersonaList() : Observable<any> {
    return this.http.get(`${this.url}`);
  }

}
