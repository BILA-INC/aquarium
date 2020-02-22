import { Animal } from '../animal';
import { Component, OnInit, Input } from '@angular/core';
import { AnimalService } from '../animal.service';
import { Router, ActivatedRoute } from '@angular/router';
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: 'app-animal-details',
  templateUrl: './animal-details.component.html',
  styleUrls: ['./animal-details.component.css']
})

export class AnimalDetailsComponent implements OnInit {

  id: number;
  animal: Animal;

  constructor(private route: ActivatedRoute,private router: Router,
              private animalService: AnimalService, private employeeService: EmployeeService) {}

  ngOnInit() {
    this.animal = new Animal();

    this.id = this.route.snapshot.params['id'];

    this.animalService.getAnimalById(this.id)
      .subscribe(data => {
        console.log(data)
        this.animal = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['all/animal']);
  }
}
