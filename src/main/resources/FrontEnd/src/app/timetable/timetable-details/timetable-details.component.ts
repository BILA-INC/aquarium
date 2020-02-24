import { Timetable } from '../timetable';
import { Component, OnInit, Input } from '@angular/core';
import { TimetableService } from '../timetable.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-timetable-details',
  templateUrl: './timetable-details.component.html',
  styleUrls: ['./timetable-details.component.css']
})

export class TimetableDetailsComponent implements OnInit {

  id: number;
  timetable: Timetable;

  constructor(private route: ActivatedRoute,private router: Router,
              private timetableService: TimetableService) {}

  ngOnInit() {
    this.timetable = new Timetable();

    this.id = this.route.snapshot.params['id'];

    this.timetableService.getTimetableById(this.id)
      .subscribe(data => {
        console.log(data)
        this.timetable = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['all/timetable']);
  }
}


