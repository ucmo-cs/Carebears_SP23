import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Vaccine } from '../wallet-page/wallet-modal';

@Component({
  selector: 'app-wallet-add',
  templateUrl: './wallet-add.component.html',
  styleUrls: ['./wallet-add.component.scss']
})

export class WalletAddComponent {
  urlWallet = 'http://localhost:3000/wallets';
  urlVaccines = 'http://localhost:3000/vaccines';
  newWalletName: string = "";
  newWalletPurpose: string = "";
  allVaccines: Vaccine[] = [];
  availableVaccines: Vaccine[] = [...this.allVaccines];
  selectedVaccines: Vaccine [] = [];

  constructor(
    private http: HttpClient,
    private router:Router,
  ) {}
  
  // Code fetches data from the db.json and assigns it to a local variable wallets that can be used in the component's template.
  ngOnInit(): void {
    
    this.http.get<Vaccine[]>(this.urlVaccines).subscribe((data) => { this.allVaccines = data; });
    this.getVaccinesList();
  }

  // Function to get wallets from URL. Used in HTML. 
  getVaccinesList() {
    return this.http.get(this.urlVaccines);
  }

  // Code for submitting form and create a new wallet with contents. 
  onSubmit() {
    if (this.newWalletName) {
      const newWallet = { 
        name: this.newWalletName, 
        purpose: this.newWalletPurpose, 
        vaccines: this.selectedVaccines
      };
      this.http.post(this.urlWallet, newWallet).subscribe(() => {
        this.router.navigate(['/wallet']);
        window.scrollTo(0, 0);
      });
    }
  }

  /******************************************* DOUBLE CLICK FUNCTIONS *******************************************/
  addVaccine(selectedVaccine: any): void {
    if (!this.selectedVaccines.includes(selectedVaccine)) {
      this.selectedVaccines.push(selectedVaccine);
    }
    console.log("Working!");
  }
  
  removeVaccine(selectedVaccine: any): void {
    const index = this.selectedVaccines.indexOf(selectedVaccine);
    if (index >= 0) {
      this.selectedVaccines.splice(index, 1);
    }
  }

  /******************************************* OTHER FUNCTIONS *******************************************/
  cancelForm(){
    this.router.navigate(['/wallet']);
    window.scrollTo(0, 0);

  }

  reloadPage() {
    location.reload();
  }

}
