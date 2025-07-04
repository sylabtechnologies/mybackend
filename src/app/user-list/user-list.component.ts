import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { User } from '../model/user';
import { WebclientService } from '../webclient.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  imports: [CommonModule] //, standalone : true - do u need it
})
export class UserListComponent {
  users: User[] = [];

  constructor(private client : WebclientService) {}

  ngOnInit() {
    console.log("call ", this.client.myUri);

    this.client.getUsers().subscribe(
      data => {this.users = data;}
    );
    console.log("got ", this.users.length);
    
  }
}