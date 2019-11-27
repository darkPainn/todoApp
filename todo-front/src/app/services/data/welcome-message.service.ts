import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WelcomeMessageService {

  constructor(
    private http:HttpClient
  ) { }

  getCustomMessage(name:string){
    return this.http.get<UserBean>(`http://localhost:8080/hello-world/${name}`);
  }
}

export class UserBean{
  constructor(public message:string){}

}
