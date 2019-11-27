import { Component, OnInit } from '@angular/core';
import { HardcodedAuthService } from '../services/hardcoded-auth.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styles: ['']
})
export class MenuComponent implements OnInit {

  constructor(private auth:HardcodedAuthService) { }

  ngOnInit() {
  }

}
