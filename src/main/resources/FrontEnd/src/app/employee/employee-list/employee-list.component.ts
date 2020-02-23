import { Observable } from "rxjs";
import { EmployeeService } from "../employee.service";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-employee-list",
  templateUrl: "./employee-list.component.html",
  styleUrls: ["./employee-list.component.css"]
})

export class EmployeeListComponent implements OnInit {

  employees: Observable<any>;

  constructor(private employeeService: EmployeeService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  employeeDetails(id: number){
    this.router.navigate(['details/employee', id]);
  }

  detailsAlert() {
    alert("you've to get identified as 'MANAGER' (gestionnaire) in order to view further details or delete an item!");
  }
}
