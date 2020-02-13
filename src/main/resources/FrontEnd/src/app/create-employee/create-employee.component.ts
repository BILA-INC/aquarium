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
  submitted = false;

  constructor(private employeeService: EmployeeService,
              private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
   // this.employee = new Employee();
  }

  save() {
    this.employeeService.createEmployee(this.employee)
      .subscribe(data => console.log(data), error => console.log(error));
    //this.employee = new Employee();
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id'];
    const firstName = form.value['firstName'];
    const lastName = form.value['lastName'];
    const address = form.value['address'];
    this.employee.setAttributes(id, firstName, lastName, address);
   // this.employee = EmployeeService.addEmployee(id, name, address, numSS);
    this.save();
    //this.submitted = true;
   // this.save();
  }

  gotoList() {
    this.router.navigate(['all/employee']);
  }


}
