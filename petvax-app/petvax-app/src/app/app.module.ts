import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import {MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSortModule} from '@angular/material/sort';

//import {LiveAnnouncer} from '@angular/cdk/a11y';
//import {AfterViewInit, ViewChild} from '@angular/core';


import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { HeaderComponent } from './components/header/header.component';
import { PetComponent } from './components/pet/pet.component';
import { FooterComponent } from './components/footer/footer.component';
import { VaccinationPageComponent } from './components/vaccination-page/vaccination-page.component';
import { NavigationComponent } from './components/navigation/navigation.component';

const appRoutes: Routes = [
  { path: 'vaccines', component: VaccinationPageComponent},
  { path: 'home', component: HomePageComponent},
  { path: 'login', component: LoginPageComponent},
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
    VaccinationPageComponent,
    NavigationComponent
  ],
  imports: [
    MatTableModule, 
    MatFormFieldModule, MatInputModule, BrowserAnimationsModule, MatSortModule,
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      ), 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
