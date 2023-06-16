import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import { Injectable } from '@angular/core';
import { Task } from '../shared/task';
import { TaskService } from '../shared/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

 tasks: Task[] = [];
  taskName = '';
  sortBy = '';
  sortDirection = '';

  constructor(private taskService: TaskService) {
  }

  ngOnInit() {
    this.loadTasks();
  }

  searchAndSort() {
    this.loadTasks();
  }

 private loadTasks() {
    this.taskService.searchAndSortTasks(this.taskName, this.sortBy, this.sortDirection)
      .subscribe(tasks => {
        this.tasks = tasks;
      });
  }

}

