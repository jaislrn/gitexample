import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule,Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './common/login/login.component';
import { RegisterComponent } from './common/register/register.component';
import { HomeComponent } from './common/home/home.component';
import { ChangePasswordComponent } from './common/change-password/change-password.component';
import { EditProfileComponent } from './common/edit-profile/edit-profile.component';
import { HelpComponent } from './common/help/help.component';
import { BookListComponent } from './Admin/book-list/book-list.component';
import { UserListComponent } from './Admin/user-list/user-list.component';
import { SubjectListComponent } from './User/subject-list/subject-list.component';
import { ShowCartComponent } from './User/show-cart/show-cart.component';
import { CartHistoryComponent } from './User/cart-history/cart-history.component';
import { ShowBooksComponent } from './User/show-books/show-books.component';

const parentModuleRoutes: Routes = [
  {
    path:'',component:LoginComponent,
  },
  {
    path:'register',component:RegisterComponent,
  },
  {
    path:'home',component:HomeComponent,children:[{path:'changePassword',component:ChangePasswordComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'edit',component:EditProfileComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'help',component:HelpComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'allBooks',component:BookListComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'allUsers',component:UserListComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'subjectWiseBook',component:SubjectListComponent},{path:'showbooks',component:ShowBooksComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'cart',component:ShowCartComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'cartHistory',component:CartHistoryComponent}]
  },
  {
    path:'home',component:HomeComponent,children:[{path:'showbooks/:subject',component:ShowBooksComponent}]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ChangePasswordComponent,
    EditProfileComponent,
    HelpComponent,
    BookListComponent,
    UserListComponent,
    SubjectListComponent,
    ShowCartComponent,
    CartHistoryComponent,
    ShowBooksComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(parentModuleRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
