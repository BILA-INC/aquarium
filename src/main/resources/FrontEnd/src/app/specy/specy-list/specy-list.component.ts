import { Observable } from "rxjs";
import { SpecyService } from "../specy.service";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-specy-list",
  templateUrl: "./specy-list.component.html",
  styleUrls: ["./specy-list.component.css"]
})

export class SpecyListComponent implements OnInit {

  specys: Observable<any>;

  constructor(private specyService: SpecyService,
              private router: Router) {}

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
}

