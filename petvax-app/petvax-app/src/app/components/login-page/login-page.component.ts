import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';

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
    private userService:UserService
  ){}

  ngOnInit() {
    this.userService.checkToken().subscribe(
      (response:any) => {
        this.router.navigate(['/home']);
      },
      (error:any) => {
        console.log(error);
      }
    );
  }

  handleSubmit(){
    const data = {
      username: this.username,
      password: this.password
    };
    this.userService.login(data).subscribe(
      (response:any) => {
        localStorage.setItem('token', response.token);
        const token = localStorage.getItem('token');
        if (token !== null) {
          this.userService.getOwnerDetails(this.username, token).subscribe(
            (ownerDetails:any) => {
              document.cookie = `ownerId=${ownerDetails.id};`;
              this.router.navigate(['/home']);
            },
            (error:any) => {
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
      (error:any) => {
        if (error.error?.message) {
          this.responseMessage = error.error?.message;
        } else {
          this.responseMessage = 'Something went wrong';
        }
      }
    );
  }

}
