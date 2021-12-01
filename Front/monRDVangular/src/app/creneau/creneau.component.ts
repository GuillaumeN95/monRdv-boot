import { Component, OnInit } from '@angular/core';
import { Creneau } from '../model';
import { CreneauService } from './creneau.service';


@Component({
  selector: 'app-creneau',
  templateUrl: './creneau.component.html',
  styleUrls: ['./creneau.component.scss']
})
export class CreneauComponent implements OnInit {

  creneauForm: Creneau;

  constructor(private creneauService: CreneauService) { }

  ngOnInit(): void {
  }

  list(): Array<Creneau>{
    return this.creneauService.findAll();
  }
  
  add(){
    this.creneauForm = new Creneau();
    
  }
  
  edit(id: number){
    this.creneauService.findById(id).subscribe(response => {
      this.creneauForm = response;
    }, err => console.log(err));
  }
  
  save(){
    if(this.creneauForm.id){
      this.creneauService.modify(this.creneauForm);
    } else {
      this.creneauService.create(this.creneauForm);
    }
  
    this.cancel();
  }
  
  cancel(){
    this.creneauForm = null;
  }
  
  remove(id: number){
    this.creneauService.deleteById(id);
  }

}
