import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class AnimalService {

  private baseUrl = 'http://localhost:9090';
  //public isConnected : boolean;
  //public userName : String;

  constructor(private http: HttpClient) {}

  getAnimalById(id: number): Observable<any> {return this.http.get(`${this.baseUrl}/all/animal/${id}`);}

  createAnimal(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/animal`, employee);}

  deleteAnimal(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/animal/${id}`, { responseType: 'text' });}

  getAnimalsList(): Observable<any> {return this.http.get(`${this.baseUrl}/all/animal`);}

}
