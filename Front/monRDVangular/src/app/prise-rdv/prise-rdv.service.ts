import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConfigService } from './../app-config.service';
import { Consultation } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PriseRDVService {

priseRdvUrl:string;
consultation : Consultation;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.priseRdvUrl = this.appConfig.backEndUrl + "consultation/"
    this.load();
   }

   

   load() {
    this.http.get<Consultation>(this.priseRdvUrl).subscribe(response => {
      this.consultation = response;
    }, error => console.log(error));
  }
}
