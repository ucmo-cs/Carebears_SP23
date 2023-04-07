import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent {
  
  data: any;
  constructor(
    private router:Router,
    private http: HttpClient
  ) {}


  ngOnInit(): void {}
  navigateHomepage() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    })
    this.http.get('http://localhost:8080/petvax-services/owner/Sawyer', {
      headers: headers, 
      withCredentials: true
    }).subscribe((data) => {
      this.data = data;
      console.log('data', this.data);
    })
    this.data = {
      "fname": "Mark",
      "lname": "Twain",
      "address1": "234 W 10th St",
      "address2": null,
      "city": "Kansas City",
      "state": "MO",
      "zipCode": "64105 ",
      "email": "Sam.L.Clemens@gmail.com",
      "createdDate": "2023-04-07T07:13:51Z",
      "uuid": "f1e18004-dc0b-443f-89e7-dc0c16734518"
    }
    sessionStorage.setItem('OwnerId', this.data.uuid);
    this.router.navigate(['/home']);
  }
}
