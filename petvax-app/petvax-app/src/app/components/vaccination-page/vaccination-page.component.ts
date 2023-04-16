import {LiveAnnouncer} from '@angular/cdk/a11y';
import {AfterViewInit, Component, ViewChild, ElementRef} from '@angular/core';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
declare var require: any
const html2pdf = require('html2pdf.js');
import jsPDF from 'jspdf';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { VaccinationRecord } from './vaccinationRecord';
import { MatInput } from '@angular/material/input';
import { DatePipe } from '@angular/common';


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
  dataSource!: MatTableDataSource<any>;
  displayedColumns = ['vaccination.name', 'provider.name', 'vaccinationDate'];
  datePipe = new DatePipe('en-US');

  constructor(
    private router: Router,
    private http: HttpClient,
  ) { }
  
   // Code to fetch information from db.json only for the passed ID from WalletPage. 
   ngOnInit(): void {
    this.setupDataSource();
  }

  /*************************************************** TABLE DATA FUNCTIONS ***************************************************/
  @ViewChild(MatSort, { static: true }) sort!: MatSort;

  setupDataSource(): void {
    //const url = 'http://localhost:3000/vaccinationRecord';
    const url = `http://localhost:8080/petvax-services/vaccinationRecord`;
    const httpOtions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Cookie': 'petId="a90a655e-b25b-11ed-8531-0242ac120002"'
      }),
      withCredentials: true
    };
    

    this.http.get<VaccinationRecord[]>(url, httpOtions).subscribe((data: any) => {
      console.log(data);
      this.dataSource = new MatTableDataSource<VaccinationRecord>(data);
      // Function used for sorting objects within object
      this.dataSource.sortingDataAccessor = (item, property) => {
        switch(property) {
          case 'vaccination.name': return item.vaccination.name;
          case 'provider.name': return item.provider.name;
          default: return item[property];
        }
      };

      this.dataSource.sort = this.sort;
    });
  }

  /*************************************************** SEARCH FUNCTION ***************************************************/
  // Table Search Filter
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.trim().toLowerCase();
    
    this.dataSource.filter = filterValue;
    
    // Function from MatTableDataSource to specify a custom filter
    // to determine rows to show or hide in table based on input
    this.dataSource.filterPredicate = (data, filter) => {
      const searchText = filter.toLowerCase();
      const vaccinationDate = new Date(data.vaccinationDate);
      const formattedDate = `${vaccinationDate.getMonth()+1}`.padStart(2, '0') +
                            `/${vaccinationDate.getDate()}`.padStart(2, '0') +
                            `/${vaccinationDate.getFullYear()}`;
  
      return (
        data.vaccination.name.toLowerCase().includes(searchText) ||
        data.provider.name.toLowerCase().includes(searchText) || 
        formattedDate.toLowerCase().includes(searchText)
      );
    };
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


