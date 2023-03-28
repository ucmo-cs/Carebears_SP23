import { Component } from '@angular/core';
import { WALLET_LIST } from './WALLET_LIST_MOCK_DATA';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-wallet-page',
  templateUrl: './wallet-page.component.html',
  styleUrls: ['./wallet-page.component.scss']
})
export class WalletPageComponent {
  data: any;

  constructor(
    private router:Router
    // private http: HttpClient
  ) {

  }
  ngOnInit(): void {
    this.getWalletList();
  }

  getWalletList() {
    return WALLET_LIST;
  }

  navigateWalletDetail() {
    this.router.navigate(['/walletDetail']);
  }
}
