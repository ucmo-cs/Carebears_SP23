import {LiveAnnouncer} from '@angular/cdk/a11y';
import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

export interface VaccinesList {
  name: string;
  id: number;
  provider: string;
  date: string; 
}

// Table Content
const VAX_DATA: VaccinesList[] = [
  {id: 1, name: 'Rabies01', provider: 'PettyPet01', date: '02/01/2023'},
  {id: 2, name: 'Rabies02', provider: 'PettyPet02', date: '02/02/2023'},
  {id: 3, name: 'Rabies03', provider: 'PettyPet03', date: '02/03/2023'},
  {id: 4, name: 'Rabies04', provider: 'PettyPet04', date: '02/04/2023'},
  {id: 5, name: 'Rabies05', provider: 'PettyPet05', date: '02/05/2023'},
  {id: 6, name: 'Rabies06', provider: 'PettyPet06', date: '02/06/2023'},
  {id: 7, name: 'Rabies07', provider: 'PettyPet07', date: '02/07/2023'},
  {id: 8, name: 'Rabies08', provider: 'PettyPet08', date: '02/08/2023'},
  {id: 9, name: 'Rabies09', provider: 'PettyPet09', date: '02/09/2023'},
  {id: 10, name: 'Rabies10', provider: 'PettyPet10', date: '02/10/2023'},
];

@Component({
  selector: 'app-vaccination-page',
  templateUrl: './vaccination-page.component.html',
  styleUrls: ['./vaccination-page.component.scss'],
})

export class VaccinationPageComponent implements AfterViewInit{
  // Table Headers
  displayedColumns = ['name', 'provider', 'date'];
  dataSource = new MatTableDataSource(VAX_DATA);

  constructor(private _liveAnnouncer: LiveAnnouncer) {
    
  }

  @ViewChild(MatSort, { static: false }) sort!: MatSort;

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  // Table Sort
  announceSortChange(sortState: Sort) {
      if (sortState.direction) {
        this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
      } else {
        this._liveAnnouncer.announce('Sorting cleared');
      }
  }

  // Table Search Filter
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  
}


