import { Component } from '@angular/core';
import {EmployeeService} from "./employee/employee.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Welcome to Aquarium';
  customizedMsg: boolean;
  userName: String;

  constructor(private employeeService: EmployeeService) {
    this.customizedMsg =this.employeeService.isConnected;
    this.userName=this.employeeService.userName;
  }
  ngOnInit(): void {
    this.customizedMsg =this.employeeService.isConnected;
    this.userName=this.employeeService.userName;
  }
}
