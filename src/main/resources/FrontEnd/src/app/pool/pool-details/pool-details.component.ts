import { Pool } from '../pool';
import { Component, OnInit, Input } from '@angular/core';
import { PoolService } from '../pool.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pool-details',
  templateUrl: './pool-details.component.html',
  styleUrls: ['./pool-details.component.css']
})

export class PoolDetailsComponent implements OnInit {

  id: number;
  pool: Pool;

  constructor(private route: ActivatedRoute,private router: Router,
              private poolService: PoolService) {}

  ngOnInit() {
    this.pool = new Pool();

    this.id = this.route.snapshot.params['id'];

    this.poolService.getPoolById(this.id)
      .subscribe(data => {
        console.log(data)
        this.pool = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['all/pool']);
  }
}

