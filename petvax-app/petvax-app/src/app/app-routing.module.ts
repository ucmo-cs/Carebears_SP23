import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import {MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";

const routes: Routes = [
  { path: 'login', component: LoginPageComponent, pathMatch: 'full'},
  { path: 'home', component: HomePageComponent },
];

@NgModule({
  imports: [MatTableModule, MatFormFieldModule, MatInputModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
