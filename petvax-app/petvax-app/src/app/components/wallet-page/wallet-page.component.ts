import { Component } from '@angular/core';
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

  // URL used for calls from json.db file. Will be changed to APIs when ready. 
  url = 'http://localhost:3000/wallets';

  constructor(
    public dialog: MatDialog,
    private router:Router,
    private http: HttpClient
  ) {}

  // Code fetches data from the db.json and assigns it to a local variable wallets that can be used in the component's template.
  ngOnInit(): void {
    
    this.http.get<Wallets[]>(this.url).subscribe((data) => { this.wallets = data; });
    this.getWalletList();
  }

  // Function to get wallets from URL. Used in HTML. 
  getWalletList() {
    return this.http.get(this.url);
  }

  // Function to set a WalletID to local storage when clicked on a wallet. 
  // It also redirects to wallet-details page. 
  viewWalletInfo(walletID: number){
    localStorage.setItem('id', walletID.toString());
    this.router.navigate(['/walletDetail']);
  }

  goToAddWaletPage(){
    this.router.navigate(['/walletAdd']);
  }
}
