import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {
  username = '';
  password = '';
  hide = true;
  responseMessage:any;

  constructor(
    private router:Router,
    private cookieService: CookieService,
    private userService:UserService
  ){}

  ngOnInit() {
  }

  handleSubmit() {
    const data = {
      username: this.username,
      password: this.password
    };
    this.userService.login(data).subscribe(
      (response: any) => {
        localStorage.setItem('token', response.token);
        const token = localStorage.getItem('token');
        if (token !== null) {
          this.userService.getOwnerId(this.username, token).subscribe(
            (response: any) => {
              const ownerId = response.ownerId;
              const expirationDate = new Date(Date.now() + 1000 * 60 * 60 * 10);
              this.cookieService.set('ownerID', ownerId, expirationDate, '/', '', true, 'Strict');
              this.router.navigate(['/home']);
            },
            (error: any) => {
              if (error.error?.message) {
                this.responseMessage = error.error?.message;
              } else {
                this.responseMessage = 'Something went wrong';
              }
            }
          );
        } else {
          console.log('Token is null');
        }
      },
      (error: any) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        } else {
          this.responseMessage = 'Something went wrong';
        }
      }
    );
  }

}
