import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from '../app-config.service';
import { Consultation } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ConsultationService {

  consultations : Array<Consultation> = new Array<Consultation>();
  consultationUrl:string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.consultationUrl = this.appConfig.backEndUrl + "consultation/"
    this.load();
   }

   create(consultation: Consultation) {
    this.http.post<Consultation>(this.consultationUrl, consultation).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

  modify(consultation: Consultation) {
    this.http.put<Consultation>(this.consultationUrl + consultation.id, consultation).subscribe(resp => {
      this.load();
    }, error => console.log(error));
  }

   load() {
    this.http.get<Array<Consultation>>(this.consultationUrl).subscribe(response => {
      this.consultations = response;
    }, error => console.log(error));
  }
}
