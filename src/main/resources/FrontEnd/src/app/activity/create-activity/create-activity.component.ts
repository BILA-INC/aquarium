import { ActivityService } from '../activity.service';
import { Activity } from '../activity';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: 'app-create-activity',
  templateUrl: './create-activity.component.html',
  styleUrls: ['./create-activity.component.css']
})

export class CreateActivityComponent implements OnInit {

  activity: Activity = new Activity();

  constructor(private activityService: ActivityService,
              private router: Router, private employeeService: EmployeeService) {}

  ngOnInit() {}

  save() {
    this.activityService.createActivity(this.activity)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id'];
    const day = form.value['day']; const sh = form.value['sh'];
    const eh = form.value['eh']; const pp = form.value['pp']; const name = form.value['name'];
    this.activity.setAttributes(id, day, sh, eh, pp, name);
    this.save();
  }

  gotoList() {
    alert("New host successfully added!")
    this.router.navigate(['all/activity']);
  }

  detailsAlert() {
    alert("you've to get identified in order to view further details or delete an item!");
  }
}
