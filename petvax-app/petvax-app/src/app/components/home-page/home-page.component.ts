import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Pet } from './pet';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})

export class HomePageComponent {
  url = 'http://localhost:8080/petvax-services/pets';
  httpOtions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
    withCredentials: true
  };

  userName = "UserName";
  pets: Pet[] = [];

  constructor(
    private cookieService: CookieService,
    private router:Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.setUserIdCookie();
    this.http.get<Pet[]>(this.url, this.httpOtions).subscribe((data) => { this.pets = data; });
  }

  private setUserIdCookie() {
    
    this.cookieService.set('ownerID', 'f1e18004-dc0b-443f-89e7-dc0c16734518');
  }

  getPetList() {
    return this.http.get(this.url);
  }

  navigateVaccinePage(petUUID: string) {
    this.cookieService.set('petId', petUUID);
    this.router.navigate(['/vaccines']);
  }

  setAnimalImg(petKind:string): string {
    const dogImg = "../../../assets/images/dog-head-temp.png";
    const catImg = "../../../assets/images/cat-head-temp.png";
    
    switch(petKind){
      case "46e45c98-758f-4ff9-9811-389e5b206e0c":
        return dogImg;
      case "43fcc314-d672-11ed-afa1-0242ac120002":
        return catImg;
      default :
        return "";
    }
  }
}
