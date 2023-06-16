import { Component, OnInit } from '@angular/core';
import { Task } from '../shared/task';
import { TaskService } from '../shared/task.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css']
})
export class TaskFormComponent implements OnInit {
  taskForm!: FormGroup;
  errorMessage!: string;

  constructor(
    private formBuilder: FormBuilder,
    private taskService: TaskService,
    private router: Router
  ) {}

  ngOnInit() {
    this.initTaskForm();
  }

  private initTaskForm() {
    this.taskForm = this.formBuilder.group({
      taskName: ['', Validators.required],
      deadline: ['', [Validators.required, this.validateDeadline]]
    });
  }

  private validateDeadline(control: AbstractControl): ValidationErrors | null {
    const selectedDate = new Date(control.value);
    const currentDate = new Date();

    if (selectedDate < currentDate) {
      return { invalidDeadline: true };
    }

    return null;
  }

  onSave() {
    if (this.taskForm.invalid) {
      this.errorMessage = 'Please fill in all required fields.';
      return;
    }

    const task: Task = this.taskForm.value;
    this.taskService.addTask(task).subscribe(
      () => {
        this.router.navigate(['/task-list']);
      },
      (error) => {
        this.errorMessage = 'An error occurred while saving the task.';
      }
    );
  }
}
