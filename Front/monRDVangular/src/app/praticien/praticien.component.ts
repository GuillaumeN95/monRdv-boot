import { Component, OnInit } from '@angular/core';
import { Praticien } from '../model';
import { PraticienService } from './praticien.service';
import { AppConfigService } from '../app-config.service';
import { PriseRDVService } from '../prise-rdv/prise-rdv.service';
import { ConsultationService } from '../consultation/consultation.service';

@Component({
  selector: 'app-praticien',
  templateUrl: './praticien.component.html',
  styleUrls: ['./praticien.component.scss']
})
export class PraticienComponent implements OnInit {

  praticienForm: Praticien;

  constructor(private appConfig: AppConfigService, private priseRdvService : PriseRDVService,private praticienService : PraticienService,private consultationService: ConsultationService) { }

  ngOnInit(): void {
  }

  list(): Array<Praticien> {
    return this.praticienService.findAll();
  }

  add() {
    this.praticienForm = new Praticien();
  }

  edit(id: number) {
   
  }

  save() {
    if(this.praticienForm.id) {
      this.praticienService.modify(this.praticienForm);
    } else {
      this.praticienService.create(this.praticienForm);
    }

    this.cancel();
  }

  cancel() {
    this.praticienForm = null;
  }

  remove(id: number) {
    this.praticienService.deleteById(id);
  }

}
