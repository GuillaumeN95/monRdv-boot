import { Injectable } from '@angular/core';
import { Specialite } from '../model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigService } from './../app-config.service';


@Injectable({
  providedIn: 'root'
})
export class SpecialiteService {

  specialites: Array<Specialite> = new Array<Specialite>();
  specialiteUrl : string;


  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.specialiteUrl = this.appConfig.backEndUrl + "specialite/"
    this.load();
   }

   findAll(): Array<Specialite> {
    return this.specialites;
  }

  findById(id: number): Observable<Specialite> {
    return this.http.get<Specialite>(this.specialiteUrl + id);
  }

  create(specialite: Specialite) {
    this.http.post<Specialite>(this.specialiteUrl, specialite).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(specialite: Specialite) {
    this.http.put<Specialite>(this.specialiteUrl + specialite.id, specialite).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  deleteById(id: number) {
    this.http.delete<void>(this.specialiteUrl + id).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  load() {
    this.http.get<Array<Specialite>>(this.specialiteUrl).subscribe(response => {
      this.specialites = response;
    }, error => console.log(error));
  }

}
