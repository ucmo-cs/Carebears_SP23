import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { PetVaccinesComponent } from './components/pet-vaccines/pet-vaccines.component';

const routes: Routes = [
  { path: 'login', component: LoginPageComponent, pathMatch: 'full'},
  { path: 'home', component: HomePageComponent },
  { path: 'vaccines', component: PetVaccinesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
