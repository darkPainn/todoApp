import { Component, OnInit, ViewChild } from '@angular/core';
import { Todo, TodoDataService } from '../services/data/todo-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  @ViewChild('updateTodoForm', {static:false}) updateTodoForm:NgForm;

  username:string;
  todo:Todo;
  todoId:number;

  constructor(
    private todoService:TodoDataService,
    private route:ActivatedRoute,
    private router:Router
  ) { }

  ngOnInit() {
    this.username = sessionStorage.getItem('authenticatedUser');
    this.todoId = this.route.snapshot.params['id'];
    this.todo = new Todo(this.todoId,'', new Date(), false);
    if(this.todoId != -1){
      this.todoService.retrieveTodoById(this.username, this.todoId).subscribe(
        response => {
          this.todo = response;
        }
      );
    }
  }

  saveTodo(){
    this.todoId = this.route.snapshot.params['id'];
    if(this.todoId === -1){
      //this.todoService.createTodo(this.username, this.todo);
    }else{
      this.todoService.updateTodo(this.username, this.todo).subscribe(
        response => {
          this.todo = response;
          this.router.navigate(['/todos']);
        }
      );
    }
  }

}
