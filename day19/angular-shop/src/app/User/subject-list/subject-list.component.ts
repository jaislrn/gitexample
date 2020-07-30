import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BooksService } from '../../Service/books.service';

@Component({
  selector: 'app-subject-list',
  templateUrl: './subject-list.component.html',
  styleUrls: ['./subject-list.component.css']
})
export class SubjectListComponent implements OnInit {

  subjects: any;
  subject:"";
  constructor(private router: Router,private servise:BooksService) {
    let observableResult = this.servise.getSubjects();
    observableResult.subscribe((result) => {
    console.log(result);
     this.subjects=result;
    });
  }


  ngOnInit(): void {
  }

  selectSubject(event: any) {

    this.subject = event.target.value;
    console.log("Subject    " + this.subject);

  }

}
