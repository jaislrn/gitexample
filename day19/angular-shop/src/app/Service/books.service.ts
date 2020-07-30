import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  url = "http://localhost:7071/rest";
  constructor(private helper: HttpClient) { }

  getSubjects(){
    return  this.helper.get(this.url+"/subjects");
  }

  getBooks(sub){
     return this.helper.get(this.url + "/" + sub + "/books");
  }

  getallBooks(){
    return  this.helper.get(this.url+"/books");
  }
  showCart(cart){
     return localStorage['cart'];
  }
}
