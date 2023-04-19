import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OwnerService } from '../../services/owner.service';
import { CookieService } from 'ngx-cookie-service';

interface Owner {
  fname: string;
}

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

  firstLetterName = '';
  isHomePage = false;
  owner: Owner = { fname: ''};
  responseMessage: any;

  constructor(
    private router: Router,
    private cookieService: CookieService,
    private ownerService: OwnerService
  ) {}

  ngOnInit(): void {
    if (this.cookieService.check('ownerID')) {
      const ownerCookie = this.cookieService.get('ownerID');
      const token = localStorage.getItem('token');
      if (token !== null) {
          this.ownerService.getOwnerDetails(ownerCookie, token).subscribe(
            (response: any) => {
              this.owner = response;
              this.firstLetterName = this.owner.fname.charAt(0);
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
    /////////////////
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
