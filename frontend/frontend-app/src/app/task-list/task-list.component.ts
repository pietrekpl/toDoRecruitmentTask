import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { Observable } from "rxjs";
import { Injectable } from '@angular/core';
import { Task } from '../shared/task';
import { Router } from '@angular/router';
import { TaskService } from '../shared/task.service';
import { MatDialog, MatDialogRef, MatDialogConfig  } from '@angular/material/dialog';
import { faSpinner, faExclamationCircle, faCheckCircle, faQuestionCircle } from '@fortawesome/free-solid-svg-icons';
import { IconProp } from '@fortawesome/fontawesome-svg-core';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {

@ViewChild('myCityDialog') cityDialog!: TemplateRef<any>;
  dialogRef: MatDialogRef<any> | undefined;
  tasks: Task[] = [];
  taskName = '';
  sortBy = '';
  sortDirection = '';
  taskById? =  new Task()

  faSpinner = faSpinner;
  faExclamationCircle = faExclamationCircle;
  faCheckCircle = faCheckCircle;
  faQuestionCircle = faQuestionCircle;

  constructor(private taskService: TaskService,
   private router: Router,
   private dialog: MatDialog) {
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

   editTask(id: number) {
     this.router.navigate(['/edit-task', id])
   }

   deleteTask(id: number) {
    this.taskService.deleteTask(id).subscribe(data =>
    this.tasks = this.tasks.filter(task => task.id !== id))
   }

   openCityDialog(index: number) {
     const task = this.tasks.find(t => t.id === index);
      this.taskById = task;

      const dialogRef = this.dialog.open(this.cityDialog, {
        width: '350px',
        height: '400px',
        panelClass: 'custom-dialog'
      });

      dialogRef.afterClosed().subscribe(() => {
      });
    }

    getIcon(status: string) {
      switch (status) {
        case 'not_started':
          return this.faSpinner;
        case 'pending':
          return this.faExclamationCircle;
        case 'completed':
          return this.faCheckCircle;
        default:
          return this.faQuestionCircle;
      }
    }
}

