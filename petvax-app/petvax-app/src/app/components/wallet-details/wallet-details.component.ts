import {Component, ViewChild, ElementRef} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
declare var require: any
const html2pdf = require('html2pdf.js');
import jsPDF from 'jspdf';

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
  
  walletData: any;
  walletVaccinesData: any;

  dataSource!: MatTableDataSource<any>;
  displayedColumns = ['name', 'provider', 'date'];
  
  walletID?: number;
  walletName = 'WalletName';
  

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
      });
    }
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
}
