import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient,
    private router:Router,
    private cookies: CookieService
    ){ }

  public isAuthenticated():boolean{
    const token = localStorage.getItem('token');
    if(!token){
      this.router.navigate(['/']);
      return false
    }
    else {
      return true;
    }
  }

  logout() {
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    headers.set('Authorization', '');

    // Remove cookies
    this.cookies.deleteAll();
    const cookieName = "ownerID";
    const cookiePath = "/petvax-services";
    const cookieExpirationDate = "expires=Thu, 01 Jan 1970 00:00:00 UTC";
    document.cookie = `${cookieName}=; ${cookieExpirationDate}; path=${cookiePath}`;

    // Clear local storage
    localStorage.clear();
    sessionStorage.clear();

    // Set the headers for the next HTTP request
    this.router.navigate(['/login']);
  }
}
