import { PoolService } from '../pool.service';
import { Pool } from '../pool';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-create-pool',
  templateUrl: './create-pool.component.html',
  styleUrls: ['./create-pool.component.css']
})

export class CreatePoolComponent implements OnInit {

  pool: Pool = new Pool();

  constructor(private poolService: PoolService,
              private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.poolService.createPool(this.pool)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id']; const maxPopulation = form.value['maxPopulation'];
    const maxVolume = form.value['maxVolume']; const isClean = form.value['isClean'];
    const zoneName = form.value['zoneName']; const zoneLocalisation = form.value['zoneLocalisation'];
    this.pool.setAttributes(id, maxPopulation, maxVolume, isClean, zoneName, zoneLocalisation);
    this.save();
  }

  gotoList() {
    //alert("Pool successfully added!");
    alert(this.pool.id);
    this.router.navigate(['all/pool']);
  }
}
