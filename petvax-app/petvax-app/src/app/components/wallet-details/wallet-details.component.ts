import { Component, ViewChild, ElementRef} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
declare var require: any
const html2pdf = require('html2pdf.js');
import jsPDF from 'jspdf';
import { Vaccine } from '../wallet-page/wallet-modal';

import { CookieService } from 'ngx-cookie-service';
import { WalletsService } from '../../services/wallet.service';

interface Wallet {
  walletId: string;
  petId: string;
  name: string;
  purpose: string;
  active: boolean;
}


export interface VaccinesList {
  name: string;
  id: number;
  provider: string;
  date: string; 
}

@Component({
  selector: 'app-wallet-details',
  templateUrl: './wallet-details.component.html',
  styleUrls: ['./wallet-details.component.scss']
})

export class WalletDetailsComponent {
  wallet: Wallet | null = null;
  responseMessage: any;

  urlVaccines = 'http://localhost:3000/vaccines';
  walletData: any;
  walletVaccinesData: any;

  dataSource!: MatTableDataSource<any>;
  displayedColumns = ['name', 'provider', 'date'];
  

  walletName = 'WalletName';
  isEdit: boolean = false;
  newWalletName: any;
  newWalletPurpose: any;
  allVaccines: Vaccine[] = [];

  constructor(
    private cookieService: CookieService,
    private walletsService: WalletsService,
    private router: Router,
    private http: HttpClient,
  ) { }

  ngOnInit(): void {
    
    if (this.cookieService.check('ownerID')) {
      const walletCookie = this.cookieService.get('walletID');
      const token = localStorage.getItem('token');
      if (token !== null) {
        this.walletsService.getWalletByUUID(walletCookie, token).subscribe(
          (response: any) => {
            this.wallet = response;
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

    this.http.get<Vaccine[]>(this.urlVaccines).subscribe((data) => { this.allVaccines = data; });
    this.getVaccinesList();

  }
  
  getVaccinesList() {
    return this.http.get(this.urlVaccines);
  }

  /*************************************************** TABLE FUNCTIONS ***************************************************/
  @ViewChild(MatSort, { static: false }) sort!: MatSort;
  // Function set-ups data source for mat-table.
  setupDataSource(): void {
    this.dataSource = new MatTableDataSource(this.walletData.vaccines);
    this.dataSource.sort = this.sort;
  }

  /*************************************************** PRINT FUNCTIONS ***************************************************/
  @ViewChild('content', { static: false }) content!: ElementRef;
  
  // Function to generate a pdf file for the print button. 
  public generatePDF(): void {
    const doc = new jsPDF('p', 'pt', 'a4');

    const specialElementHandlers = {
      '#editor': function (element: any, renderer: any) {
        return true;
      }
    };

    const table = this.content.nativeElement;

    html2pdf().from(table).set({
      margin: 10,
      filename: 'vaccines.pdf',
      image: { type: 'png', quality: 1 },
      html2canvas: { dpi: 200, scale: 4, letterRendering: true },
      jsPDF: { unit: 'pt', format: 'a4', orientation: 'portrait'},
      pagebreak: { avoid: ['.table-header'] }
    }).save();
  }

  /*************************************************** OTHER FUNCTIONS ***************************************************/
  // Function for the back button routing.
  goToWalletPage() {
      this.router.navigate(['/wallet']);
  }

  onEdit() {
    this.router.navigate(['/walletEdit']);
  }


}
