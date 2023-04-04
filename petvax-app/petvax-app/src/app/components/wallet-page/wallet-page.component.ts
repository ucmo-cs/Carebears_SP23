import { Component } from '@angular/core';
import { WALLET_LIST } from './WALLET_LIST_MOCK_DATA';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { WalletAddComponent } from '../wallet-add/wallet-add.component';
import {FormsModule} from '@angular/forms';
import { Wallets } from './wallet-modal';
import { WalletDetailsComponent } from '../wallet-details/wallet-details.component';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-wallet-page',
  templateUrl: './wallet-page.component.html',
  styleUrls: ['./wallet-page.component.scss']
})
export class WalletPageComponent {
  data: any;
  wallets: Wallets[] = [];
  url = 'http://localhost:3000/wallets';

  constructor(
    //private cookieService: CookieService,
    public dialog: MatDialog,
    private router:Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.getWalletList();
    this.http.get<Wallets[]>(this.url).subscribe((data) => { this.wallets = data; });
  }

  // ngOnInit(): void {
  //   const id = this.cookieService.get('id');

  //   if (id) {
  //     const url = `http://localhost:3000/wallets?id=${id}`;

  //     this.http.get(url).subscribe((data: any) => {
  //       console.log(data);
  //       this.wallets = data;
  //     });
  //   }

  //   this.getWalletList();
  // }

  getWalletList() {
    return this.http.get(this.url);
  }

  viewWalletInfo(walletID: number){
    //this.cookieService.set('id', walletID.toString());
    localStorage.setItem('id', walletID.toString());
    this.router.navigate(['/walletDetail']);
  }

  showAddWalletForm(): void{
    this.dialog.open(WalletAddComponent, {
      width: '500px'
    });
  }
}
