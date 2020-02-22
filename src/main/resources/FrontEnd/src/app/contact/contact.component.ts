import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  clickAlert() {
    alert("Your message has been successfully sent. We'll be back to you ASAP");
    this.router.navigate(['']);
  }
}
