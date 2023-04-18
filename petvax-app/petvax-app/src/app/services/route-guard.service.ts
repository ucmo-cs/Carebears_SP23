import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { jwt_decode } from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService {

  constructor(public auth:AuthService,
    public router:Router) { }

    canActivate(route:ActivatedRouterSnapshot):boolean(
      let expectedRoleArray = router.data;
      expectedRoleArray = expectedRoleArray.expectedRole;

      const token:any = localStorage.getItem('token');

      var tokenPayload:any;
      try{
        tokenPayload = jwt_decode(token);
      }
      catch(err){
        localStorage.clear();
        this.router.navigate(['/']);
      }

      let expectedRole = '';

      for(let i = 0; i<expectedRoleArray.length; i++) {
        if(expectedRoleArray[i] == tokenPayload.role){
          expectedRole = tokenPayload.role;
        }
      }

      if(tokenPayload.role == 'USER' || tokenPayload.role == 'ADMIN'){
        if(this.auth.isAuthenticated() && tokenPayload.role == expectedRole){
          return true;
        }
        return false;
      }
      else{
        this.router.navigate(['/']);
        localStorage.clear();
        return false;
      }
    )
}
