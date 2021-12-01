import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from '../app-config.service';
import { Patient } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  patients : Array<Patient> = new Array<Patient>();
  patientUrl:string;

  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.patientUrl = this.appConfig.backEndUrl + "patient/"
    this.load();
   }


   load() {
    this.http.get<Array<Patient>>(this.patientUrl).subscribe(response => {
      this.patients = response;
    }, error => console.log(error));
  }
}
