import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import {MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import { VaccinationPageComponent } from './components/vaccination-page/vaccination-page.component';
import { WalletPageComponent } from './components/wallet-page/wallet-page.component';

const routes: Routes = [
  { path: 'login', component: LoginPageComponent, pathMatch: 'full'},
  { path: 'home', component: HomePageComponent },
  { path: 'vaccines', component: VaccinationPageComponent},
  { path: 'wallet', component: WalletPageComponent},
];

@NgModule({
  imports: [MatTableModule, MatFormFieldModule, MatInputModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
