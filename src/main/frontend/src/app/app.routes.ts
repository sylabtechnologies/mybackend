import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';

export const routes: Routes = [
  { path: 'users', component: UserListComponent }
  // { path: 'adduser', component: UserListComponent } // Replace with actual AddUserComponent when created
];

