import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  url = "http://localhost:7071/rest/customers";
  constructor(private helper: HttpClient) { }

  authmember(email, password) {
    let user = {
      "email": email,
      "password": password
    }
    return this.helper.post(this.url + "/auth", user);
  }

  getallUsers(){
    return  this.helper.get(this.url+"");
  }

  addUser(userObj){    
    let data={
      "name":userObj.name,
      "email":userObj.email,
      "address":userObj.address,
      "mobile":userObj.mobile,
      "password":userObj.password,
      "birth":userObj.birth
    }
    return  this.helper.post(this.url + "/addMember",data);
  }
}
