import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { WalletAddComponent } from '../wallet-add/wallet-add.component';
import {FormsModule} from '@angular/forms';
//import { Wallets } from './wallet-modal';
import { WalletDetailsComponent } from '../wallet-details/wallet-details.component';
import { CookieService } from 'ngx-cookie-service';

import { WalletsService } from '../../services/wallet.service';

interface Wallet {
  walletId: string;
  petId: string;
  name: string;
  purpose: string;
  active: boolean;
}


@Component({
  selector: 'app-wallet-page',
  templateUrl: './wallet-page.component.html',
  styleUrls: ['./wallet-page.component.scss']
})

export class WalletPageComponent {
  data: any;
  wallets: Wallet[] = [];
  responseMessage: any;

  // URL used for calls from json.db file. Will be changed to APIs when ready. 
  url = 'http://localhost:3000/wallets';
  selectedActionIndex: number = -1;

  constructor(
    private cookieService: CookieService,
    private walletsService: WalletsService,
    public dialog: MatDialog,
    private router:Router,
    private http: HttpClient
  ) {}

  // Code fetches data from the db.json and assigns it to a local variable wallets that can be used in the component's template.
  ngOnInit(): void {
    
    if (this.cookieService.check('ownerID')) {
      const petCookie = this.cookieService.get('petId');
      const token = localStorage.getItem('token');
      if (token !== null) {
        this.walletsService.getWalletsByPet(petCookie, token).subscribe(
          (response: any) => {
            this.wallets = response;
          },
          (error: any) => {
            if (error.error?.message) {
              this.responseMessage = error.error?.message;
            } else {
              this.responseMessage = 'Something went wrong';
            }
          });
      } else {
        this.responseMessage = 'Token is null';
      }
    } else {
      console.log('Failed to get pet ID');
    }


    // this.http.get<Wallets[]>(this.url).subscribe((data) => { this.wallets = data; });
    // this.getWalletList();
  }

  // Function to get wallets from URL. Used in HTML. 
  getWalletList() {
    return this.http.get(this.url);
  }

  onGetActions(selectedIndex: number) {
    this.selectedActionIndex = selectedIndex
  }

  // Function to set a WalletID to local storage when clicked on a wallet. 
  // It also redirects to wallet-details page. 
  viewWalletInfo(walletID: string){
    this.cookieService.set('walletID', walletID);
    this.router.navigate(['/walletDetail']);
  }

  goToAddWaletPage(){
    this.router.navigate(['/walletAdd']);
  }

  removeWallet(walletID: string) {
    const token = localStorage.getItem('token');
    if(token) {
      this.walletsService.deleteWallet(walletID, token).subscribe(() => {
          this.selectedActionIndex = -1;
          window.location.reload();
      });
    }
  }
}
