import { Observable } from "rxjs";
import { SpecyService } from "../specy.service";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import {EmployeeService} from "../../employee/employee.service";

@Component({
  selector: "app-specy-list",
  templateUrl: "./specy-list.component.html",
  styleUrls: ["./specy-list.component.css"]
})

export class SpecyListComponent implements OnInit {

  specys: Observable<any>;

  constructor(private specyService: SpecyService,
              private router: Router, private employeeService: EmployeeService) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.specys = this.specyService.getSpecysList();
  }

  deleteSpecy(id: number) {
    this.specyService.deleteSpecy(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  specyDetails(id: number){
    this.router.navigate(['details/specy', id]);
  }

  detailsAlert() {
    alert("you've to get identified as 'Manager' (gestionnaire) in order to view further details or delete an item!");
  }
}

