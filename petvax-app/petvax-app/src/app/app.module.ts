import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { HeaderComponent } from './components/header/header.component';
import { PetComponent } from './components/pet/pet.component';
import { FooterComponent } from './components/footer/footer.component';
import { PetVaccinesComponent } from './components/pet-vaccines/pet-vaccines.component';

const appRoutes: Routes = [
  { path: 'home', component: HomePageComponent},
  { path: 'login', component: LoginPageComponent},
  { path: 'vaccines', component: PetVaccinesComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full'}
  ];
@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HomePageComponent,
    HeaderComponent,
    PetComponent,
    FooterComponent,
    PetVaccinesComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
