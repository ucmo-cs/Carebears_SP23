import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import {MatTableModule} from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from "@angular/material/form-field";
import { VaccinationPageComponent } from './components/vaccination-page/vaccination-page.component';
import { WalletPageComponent } from './components/wallet-page/wallet-page.component';
import { WalletDetailsComponent } from './components/wallet-details/wallet-details.component';

const routes: Routes = [
  { path: '', redirectTo: LoginPageComponent, pathMatch: 'full'},
  { path: 'login', component: LoginPageComponent},
  { path: 'home', component: HomePageComponent },
  { path: 'vaccines', component: VaccinationPageComponent},
  { path: 'wallet', component: WalletPageComponent},
  { path: 'walletDetail', component: WalletDetailsComponent},

];

@NgModule({
  imports: [MatTableModule, MatFormFieldModule, MatInputModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }
