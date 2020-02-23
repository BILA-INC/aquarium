import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class ActivityService {

  private baseUrl = 'http://localhost:9090';
  //public isConnected : boolean;
  //public userName : String;

  constructor(private http: HttpClient) {}

  getActivityById(id: number): Observable<any> {return this.http.get(`${this.baseUrl}/all/activity/${id}`);}

  createActivity(activity: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/activity`, activity);}

  deleteActivity(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/activity/${id}`, { responseType: 'text' });}

  getActivitiesList(): Observable<any> {return this.http.get(`${this.baseUrl}/all/activity`);}

}
