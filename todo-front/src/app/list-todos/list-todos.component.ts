import { Component, OnInit } from '@angular/core';
import { TodoDataService, Todo } from '../services/data/todo-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styles: ['']
})
export class ListTodosComponent implements OnInit {
  public todos:Todo[];
  private username:string;
  private message:string;

  constructor(
    private dataService:TodoDataService,
    private router:Router) { }

  ngOnInit() {
    this.username = sessionStorage.getItem('authenticatedUser');
    this.refreshTodos();
  }

  deleteTodo(id:number){
    this.dataService.deleteTodoById(this.username, id).subscribe(
      response => {
        console.log(response);
        this.message = "Deleted successfully!";
        this.refreshTodos();
      }
    );
  }

  updateTodo(id:number){
    this.router.navigate([`/todos/${id}`]);
  }

  refreshTodos(){
    this.dataService.getTodosForUser(this.username).subscribe(
      response => {
        this.todos = response;
      }
    );
  }

  createTodo(){
    this.router.navigate([`/todos/${-1}`]);
  }

}
