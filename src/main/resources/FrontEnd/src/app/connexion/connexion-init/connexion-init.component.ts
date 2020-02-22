import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/employee.service";
import {Router} from "@angular/router";
import {Employee} from "../../employee/employee";

@Component({
  selector: 'app-connexion-init',
  templateUrl: './connexion-init.component.html',
  styleUrls: ['./connexion-init.component.css']
})

export class ConnexionInitComponent implements OnInit {

  employee: Employee;

  constructor(private employeeService: EmployeeService, private router: Router) { this.employeeService.isConnected=0; }


  ngOnInit(): void {}

  onSubmit(form: NgForm) {

    this.employeeService.getEmployeeById(form.value['id'])
      .subscribe(data => {
        console.log(data);
        this.employee = data;
      }, error => console.log(error));
    if(this.employee.password==form.value['password']) this.redirectRight();
    else this.redirectWrong();
}

  private redirectRight() {
    this.employeeService.isConnected=1;
    this.employeeService.userName=this.employee.firstName;
    alert("Welcome    "+this.employee.firstName);}

  private redirectWrong() { alert("Wrong credential(s)");}



}
