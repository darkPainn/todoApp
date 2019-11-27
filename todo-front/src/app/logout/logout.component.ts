import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthService } from '../services/hardcoded-auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styles: ['']
})
export class LogoutComponent implements OnInit {

  constructor(private router:Router, private auth: HardcodedAuthService) { }

  ngOnInit() {
    this.auth.logoutUser();
    this.router.navigate(['/login']);
  }

}
