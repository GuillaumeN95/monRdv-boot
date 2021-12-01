import { Component, OnInit } from '@angular/core';
import { AppConfigService } from '../app-config.service';
import { ConsultationService } from '../consultation/consultation.service';
import { CreneauService } from '../creneau/creneau.service';
import { Consultation } from '../model';
import { MotifService } from '../motif/motif.service';
import { PatientService } from '../patient/patient.service';
import { PraticienService } from '../praticien/praticien.service';
import { PriseRDVService } from './prise-rdv.service';

@Component({
  selector: 'prise-rdv',
  templateUrl: './prise-rdv.component.html',
  styleUrls: ['./prise-rdv.component.scss']
})
export class PriseRDVComponent implements OnInit {

priseRdvForm:Consultation;

  constructor(private appConfig: AppConfigService, private priseRdvService : PriseRDVService,private praticienService : PraticienService, private motifService : MotifService, private creneauService :CreneauService, private patientService : PatientService, private consultationService: ConsultationService) { }

  ngOnInit(): void {
  }

listMotif(){
  return this.motifService.findAll();
}

listCreneau(){

  return this.creneauService.findAll();
}

findPraticienById(id:number){
  
  return this.praticienService.findById(id);
}

saveConsultation(){
  if(this.priseRdvForm.id) {
    this.consultationService.modify(this.priseRdvForm);
  } else {
    this.consultationService.create(this.priseRdvForm);
}
}

cancel (){
  this.priseRdvForm=null;
}

}
