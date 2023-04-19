import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  url = environment.apiUrl;

  constructor(private httpClient:HttpClient) {
  }

  getOwnerDetails(ownerCookie: string, token: string): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');

    return this.httpClient.get(`${this.url}/owner/${ownerCookie}`, { headers: headers });
  }
}
