import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PetsService {

  url = environment.apiUrl;

  constructor(private httpClient:HttpClient, private cookieService: CookieService) {
  }

  getPetsByOwner(ownerCookie: string, token: string): Observable<any> {

    const headers = {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Cookie': `ownerID=${ownerCookie}`
    };

    const options = {
      headers: new HttpHeaders(headers),
      withCredentials: true
    };

    return this.httpClient.get(`${this.url}/pets?active=true`, options);
  }


}
