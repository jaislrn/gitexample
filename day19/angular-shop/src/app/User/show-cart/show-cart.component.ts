import { Component, OnInit } from '@angular/core';
import { BooksService } from '../../Service/books.service';

@Component({
  selector: 'app-show-cart',
  templateUrl: './show-cart.component.html',
  styleUrls: ['./show-cart.component.css']
})
export class ShowCartComponent implements OnInit {

  books:any;
  constructor(private servise:BooksService) {
    const cartString = localStorage.getItem("cart");
    this.books=JSON.parse(cartString);
   }

  ngOnInit(): void {
  }

}
