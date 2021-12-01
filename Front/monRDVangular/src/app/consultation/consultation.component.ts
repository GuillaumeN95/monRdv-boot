import { Component, OnInit } from '@angular/core';
import { ConsultationService } from './consultation.service';
import { AppConfigService } from '../app-config.service';
import { Consultation } from '../model';

@Component({
  selector: 'consultation, [consultation]',
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.scss']
})
export class ConsultationComponent implements OnInit {
priseRdvForm : Consultation;
  constructor(private consultationService: ConsultationService) { }

  ngOnInit(): void {
  }


  
}
