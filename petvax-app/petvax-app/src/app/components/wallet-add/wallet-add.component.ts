import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Vaccine } from '../wallet-page/wallet-modal';
import { WalletsService } from 'src/app/services/wallet.service';
import { CookieService } from 'ngx-cookie-service';
import { VaccinationRecord } from '../vaccination-page/vaccinationRecord';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-wallet-add',
  templateUrl: './wallet-add.component.html',
  styleUrls: ['./wallet-add.component.scss']
})

export class WalletAddComponent {
  //urlWallet = 'http://localhost:3000/wallets';
  //urlVaccines = 'http://localhost:3000/vaccines';
  datePipe = new DatePipe('en-US');
  urlVaccines = `http://localhost:8080/petvax-services/vaccinationRecord`;
  newWalletName: string = "";
  newWalletPurpose: string = "";
  allVaccines: VaccinationRecord[] = [];
  availableVaccines: VaccinationRecord[] = [...this.allVaccines];
  selectedVaccines: VaccinationRecord [] = [];
  private token = '';
  private cookieValue = '';

  constructor(
    private cookieService: CookieService,
    private walletService: WalletsService,
    private http: HttpClient,
    private router:Router,
  ) {}
  
  // Code fetches data from the db.json and assigns it to a local variable wallets that can be used in the component's template.
  ngOnInit(): void {
    this.token = localStorage.getItem('token') || '';
    this.cookieValue = this.cookieService.get('petId');
    this.setupDataSource();
    // this.http.get<Vaccine[]>(this.urlVaccines).subscribe((data) => { this.allVaccines = data; });
    this.getVaccinesList();
  }

  setupDataSource(): void {
    const httpOtions = {
      headers: new HttpHeaders({
        'Authorization': `Bearer ${this.token}`,
        'Content-Type': 'application/json',
        'Cookie': `petId=${this.cookieValue}`
      }),
      withCredentials: true
    };

    this.http.get<VaccinationRecord[]>(this.urlVaccines, httpOtions).subscribe((data: any) => {
        this.allVaccines = data;
    });
  }

  // Function to get wallets from URL. Used in HTML. 
  getVaccinesList() {
    return this.http.get(this.urlVaccines);
  }

  // Code for submitting form and create a new wallet with contents. 
  onSubmit() {
    if (this.newWalletName) {
      const newWallet = { 
        petId: this.cookieService.get('petId'),
        name: this.newWalletName, 
        purpose: this.newWalletPurpose, 
        active: true,
        //vaccines: this.selectedVaccines
      };

    const token = localStorage.getItem('token');

    if (token) {
        this.walletService.createWallet(newWallet, token).subscribe(() => {
          this.router.navigate(['/wallet']);
          window.scrollTo(0, 0);
        });
    } else {
        console.error('Token is null');
    }
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
