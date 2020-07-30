import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from '../../Service/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email = '';
  password = '';
  constructor(private router: Router,private service:AuthServiceService) { }

  ngOnInit(): void {
  }
  onLogin() {
  //alert(this.email.length);
    if (this.email.length == 0) {
      alert('enter email');
    } else if (this.password.length ==0) {
      alert('enter password');
    } else {

      let observableResult = this.service.authmember(this.email, this.password);
      observableResult.subscribe((result) => {
        console.log(result);
        if(result==null) {
          alert("invalid login");
          this.router.navigate(['']);
        }
      else if(result['name']=='admin')
      {
          sessionStorage['login_status'] = '1';
          localStorage.setItem('name', result['name']);
          localStorage.setItem('flag','true');
          this.router.navigate(['/home']);
      }else
      {
          sessionStorage['login_status'] = '1';
          localStorage.setItem('name', result['name']);
          localStorage.setItem('flag','true');
          var cart = [];
          if(localStorage.getItem('cart') == null) {
            localStorage.setItem('cart', JSON.stringify(cart));
            console.log('added empty cart into local storage');
          }
         // this.emtService.navBarSwitch(true);
          this.router.navigate(['/home']);
      }
    });
      
    }
  }


  onSignup() {
    this.router.navigate(['/register']);
  }
  onCancel(){
    this.router.navigate(['']);
  }

}
