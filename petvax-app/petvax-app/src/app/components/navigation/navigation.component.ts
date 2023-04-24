import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PetsService } from '../../services/pets.service';
import { CookieService } from 'ngx-cookie-service';

interface Pet {
  name: string;
  speciesID: string;
}

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})

export class NavigationComponent {
  pet: Pet = { name: '', speciesID: ''};
  responseMessage: any;
  petName = "DogName";
  petImg = "../../../assets/images/dog-head-temp.png"; 
  
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

  navigateWalletPage() {
    this.router.navigate(['/wallet']);
  }
  navigateVaccinePage() {
    this.router.navigate(['/vaccines']);
  }
}


