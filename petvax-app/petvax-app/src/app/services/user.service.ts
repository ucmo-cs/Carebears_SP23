import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = environment.apiUrl;

  constructor(private httpClient:HttpClient) { }

  login(data:any):Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.httpClient.post(`${this.url}/login`, data, { headers });
  }

  checkToken():Observable<any> {
    return this.httpClient.get(`${this.url}/checkToken`);
  }

  getOwnerId(username: string, token: string):Observable<any> {
      const headers = { 'Authorization': `Bearer ${token}` };
      return this.httpClient.get(`${this.url}/userDetails?username=${username}`, { headers });
    }
}
