import { Component, OnInit } from '@angular/core';
import { ConsultationService } from './consultation.service';

@Component({
  selector: 'consultation, [consultation]',
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.scss']
})
export class ConsultationComponent implements OnInit {

  constructor(private consultationService: ConsultationService) { }

  ngOnInit(): void {
  }

}
