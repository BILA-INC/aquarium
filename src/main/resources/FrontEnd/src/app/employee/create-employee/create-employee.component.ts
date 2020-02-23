import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})

export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.employeeService.createEmployee(this.employee)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id']; const firstName = form.value['firstName'];
    const lastName = form.value['lastName']; const birthdate = form.value['birthdate'];
    const address = form.value['address']; const secuNum = form.value['secuNum'];
    const password = form.value['password'];
    const position = form.value['position']; const pool = form.value['pool'];
    const zone = form.value['zone']; const activity = form.value['activity'];
    this.employee.setAttributes(id, firstName, lastName, birthdate, address, secuNum, password,
      position, pool, zone, activity);
    this.save();
  }

  gotoList() {
    alert("Employee successfully added!")
    this.router.navigate(['all/employee']);
  }
}
