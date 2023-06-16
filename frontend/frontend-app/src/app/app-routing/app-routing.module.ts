import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { TaskListComponent } from '../task-list/task-list.component';
import { TaskFormComponent } from '../task-form/task-form.component';
import { PageNotFoundComponent } from '../page-not-found/page-not-found.component';
import { TaskEditComponent } from '../task-edit/task-edit.component';


const routes: Routes = [
  { path: '', component: TaskListComponent },
  { path: 'task-list', component: TaskListComponent },
  { path: 'edit-task/:id', component: TaskEditComponent },
  { path: 'new-task', component: TaskFormComponent },
   {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
