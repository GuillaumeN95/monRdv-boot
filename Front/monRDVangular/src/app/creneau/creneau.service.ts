import { Injectable } from '@angular/core';
import { Creneau } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigService } from './../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class CreneauService {

  creneaux : Array<Creneau> = new Array<Creneau>();
  creneauUrl: string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.creneauUrl = this.appConfig.backEndUrl + "creneau/"
    this.load();
   }
   

   findAll(): Array<Creneau> {
    return this.creneaux;
  }

  findById(id: number): Observable<Creneau> {
    return this.http.get<Creneau>(this.creneauUrl + id);
  }

  create(creneau: Creneau) {
    this.http.post<Creneau>(this.creneauUrl, creneau).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(creneau: Creneau) {
    this.http.put<Creneau>(this.creneauUrl + creneau.id, creneau).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.creneauUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Creneau>>(this.creneauUrl).subscribe(response => {
      this.creneaux = response;
    }, error => console.log(error));
  }

}
