import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-wallet-add',
  templateUrl: './wallet-add.component.html',
  styleUrls: ['./wallet-add.component.scss']
})
export class WalletAddComponent {
  newWalletName: string = "";

  constructor(
    private http: HttpClient,
  ) {}

  reloadPage() {
    location.reload();
  }

  onSubmit() {
    if (this.newWalletName) {
      const newWallet = { name: this.newWalletName };
      this.http.post('http://localhost:3000/wallets', newWallet).subscribe(() => {
        this.reloadPage();
      });
    }
  }

}
