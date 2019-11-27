import { Component, OnInit } from '@angular/core';
import { HardcodedAuthService } from './services/hardcoded-auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'todo';

  constructor(private auth:HardcodedAuthService){}
  
  ngOnInit(): void {
    this.auth.logoutUser();
  }
}
