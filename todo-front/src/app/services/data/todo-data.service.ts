import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BASE_URI } from 'src/app/app.constants';

export class Todo{
  constructor(
    public id:number,
    public description:string,
    public targetDate:Date,
    public isDone:boolean
  ){}
}

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(private http:HttpClient) { }

  getTodosForUser(username:string){
    return this.http.get<Todo[]>(`${BASE_URI}/users/${username}/todos`);
  }

  deleteTodoById(username:string, id:number){
    return this.http.delete(`http://localhost:8080/users/${username}/todos/${id}`);
  }

  retrieveTodoById(username:string, id:number){
    return this.http.get<Todo>(`http://localhost:8080/users/${username}/todos/${id}`);
  }

  updateTodo(username:string, todo:Todo){
    return this.http.put<Todo>(`http://localhost:8080/users/${username}/todos/`,todo);
  }

  createTodo(username:string, todo:Todo){
    return this.http.post(`http://localhost:8080/users/${username}`,todo);
  }

  // createBasicAuthHttpHeader(){
  //   let username:string = 'user';
  //   let password:string = 'pass';
  //   let basicAuthHeader:string = 'Basic ' + window.btoa(username + ':' + password);

  //   let header = new HttpHeaders({Authorization:basicAuthHeader});
  //   return header;
  // }
}
