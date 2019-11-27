import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { WelcomeMessageService, UserBean } from '../services/data/welcome-message.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styles: ['']
})
export class WelcomeComponent implements OnInit {

  private message:string;
  private userbean:UserBean;
  private messageReturned:string;
  private errorMessage:string;

  constructor(
    private route:ActivatedRoute,
    private welcomeservice:WelcomeMessageService) { }

  ngOnInit() {
    this.message = this.route.snapshot.params['name'];
  }

  getCustomMessage(){
    this.welcomeservice.getCustomMessage(this.message).subscribe(
      response => {
        this.userbean = response;
        this.messageReturned = this.userbean.message;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

}
