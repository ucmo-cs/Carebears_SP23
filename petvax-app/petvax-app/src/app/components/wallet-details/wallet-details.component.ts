import {AfterViewInit, Component, ViewChild, ElementRef} from '@angular/core';
import { WALLET_LIST } from '../wallet-page/WALLET_LIST_MOCK_DATA';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';
import {MatTableDataSource} from '@angular/material/table';
import {MatSort, Sort} from '@angular/material/sort';
declare var require: any
const html2pdf = require('html2pdf.js');
import jsPDF from 'jspdf';

export interface VaccinesList {
  name: string;
  id: number;
  provider: string;
  date: string; 
}

// Table Content
const VAX_DATA: VaccinesList[] = [
  {id: 1, name: 'Rabies01', provider: 'PettyPet01', date: '02/01/2023'},
  {id: 3, name: 'Rabies03', provider: 'PettyPet03', date: '02/03/2023'},
  {id: 4, name: 'Rabies04', provider: 'PettyPet04', date: '02/04/2023'},
  {id: 6, name: 'Rabies06', provider: 'PettyPet06', date: '02/06/2023'},
  {id: 7, name: 'Rabies07', provider: 'PettyPet07', date: '02/07/2023'},
];

@Component({
  selector: 'app-wallet-details',
  templateUrl: './wallet-details.component.html',
  styleUrls: ['./wallet-details.component.scss']
})
export class WalletDetailsComponent {
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

  goToWalletPage() {
    this.router.navigate(['/wallet']);
  }

  displayedColumns = ['name', 'provider', 'date'];
  dataSource = new MatTableDataSource(VAX_DATA);


  @ViewChild(MatSort, { static: false }) sort!: MatSort;
  @ViewChild('content', { static: false }) content!: ElementRef;

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

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
}
