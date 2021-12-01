import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lieu } from '../model';

@Injectable({
  providedIn: 'root'
})
export class LieuService {

  lieux: Array<Lieu>=new Array<Lieu>();
  lieuUrl: string;

  constructor(private http :HttpClient, private lieuService:LieuService) { 
    this.lieuUrl=this.lieuService.lieuUrl + "lieu/"
    this.load();
  }

  findAll(): Array<Lieu>{
    return this.lieux;
  }

  findById(id:number): Observable<Lieu>{
    return this.http.get<Lieu>(this.lieuUrl + id);
  }

  create(lieu:Lieu){
    this.http.post<Lieu>(this.lieuUrl, lieu).subscribe(resp => {
      this.load();
    },err => console.log(err));
  }

  modify(lieu:Lieu){
    this.http.put<Lieu>(this.lieuUrl + lieu.id, lieu).subscribe(resp => {
      this.load();
    },err => console.log(err));
  }

  deleteById(id:number){
    this.http.delete<void>(this.lieuUrl + id).subscribe(resp => {
      this.load();
    },err => console.log(err));
  }

  load(){
    this.http.get<Array<Lieu>>(this.lieuUrl).subscribe(response => {
      this.lieux = response;
    }, error => console.log(error));
  }
}
