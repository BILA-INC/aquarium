import { Observable } from "rxjs";
import { TimetableService } from "../timetable.service";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: "app-timetable-list",
  templateUrl: "./timetable-list.component.html",
  styleUrls: ["./timetable-list.component.css"]
})

export class TimetableListComponent implements OnInit {

  timetables: Observable<any>;

  constructor(private timetableService: TimetableService,
              private router: Router, private employeeService: EmployeeService) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.timetables = this.timetableService.getTimetablesList();
  }

  deleteTimetable(id: number) {
    this.timetableService.deleteTimetable(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  timetableDetails(id: number){
    this.router.navigate(['details/timetable', id]);
  }

  detailsAlert() {
    alert("you've to get identified as 'Manager' (gestionnaire) in order to view further details or delete an item!");
  }
}


