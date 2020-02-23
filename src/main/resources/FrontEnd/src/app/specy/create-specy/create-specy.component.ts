import { SpecyService } from '../specy.service';
import { Specy } from '../specy';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: 'app-create-specy',
  templateUrl: './create-specy.component.html',
  styleUrls: ['./create-specy.component.css']
})

export class CreateSpecyComponent implements OnInit {

  specy: Specy = new Specy();

  constructor(private specyService: SpecyService,
              private router: Router, private employeeService: EmployeeService) { }

  ngOnInit() {
  }

  save() {
    this.specyService.createSpecy(this.specy)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id']; const name = form.value['name'];
    const diet = form.value['diet']; const lifeExpectancy = form.value['lifeExpectancy'];
    const isEndangered = form.value['isEndangered']; const dangerLevel = form.value['dangerLevel'];
    this.specy.setAttributes(id, name, diet, lifeExpectancy, isEndangered, dangerLevel);
    this.save();
  }

  gotoList() {
    alert("Specy successfully added!")
    this.router.navigate(['all/specy']);
  }

  detailsAlert() {
    alert("you've to get identified in order to view further details or delete an item!");
  }
}
