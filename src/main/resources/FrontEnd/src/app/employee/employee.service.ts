import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Employee} from "./employee";
import {any} from "codelyzer/util/function";

@Injectable({providedIn: 'root'})
export class EmployeeService {

  private baseUrl = 'http://localhost:9090';

  constructor(private http: HttpClient) { }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/all/employee/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/add/employee`, employee);
  }

  updateEmployee(value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/update/employee`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/employee/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all/employee`);
  }

  //addEmployee(id: number, name: string, address: string, numSS: number) {

   //let employee = new Employee(); employee.setAttributes(id, name, address, numSS); return employee;
  /*  this.http
      .post('http://localhost:9090/Employees', employee)
      .subscribe(
        () => {
          console.log('Successfully saved !');
        },
        (error) => {
          console.log('Error ! : ' + error);
        }
      );
  }*/

}
