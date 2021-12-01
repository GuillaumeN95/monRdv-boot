import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from '../app-config.service';

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


   load() {
    this.http.get<Array<Consultation>>(this.consultationUrl).subscribe(response => {
      this.consultations = response;
    }, error => console.log(error));
  }
}
