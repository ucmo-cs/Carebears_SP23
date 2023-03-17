import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  userName = "User";
  initialName = this.userName.charAt(0);
  isHomePage = false;

  constructor(
    private router:Router
  ) {}

  ngOnInit(): void {
    this.isCurrentHomePage();
  }

  onHomeButtonClick() {
    this.router.navigate(['/home']);
  }

  isCurrentHomePage() {
    if(window.location.pathname === '/home') {
      this.isHomePage = true;
    }
  }
}
