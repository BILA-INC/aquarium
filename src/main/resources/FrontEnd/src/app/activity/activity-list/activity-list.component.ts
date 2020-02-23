import { Observable } from "rxjs";
import { ActivityService } from "../activity.service";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: "app-activity-list",
  templateUrl: "./activity-list.component.html",
  styleUrls: ["./activity-list.component.css"]
})

export class ActivityListComponent implements OnInit {

  activities: Observable<any>;
  employeeService: any;

  constructor(private activityService: ActivityService,
              private router: Router, employeeService: EmployeeService) { this.employeeService=employeeService;}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.activities = this.activityService.getActivitiesList();
  }

  deleteActivity(id: number) {
    this.activityService.deleteActivity(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  activityDetails(id: number){
    this.router.navigate(['details/activity', id]);
  }

  detailsAlert() {
    alert("you've to get identified as 'Manager' (gestionnaire) in order to view further details or delete an item!");
  }
}
