import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Pool} from "./pool";

@Injectable({providedIn: 'root'})
export class PoolService {

  private baseUrl = 'http://localhost:9090';
  public isConnected : boolean;
  public userName : String;

  constructor(private http: HttpClient) {}

  getPoolById(id: number): Observable<any> {return this.http.get(`${this.baseUrl}/all/pool/${id}`);}

  createPool(pool: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/pool`, pool);}

  updatePool(value: any): Observable<Object> {return this.http.put(`${this.baseUrl}/update/pool`, value);}

  deletePool(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/pool/${id}`, { responseType: 'text' });}

  getPoolsList(): Observable<any> {return this.http.get(`${this.baseUrl}/all/pool`);}

}
