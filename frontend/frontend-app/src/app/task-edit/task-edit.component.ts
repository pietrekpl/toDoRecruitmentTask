import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import { TaskService } from '../shared/task.service';
import { Task } from '../shared/task';

@Component({
  selector: 'app-task-edit',
  templateUrl: './task-edit.component.html',
  styleUrls: ['./task-edit.component.css']
})
export class TaskEditComponent {

task: Task = new Task();
id!: number

constructor(private taskService: TaskService,
              private route: ActivatedRoute,
              private router: Router) {
  }

ngOnInit() {
  this.id = this.route.snapshot.params['id']
  this.taskService.getTaskById(this.id).subscribe( data => {
  this.task = data
  this.task.deadline = this.task.deadline.split(".").reverse().join("-")
  }, error => console.log(error))
}

 goToTaskList() {
     this.router.navigate(['/task-list']);
  }

  validateTaskDeadline(deadline: string): boolean {
  const selectedDate: Date = new Date(deadline)
  selectedDate.setHours(23, 59, 59, 0);
  const currentDate: Date = new Date()
  return selectedDate < currentDate
  }

onSubmit() {
this.taskService.editTask(this.id, this.task).subscribe(data =>
      this.goToTaskList()
    )
}


}
