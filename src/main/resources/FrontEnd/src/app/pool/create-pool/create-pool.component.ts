import { PoolService } from '../pool.service';
import { Pool } from '../pool';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: 'app-create-pool',
  templateUrl: './create-pool.component.html',
  styleUrls: ['./create-pool.component.css']
})

export class CreatePoolComponent implements OnInit {

  pool: Pool = new Pool();

  constructor(private poolService: PoolService,
              private router: Router, private employeeService: EmployeeService) { }

  ngOnInit() {
  }

  save() {
    this.poolService.createPool(this.pool)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id']; const name = form.value['name'];
    const maxPopulation = form.value['maxPopulation'];
    const maxVolume = form.value['maxVolume']; const isClean = form.value['isClean'];
    const zoneName = form.value['zoneName']; const zoneLocalisation = form.value['zoneLocalisation'];
    const activity = form.value['activity'];
    this.pool.setAttributes(id, name, maxPopulation, maxVolume, isClean, zoneName, zoneLocalisation, activity);
    this.save();
  }

  gotoList() {
    //alert("Pool successfully added!");
    alert(this.pool.id);
    this.router.navigate(['all/pool']);
  }

  detailsAlert() {
    alert("you've to get identified in order to view further details or delete an item!");
  }
}
