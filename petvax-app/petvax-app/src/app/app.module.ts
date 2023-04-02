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
import { FooterComponent } from './components/footer/footer.component';
import { VaccinationPageComponent } from './components/vaccination-page/vaccination-page.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { WalletPageComponent } from './components/wallet-page/wallet-page.component';
import { WalletDetailsComponent } from './components/wallet-details/wallet-details.component';
import { WalletAddComponent } from './components/wallet-add/wallet-add.component';

import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

const appRoutes: Routes = [
  { path: 'walletDetail', component: WalletDetailsComponent},
  { path: 'wallet', component: WalletPageComponent},
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
    FooterComponent,
    VaccinationPageComponent,
    NavigationComponent,
    WalletPageComponent,
    WalletDetailsComponent,
    WalletAddComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatDialogModule,
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
