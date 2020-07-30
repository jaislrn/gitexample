import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder, FormArray, FormControl } from '@angular/forms';
import { BooksService } from '../../Service/books.service';

@Component({
  selector: 'app-show-books',
  templateUrl: './show-books.component.html',
  styleUrls: ['./show-books.component.css']
})
export class ShowBooksComponent implements OnInit {

  subject:'';
  form: FormGroup;
  bookList:any;
  selectedList:any;
  constructor(private route: ActivatedRoute,private formBuilder: FormBuilder,private router: Router,private servise:BooksService) {
    this.selectedList = [];
    this.subject=this.route.snapshot.params['subject'];
    let observableResult = this.servise.getBooks(this.subject);
    observableResult.subscribe((result) => {
     this.bookList=result;
    });
   }

  ngOnInit(): void {
  }

  selectBook(e: any, book: any) {
    if (e.target.checked) {
      this.selectedList.push(book);
    }  else {
      var index = this.selectedList.findIndex(b => b.id == book.id);
      if(index != -1)
        this.selectedList.splice(index, 1);
    }
  }

  onCart() {
    const cartString = localStorage.getItem('cart');
    const cart = JSON.parse(cartString);
    this.selectedList.forEach(ele => cart.push(ele));
    cart.concat(this.selectedList);
    localStorage.setItem('cart', JSON.stringify(cart));
    this.router.navigate(['/home/subjectWiseBook']);
  }

  

}
