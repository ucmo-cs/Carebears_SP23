import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CookieService } from 'ngx-cookie-service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class WalletsService {

  url = environment.apiUrl;

  constructor(private httpClient:HttpClient, private cookieService: CookieService) {
  }

  getWalletsByPet(petCookie: string, token: string): Observable<any> {
    const headers = {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    };

    const options = {
      headers: new HttpHeaders(headers),
      withCredentials: true
    };

    return this.httpClient.get(`${this.url}/wallets?active=true`, options);
  }

  getWalletByUUID(walletCookie: string, token: string): Observable<any> {
    const headers = {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Cookie': `walletId=${walletCookie}; SameSite=None; Secure` 
    }

    const options = {
      headers: new HttpHeaders(headers),
      withCredentials: true
    };

    return this.httpClient.get(`${this.url}/wallets/{walletId}?active=true&walletId=${walletCookie}`, options);
  }

  createWallet(data: any, token: string): Observable<any> {
    const headers = {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
    }

    const options = {
      headers: new HttpHeaders(headers),
      withCredentials: true
    };

    return this.httpClient.post<any>(`${this.url}/wallet`, data, options);
  }

  deleteWallet(walletCookie: string, token: string): Observable<any> {
    const headers = {
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      //'Cookie': `walletId=${walletCookie}; SameSite=None; Secure` 
    }

    const options = {
      headers: new HttpHeaders(headers),
      withCredentials: true
    };

    return this.httpClient.delete(`${this.url}/wallet/${walletCookie}`, options);
  }
}