import { Component, OnInit } from '@angular/core';
import { User } from '../../user';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  user: User = new User();
  constructor() { }

  ngOnInit() {
  }

}
