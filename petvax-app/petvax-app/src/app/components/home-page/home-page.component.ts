import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})

export class HomePageComponent {
  userName = "UserName";
  pet1Name = "CatName";
  pet2Name = "DogName";
  pet1 = setAnimalImg("cat");
  pet2 = setAnimalImg("dog");
}

function setAnimalImg(animalSpecies:string): string {
  const dogImg = "../../../assets/images/dog-head-temp.png";
  const catImg = "../../../assets/images/cat-head-temp.png";
  
  switch(animalSpecies){
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
