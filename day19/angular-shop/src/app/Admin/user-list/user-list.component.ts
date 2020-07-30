import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../Service/auth-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  userList:any;
  constructor(private service:AuthServiceService) {
    let observableResult = this.service.getallUsers();
    observableResult.subscribe((result) => {
    console.log(result);
     this.userList=result;
    });
   }

  ngOnInit(): void {
  }

}
