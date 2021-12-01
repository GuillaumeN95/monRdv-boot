import { Component, OnInit } from '@angular/core';
import { Motif } from '../model';
import { MotifService } from './motif.service';

@Component({
  selector: 'app-motif',
  templateUrl: './motif.component.html',
  styleUrls: ['./motif.component.scss']
})
export class MotifComponent implements OnInit {

  motifForm: Motif;

  constructor(private motifService: MotifService) { }

  ngOnInit(): void {
  }

  list(): Array<Motif> {
    return this.motifService.findAll();
  }

  add() {
    this.motifForm = new Motif();
  }

  edit(id: number) {
   
  }

  save() {
    if(this.motifForm.id) {
      this.motifService.modify(this.motifForm);
    } else {
      this.motifService.create(this.motifForm);
    }

    this.cancel();
  }

  cancel() {
    this.motifForm = null;
  }

  remove(id: number) {
    this.motifService.deleteById(id);
  }

}
