import { Component, OnInit } from '@angular/core';
import { BooksService } from '../../Service/books.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  bookList:any
  constructor(private servise:BooksService) { 
    let observableResult = this.servise.getallBooks();
    observableResult.subscribe((result) => {
    console.log(result);
     this.bookList=result;
    });
  }

  ngOnInit(): void {
  }

}
