import { Component } from '@angular/core';
import { WALLET_LIST } from './WALLET_LIST_MOCK_DATA';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { WalletAddComponent } from '../wallet-add/wallet-add.component';
import {FormsModule} from '@angular/forms';
import { Wallets } from './wallet-modal';

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
    public dialog: MatDialog,
    private router:Router,
    private http: HttpClient,
  ) {}

  ngOnInit(): void {
    this.getWalletList();
    this.http.get<Wallets[]>(this.url).subscribe((data) => { this.wallets = data; });
  }

  getWalletList() {
    return this.http.get(this.url);
  }

  goToWalletDetail(){
    this.router.navigate(['/walletDetail']);
  }

  showAddWalletForm(): void{
    this.dialog.open(WalletAddComponent, {
      width: '500px'
    });
  }
}
