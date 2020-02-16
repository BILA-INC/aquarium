import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

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
    this.employeeService.updateEmployee(this.employee)
      .subscribe(data => console.log(data), error => console.log(error));
    //this.employee = new Employee();
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id'];
    const firstName = form.value['firstName'];
    const lastName = form.value['lastName'];
    const birthdate = form.value['birthdate'];
    const address = form.value['address'];
    const secuNum = form.value['secuNum'];
    this.employee.setAttributes(id, firstName, lastName, birthdate, address, secuNum);
    // this.employee = EmployeeService.addEmployee(id, name, address, numSS);
    this.save();
    //this.submitted = true;
    // this.save();
  }

  gotoList() {
    this.router.navigate(['all/employee']);
  }
}
