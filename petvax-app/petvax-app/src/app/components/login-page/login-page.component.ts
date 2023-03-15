import { Component } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent {
  
  constructor(
    private route:ActivatedRoute,
    private router:Router
  ) {}


  ngOnInit(): void {}
  navigateHomepage() {
    this.router.navigate(['/home']);
  }
}
