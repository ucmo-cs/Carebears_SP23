import { HttpClient } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Vaccine } from '../wallet-page/wallet-modal';

@Component({
  selector: 'app-wallet-edit',
  templateUrl: './wallet-edit.component.html',
  styleUrls: ['./wallet-edit.component.scss']
})
export class WalletEditComponent {
  
  urlVaccines = 'http://localhost:3000/vaccines';
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
  selectedVaccines: Vaccine[] = [];
  allVaccines: Vaccine[] = [];
  

  constructor(
    private router: Router,
    private http: HttpClient,
  ) { }

  // Code to fetch information from db.json only for the passed ID from WalletPage. 
  ngOnInit(): void {
    const id = localStorage.getItem('id');

    if (id) {
      const url = `http://localhost:3000/wallets?id=${id}`;

      this.http.get(url).subscribe((data: any) => {
        console.log(data);
        this.walletData = data[0];
        this.setupDataSource();
        this.newWalletName = this.walletData.name;
        this.newWalletPurpose = this.walletData.purpose;
        this.selectedVaccines = this.walletData.vaccines;
      });
    }

    this.http.get<Vaccine[]>(this.urlVaccines).subscribe((data) => { this.allVaccines = data; });
    this.getVaccinesList();

  }
  
  getVaccinesList() {
    return this.http.get(this.urlVaccines);
  }

    /******************************************* DOUBLE CLICK FUNCTIONS *******************************************/
  addVaccine(selectedVaccine: any): void {

    if (Array.isArray(this.selectedVaccines)) {
      if(this.selectedVaccines.findIndex((item) => item.id == selectedVaccine.id) == -1) {
        this.selectedVaccines.push(selectedVaccine);
      }
    } else {
      this.selectedVaccines = [selectedVaccine];
    }
  }
  
  removeVaccine(selectedVaccine: any): void {
    const index = this.selectedVaccines.indexOf(selectedVaccine);
    if (index >= 0) {
      this.selectedVaccines.splice(index, 1);
    }
  }
  
  /*************************************************** TABLE FUNCTIONS ***************************************************/
  @ViewChild(MatSort, { static: false }) sort!: MatSort;
  // Function set-ups data source for mat-table.
  setupDataSource(): void {
    this.dataSource = new MatTableDataSource(this.walletData.vaccines);
    this.dataSource.sort = this.sort;
  }


  /*************************************************** OTHER FUNCTIONS ***************************************************/
  // Function for the back button routing.
  goToWalletPage() {
      this.router.navigate(['/wallet']);
  }

  onEdit() {
    this.newWalletName = this.walletData.name;
    this.newWalletPurpose = this.walletData.purpose;
    this.selectedVaccines = this.walletData.vaccines;
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
