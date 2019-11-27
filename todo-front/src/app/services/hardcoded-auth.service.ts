import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthService {
  private usernames:string[] = ['sefo', 'fifo'];
  private passwords:string[] = ['123']

  constructor() { }

  authenticate(username:string, password:string):boolean{
    if( (this.usernames.indexOf(username) > -1) && (this.passwords.indexOf(password) > -1) ){
      sessionStorage.setItem('authenticatedUser', username);
      return true
    }
    return false;
  }

  isUserLoggedIn():boolean{
    let user = sessionStorage.getItem('authenticatedUser');
    return !(user === null);
  }

  logoutUser(){
    sessionStorage.clear();
  }
}
