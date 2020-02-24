import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Timetable} from "./timetable";

@Injectable({providedIn: 'root'})
export class TimetableService {

  private baseUrl = 'http://localhost:9090';
  public isConnected : boolean;
  public userName : String;

  constructor(private http: HttpClient) {}

  getTimetableById(id: number): Observable<any> {return this.http.get(`${this.baseUrl}/all/timetable/${id}`);}

  createTimetable(timetable: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/timetable`, timetable);}

  updateTimetable(value: any): Observable<Object> {return this.http.put(`${this.baseUrl}/update/timetable`, value);}

  deleteTimetable(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/timetable/${id}`, { responseType: 'text' });}

  getTimetablesList(): Observable<any> {return this.http.get(`${this.baseUrl}/all/timetable`);}

}
