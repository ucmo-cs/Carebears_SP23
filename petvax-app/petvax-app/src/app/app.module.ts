import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';

const appRoutes: Routes = [
  // { path: 'vaccines', component: VaccinePageComponent},
  { path: 'home', component: HomePageComponent},
  { path: 'login', component: LoginPageComponent}
  ];
@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HomePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(
      appRoutes,
      )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
