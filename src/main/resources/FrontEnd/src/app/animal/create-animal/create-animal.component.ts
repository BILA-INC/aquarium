import { AnimalService } from '../animal.service';
import { Animal } from '../animal';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-create-animal',
  templateUrl: './create-animal.component.html',
  styleUrls: ['./create-animal.component.css']
})

export class CreateAnimalComponent implements OnInit {

  animal: Animal = new Animal();

  constructor(private animalService: AnimalService,
              private router: Router) {}

  ngOnInit() {}

  save() {
    this.animalService.createAnimal(this.animal)
      .subscribe(data => console.log(data), error => console.log(error));
    this.gotoList();
  }

  onSubmit(form: NgForm) {
    const id = form.value['id']; const name = form.value['name'];
    const specy = form.value['specy']; const sex = form.value['sex'];
    const sign = form.value['sign']; const arrivalDate = form.value['arrivalDate'];
    const departureDate = form.value['departureDate'];
    this.animal.setAttributes(id, name, specy, sex, sign, arrivalDate, departureDate);
    this.save();
  }

  gotoList() {
    alert("New host successfully added!")
    this.router.navigate(['all/animal']);
  }
}
