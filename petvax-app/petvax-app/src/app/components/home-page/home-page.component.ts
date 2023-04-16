import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PET_LIST } from './PET_LIST_MOCK_DATA';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Pet } from './pet';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})

export class HomePageComponent {
  userName = "UserName";

  data: any;

  constructor(
    private cookieService: CookieService,
    private router:Router
    // private http: HttpClient
  ) {

  }
  ngOnInit(): void {
    this.getPetList();
  }

  getPetList() {
    return PET_LIST;
  }
  
  navigateVaccinePage() {
    // this.cookieService.set('petId', 'a90a655e-b25b-11ed-8531-0242ac120002');
    // localStorage.setItem('petId', 'a90a655e-b25b-11ed-8531-0242ac120002');
    this.router.navigate(['/vaccines']);
  }

  setAnimalImg(petKind:string): string {
    const dogImg = "../../../assets/images/dog-head-temp.png";
    const catImg = "../../../assets/images/cat-head-temp.png";
    
    switch(petKind){
      case "dog":
        return dogImg;
        break;
      case "cat":
        return catImg;
        break;
      default :
        return "";
    }
  }
}
