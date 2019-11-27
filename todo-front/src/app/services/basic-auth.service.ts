import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class BasicAuthService {

  constructor(private http:HttpClient) { }

  authenticate(username:string, password:string){
    let header:string = 'Basic ' + window.btoa(username + ':' + password);
    return this.http.get('http://localhost:8080/basicauth', {headers:new HttpHeaders({Authorization:header})})
    //this pipe method allows us to do something together with the http request
    .pipe(map(
      data => {
        console.log(data)
        sessionStorage.setItem('authenticatedUser',username);
        return data;
      }
    ));
  }

}
