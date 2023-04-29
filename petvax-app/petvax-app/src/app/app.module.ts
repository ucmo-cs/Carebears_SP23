import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { CookieService } from 'ngx-cookie-service';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { TokenInterceptorInterceptor } from './services/token-interceptor.interceptor';

import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { VaccinationPageComponent } from './components/vaccination-page/vaccination-page.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { WalletPageComponent } from './components/wallet-page/wallet-page.component';
import { WalletDetailsComponent } from './components/wallet-details/wallet-details.component';
import { WalletAddComponent } from './components/wallet-add/wallet-add.component';
import { WalletEditComponent } from './components/wallet-edit/wallet-edit.component';

import {MatGridListModule} from '@angular/material/grid-list';
import { MatDialogModule } from '@angular/material/dialog';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import {MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSortModule } from '@angular/material/sort';



const appRoutes: Routes = [
  { path: 'walletAdd', component: WalletAddComponent},
  { path: 'walletEdit', component: WalletEditComponent},
  { path: 'walletDetail', component: WalletDetailsComponent},
  { path: 'wallet', component: WalletPageComponent},
  { path: 'vaccines', component: VaccinationPageComponent},
  { path: 'wallet', component: WalletPageComponent},
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
    WalletAddComponent,
    WalletEditComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    MatCardModule,
    MatDialogModule,
    MatTableModule, 
    MatMenuModule,
    MatGridListModule,
    MatFormFieldModule, MatInputModule, BrowserAnimationsModule, MatSortModule,
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      ),
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorInterceptor,
      multi: true
    },
    CookieService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
