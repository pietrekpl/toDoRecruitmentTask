import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Task } from '../shared/task';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

private baseUrl = 'http://localhost:8080/api/tasks'

  constructor(private http: HttpClient) { }

    searchAndSortTasks(taskName: string, sortBy: string, sortDirection: string): Observable<Task[]> {
      let params = new HttpParams();
      params = params.set('taskName', taskName);
      params = params.set('sortBy', sortBy);
      params = params.set('sortDirection', sortDirection);
      return this.http.get<Task[]>(`${this.baseUrl}`, { params });
    }

    addTask(task: Task): Observable<Task> {
    task.deadline = task.deadline.split('-').reverse().join('.');
     return this.http.post<Task>(`${this.baseUrl}`, task)
    }

    editTask(id: number, task: Task): Observable<Task> {
    task.deadline = task.deadline.split('-').reverse().join('.');
      const url = `${this.baseUrl}/${id}`;
      return this.http.put<Task>(url, task);
    }
    getTaskById(id: number): Observable<Task> {
      return this.http.get<Task>(`${this.baseUrl}/${id}`);
      }

}
