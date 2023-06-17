import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TaskService } from '../shared/task.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
 requestCount!: number;

 constructor(private taskService: TaskService) {}

 ngOnInit() {
    this.getRequestCount();
  }

 getRequestCount() {
     this.taskService.getRequestCount().subscribe(
       (count: number) => {
         this.requestCount = count;
       },
       (error: any) => {
         console.log('Error retrieving request count:', error);
       }
     );
   }

}
