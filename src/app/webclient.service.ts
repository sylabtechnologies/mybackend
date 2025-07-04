import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { User } from './model/user';

import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class WebclientService {
  public readonly myUri = `${environment.apiBaseUrl}/users`;

  constructor(private client: HttpClient) { }

  getUsers(): Observable<User[]> {
    const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type': 'application/json'
        })
      };

    return this.client.get<User[]>(this.myUri, httpOptions).pipe(
        catchError(error => {
          // You can log the error, transform it, or display a user-friendly message
          console.error('Error fetching users:', error);

          // Optionally, customize the error message or handling logic
          return throwError(() => new Error('Failed to load user data. Please try again later.'));
        })
    );
  }
}
// This service handles the communication with the backend for authentication purposes.