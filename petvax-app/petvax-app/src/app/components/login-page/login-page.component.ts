import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';
import { PetsService } from '../../services/pets.service';
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
    private userService:UserService,
    private cookieService: CookieService,
    private petsService:PetsService
  ){}

  ngOnInit() {
//     this.userService.checkToken().subscribe(
//       (response:any) => {
//         this.router.navigate(['/home']);
//       },
//       (error:any) => {
//         console.log(error);
//       }
//     );
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
              this.cookieService.set('ownerId', ownerId);
//               TODO: Address Refused cookie error
//               if (ownerId) {
//                 let ownerCookie = this.cookieService.get('ownerId');
//                 console.log(ownerCookie);
//                 this.petsService.getPetsByOwner(ownerCookie, token).subscribe(
//                   (response: any) => {
//                     localStorage.setItem('pets', JSON.stringify(response));
//                     this.router.navigate(['/home']);
//                   },
//                   (error: any) => {
//                     if (error.error?.message) {
//                       this.responseMessage = error.error?.message;
//                     } else {
//                       this.responseMessage = 'Something went wrong';
//                     }
//                   }
//                 );
//               } else {
//                 this.responseMessage = 'Failed to get owner ID';
//               }
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
