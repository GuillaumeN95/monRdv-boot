<<<<<<< Updated upstream
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
=======
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
>>>>>>> Stashed changes
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {
<<<<<<< Updated upstream
  backEndUrl: string = "http://localhost:8080/";
  constructor(private http : HttpClient) { }

  // findAllCivilites(): Observable<Array<string>> {
  //   return this.http.get<Array<string>>(this.backEndUrl + "civilites");
  // }

=======

  backEndUrl: string = "http://localhost:8080/";

  constructor(private http : HttpClient) { }

  findAllCivilites(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "civilites");
  }

  findAllDispositifs(): Observable<Array<string>> {
    return this.http.get<Array<string>>(this.backEndUrl + "dispositifs");
  }
>>>>>>> Stashed changes
}
