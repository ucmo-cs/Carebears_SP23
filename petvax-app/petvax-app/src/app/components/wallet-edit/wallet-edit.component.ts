import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Vaccine } from '../wallet-page/wallet-modal';

import { CookieService } from 'ngx-cookie-service';
import { WalletsService } from '../../services/wallet.service';
import { DatePipe } from '@angular/common';
import { VaccinationRecord } from '../vaccination-page/vaccinationRecord';

interface Wallet {
  walletId: string;
  petId: string;
  name: string;
  purpose: string;
  active: boolean;
}


@Component({
  selector: 'app-wallet-edit',
  templateUrl: './wallet-edit.component.html',
  styleUrls: ['./wallet-edit.component.scss']
})

export class WalletEditComponent {
  datePipe = new DatePipe('en-US');
  urlVaccines = `http://localhost:8080/petvax-services/vaccinationRecord`;
  urlWallet = 'http://localhost:3000/wallets';
  walletData: any;
  walletVaccinesData: any;

  dataSource!: MatTableDataSource<any>;
  displayedColumns = ['name', 'provider', 'date'];
  
  walletID?: number;
  walletName = 'WalletName';
  isEdit: boolean = false;
  newWalletName: any;
  newWalletPurpose: any;
  selectedVaccines: VaccinationRecord [] = [];
  allVaccines: VaccinationRecord[] = [];
  
  wallet: Wallet | null = null;
  responseMessage: any;
  private token = '';
  private cookieValue = '';

  constructor(
    private cookieService: CookieService,
    private walletsService: WalletsService,
    private router: Router,
    private http: HttpClient,
  ) { }

  // Code to fetch information 
  ngOnInit(): void {

    if (this.cookieService.check('ownerID')) {
      const walletCookie = this.cookieService.get('walletID');
      const token = localStorage.getItem('token');
      if (token !== null) {
        this.walletsService.getWalletByUUID(walletCookie, token).subscribe(
          (response: any) => {
            this.wallet = response;
            this.newWalletName = this.wallet?.name;
            this.newWalletPurpose = this.wallet?.purpose;
          },
          (error: any) => {
            if (error.error?.message) {
              this.responseMessage = error.error?.message;
            } else {
              this.responseMessage = 'Something went wrong';
            }
            this.wallet = null;
          });
          
      } else {
        this.responseMessage = 'Token is null';
      }
    } else {
      console.log('Failed to get wallet ID');
    }

    // this.http.get<Vaccine[]>(this.urlVaccines).subscribe((data) => { this.allVaccines = data; });
    // this.getVaccinesList();

    this.cookieValue = this.cookieService.get('petId');
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

  getVaccinesList() {
    return this.http.get(this.urlVaccines);
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

  /*************************************************** OTHER FUNCTIONS ***************************************************/
  // Function for the back button routing.
  goToWalletPage() {
      this.router.navigate(['/wallet']);
  }

  onEdit() {
    this.newWalletName = this.wallet?.name;
    this.newWalletPurpose = this.wallet?.purpose;
    //this.selectedVaccines = this.walletData.vaccines;
    this.isEdit = true;

  }

  onUpdateDetailstoServer() {
    const id = localStorage.getItem('id');
    if (this.newWalletName) {
      const newWallet = { 
        name: this.newWalletName, 
        purpose: this.newWalletPurpose, 
        vaccines: this.selectedVaccines
      };

      this.http.put(this.urlWallet + '/' + id, newWallet).subscribe(() => {
        this.router.navigate(['/walletDetail']);
        window.scrollTo(0, 0);
      });
      
    }
  }

  onCancelEdit() {
    this.isEdit = false;
    this.router.navigate(['/walletDetail']);
    window.scrollTo(0, 0);
  }

}
