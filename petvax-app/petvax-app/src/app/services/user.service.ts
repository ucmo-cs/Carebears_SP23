import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url = environment.apiUrl;

  constructor(private httpClient:HttpClientModule) { }

  login(data:any){
    "/login", data,{
      headers: new HttpHeaders().set('Content-Type', 'application/json')
    }
  }

  checkToken(){
    return this.httpClient.get(this.url+"/petvax-services/checkToken")
  }
}
