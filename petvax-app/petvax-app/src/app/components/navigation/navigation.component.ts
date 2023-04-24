import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PetsService } from '../../services/pets.service';
import { CookieService } from 'ngx-cookie-service';

interface Pet {
  uuid: string;
  name: string;
  breed: {
    uuid: string;
    name: string;
    species: {
      uuid: string;
      speciesName: string;
    };
  };
  ownerID: string;
  age: string;
  active: boolean;
}

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})

export class NavigationComponent {
  pet: Pet | null = null;
  responseMessage: any;

  constructor(
    private router:Router,
    private cookieService: CookieService,
    private petsService: PetsService,
  ) {}


  ngOnInit(): void {
    if (this.cookieService.check('ownerID')) {
      const petCookie = this.cookieService.get('petId');
      const token = localStorage.getItem('token');

      if (token !== null) {
        this.petsService.getPetByUUID(petCookie, token).subscribe(
          (response: any) => {
            this.pet = response;
          },
          (error: any) => {
            if (error.error?.message) {
              this.responseMessage = error.error?.message;
            } else {
              this.responseMessage = 'Something went wrong';
            }
            this.pet = null;
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
      case "Canine":
        return dogImg;
      case "Feline":
        return catImg;
      default :
        return "";
    }
  }

  navigateWalletPage() {
    this.router.navigate(['/wallet']);
  }
  navigateVaccinePage() {
    this.router.navigate(['/vaccines']);
  }
}


