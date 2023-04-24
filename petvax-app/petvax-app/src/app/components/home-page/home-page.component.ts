import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PetsService } from '../../services/pets.service';
import { OwnerService } from '../../services/owner.service';
import { CookieService } from 'ngx-cookie-service';

interface Pet {
  uuid: string;
  name: string;
  speciesID: string;
  breedID: string;
  ownerID: string;
  age: string;
  active: boolean;
}

interface Owner {
  fname: string;
}

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})

export class HomePageComponent {
  responseMessage: any;
  pets: Pet[] = [];
  owner: Owner = { fname: ''};


  constructor(
    private router: Router,
    private cookieService: CookieService,
    private petsService: PetsService,
    private ownerService: OwnerService
  ) {}

  ngOnInit() {
    if (this.cookieService.check('ownerID')) {
      const ownerCookie = this.cookieService.get('ownerID');
      const token = localStorage.getItem('token');
      if (token !== null) {
        this.petsService.getPetsByOwner(ownerCookie, token).subscribe(
          (response: any) => {
            this.pets = response;
          },
          (error: any) => {
            if (error.error?.message) {
              this.responseMessage = error.error?.message;
            } else {
              this.responseMessage = 'Something went wrong';
            }
          });

          this.ownerService.getOwnerDetails(ownerCookie, token).subscribe(
            (response: any) => {
              this.owner = response;
            },
            (error: any) => {
              if (error.error?.message) {
                this.responseMessage = error.error?.message;
              } else {
                this.responseMessage = 'Something went wrong';
              }
            });
      } else {
        this.responseMessage = 'Token is null';
      }
    } else {
      console.log('Failed to get owner ID');
    }
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

    navigateVaccinePage(uuid: string) {
      this.cookieService.set('petId', uuid);
      this.router.navigate(['/vaccines']);
    }
}
