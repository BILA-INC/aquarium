import { TimetableService } from '../timetable.service';
import { Timetable } from '../timetable';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: 'app-create-timetable',
  templateUrl: './create-timetable.component.html',
  styleUrls: ['./create-timetable.component.css']
})

export class CreateTimetableComponent implements OnInit {

  timetable: Timetable = new Timetable();

  constructor(private timetableService: TimetableService,
              private router: Router, private employeeService: EmployeeService) { }

  ngOnInit() {
  }

  save() {
    this.timetableService.createTimetable(this.timetable)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id']; const day = form.value['day'];
    const activity = form.value['activity'];
    const startingHour = form.value['startingHour']; const endingHour = form.value['endingHour'];
    this.timetable.setAttributes(id, day, activity, startingHour, endingHour);
    this.save();
  }

  gotoList() {
    //alert("Timetable successfully added!");
    alert(this.timetable.id);
    this.router.navigate(['all/timetable']);
  }

  detailsAlert() {
    alert("you've to get identified in order to view further details or delete an item!");
  }
}
