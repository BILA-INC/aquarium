import { Activity } from '../activity';
import { Component, OnInit, Input } from '@angular/core';
import { ActivityService } from '../activity.service';
import { Router, ActivatedRoute } from '@angular/router';
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: 'app-activity-details',
  templateUrl: './activity-details.component.html',
  styleUrls: ['./activity-details.component.css']
})

export class ActivityDetailsComponent implements OnInit {

  id: number;
  activity: Activity;

  constructor(private route: ActivatedRoute,private router: Router,
              private activityService: ActivityService, private employeeService: EmployeeService) {}

  ngOnInit() {
    this.activity = new Activity();

    this.id = this.route.snapshot.params['id'];

    this.activityService.getActivityById(this.id)
      .subscribe(data => {
        console.log(data)
        this.activity = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['all/activity']);
  }
}
