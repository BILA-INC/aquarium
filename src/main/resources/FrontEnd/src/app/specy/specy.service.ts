import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Specy} from "./specy";

@Injectable({providedIn: 'root'})
export class SpecyService {

  private baseUrl = 'http://localhost:9090';
  public isConnected : boolean;
  public userName : String;

  constructor(private http: HttpClient) {}

  getSpecyById(id: number): Observable<any> {return this.http.get(`${this.baseUrl}/all/specy/${id}`);}

  createSpecy(specy: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/specy`, specy);}

  updateSpecy(value: any): Observable<Object> {return this.http.put(`${this.baseUrl}/update/specy`, value);}

  deleteSpecy(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/specy/${id}`, { responseType: 'text' });}

  getSpecysList(): Observable<any> {return this.http.get(`${this.baseUrl}/all/specy`);}

}
