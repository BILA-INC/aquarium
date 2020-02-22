import { Observable } from "rxjs";
import { AnimalService } from "../animal.service";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: "app-animal-list",
  templateUrl: "./animal-list.component.html",
  styleUrls: ["./animal-list.component.css"]
})

export class AnimalListComponent implements OnInit {

  animals: Observable<any>;
  employeeService: any;

  constructor(private animalService: AnimalService,
              private router: Router, employeeService: EmployeeService) { this.employeeService=employeeService;}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.animals = this.animalService.getAnimalsList();
  }

  deleteAnimal(id: number) {
    this.animalService.deleteAnimal(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  animalDetails(id: number){
    this.router.navigate(['details/animal', id]);
  }

  detailsAlert() {
      alert("you've to get identified in order to view further details or delete an item!");
  }
}

