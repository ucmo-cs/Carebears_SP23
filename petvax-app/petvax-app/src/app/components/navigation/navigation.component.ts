import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent {
  petName = "DogName";
  petImg = "../../../assets/images/dog-head-temp.png";  
  
  constructor(
    private router:Router
  ) {}


  ngOnInit(): void {}
  navigateWalletPage() {
    this.router.navigate(['/wallet']);
  }
  navigateVaccinePage() {
    this.router.navigate(['/vaccines']);
  }
}


