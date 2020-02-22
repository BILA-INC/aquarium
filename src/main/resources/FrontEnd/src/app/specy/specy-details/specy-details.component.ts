import { Specy } from '../specy';
import { Component, OnInit, Input } from '@angular/core';
import { SpecyService } from '../specy.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-specy-details',
  templateUrl: './specy-details.component.html',
  styleUrls: ['./specy-details.component.css']
})

export class SpecyDetailsComponent implements OnInit {

  id: number;
  specy: Specy;

  constructor(private route: ActivatedRoute,private router: Router,
              private specyService: SpecyService) {}

  ngOnInit() {
    this.specy = new Specy();

    this.id = this.route.snapshot.params['id'];

    this.specyService.getSpecyById(this.id)
      .subscribe(data => {
        console.log(data)
        this.specy = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['all/specy']);
  }
}
