import {LiveAnnouncer} from '@angular/cdk/a11y';
import {AfterViewInit, Component, ViewChild, ElementRef} from '@angular/core';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
declare var require: any
const html2pdf = require('html2pdf.js');
import jsPDF from 'jspdf';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';

export interface VaccinesList {
  name: string;
  id: number;
  provider: string;
  date: string; 
}

@Component({
  selector: 'app-vaccination-page',
  templateUrl: './vaccination-page.component.html',
  styleUrls: ['./vaccination-page.component.scss'],
})
export class VaccinationPageComponent {
  vaccinationRecord: any[] = [];
  dataSource!: MatTableDataSource<any>;
  displayedColumns = ['name', 'provider', 'date'];

  constructor(
    private router: Router,
    private http: HttpClient,
  ) { }
  
   // Code to fetch information from db.json only for the passed ID from WalletPage. 
   ngOnInit(): void {
    this.setupDataSource();
  }

  /*************************************************** TABLE DATA FUNCTIONS ***************************************************/
  @ViewChild(MatSort, { static: false }) sort!: MatSort;

  setupDataSource(): void {
    const url = 'http://localhost:3000/vaccines';
    this.http.get<VaccinesList[]>(url).subscribe((data: any) => {
      console.log(data);
      this.dataSource = new MatTableDataSource<VaccinesList>(data);
      this.dataSource.sort = this.sort;
    });
  }

  /*************************************************** SEARCH FUNCTION ***************************************************/

  // Table Search Filter
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  /*************************************************** PRINT PDF ***************************************************/
  @ViewChild('content', { static: false }) content!: ElementRef;

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
      image: { type: 'jpeg', quality: 1 },
      html2canvas: { dpi: 192, letterRendering: true },
      jsPDF: { unit: 'pt', format: 'a4', orientation: 'portrait'},
      pagebreak: { avoid: ['.table-header'] }
    }).save();
  }
}


