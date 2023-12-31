import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import {RouterLink, RouterOutlet} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import { TaskListComponent } from './task-list/task-list.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { TaskFormComponent } from './task-form/task-form.component'
import { ReactiveFormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { TaskEditComponent } from './task-edit/task-edit.component';
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FontAwesomeModule, FaIconLibrary } from '@fortawesome/angular-fontawesome';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    TaskListComponent,
    TaskFormComponent,
    PageNotFoundComponent,
    TaskEditComponent,
  ],
  imports: [
    BrowserModule,
    RouterLink,
    RouterOutlet,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MatButtonModule,
    MatDialogModule,
    BrowserAnimationsModule,
    FontAwesomeModule
  ],
  providers: [FaIconLibrary],
  bootstrap: [AppComponent]
})
export class AppModule { }
