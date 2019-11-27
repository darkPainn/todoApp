import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthService } from '../services/hardcoded-auth.service';
import { BasicAuthService } from '../services/basic-auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: ['']
})
export class LoginComponent implements OnInit {
  private username: string;
  private password: string;
  private errorMessage:string = 'Invalid credentials';
  private invalidLogin = false;
  private loggedIn = false;

  constructor(
    private router: Router, 
    private auth:HardcodedAuthService,
    private basicAuthService:BasicAuthService ) {
   }

  ngOnInit() {
  }

  handleLogin(){
    // this.basicAuthService.authenticate(this.username,this.password).subscribe(
    //   response=>{
    //     console.log(response)
    //   }
    // );
    //do your checks here then redirect to welcome page
    if(this.auth.authenticate(this.username, this.password)){
      this.invalidLogin = false;
      this.loggedIn = true;
      this.router.navigate(['welcome/' + this.username]);
    }else{
      this.loggedIn = false;
      this.invalidLogin = true;
    }
  }

}
