import { Injectable } from '@angular/core';
import { Praticien } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PraticienService {
  praticiens: Array<Praticien> = new Array<Praticien>();

  constructor() { }

  findAll(): Array<Praticien> {
    return this.praticiens;
  }

  findById(id: number): Praticien {
    for (let praticien of this.praticiens) {
      if (praticien.id == id) {
        return praticien;
      }
    }
    return null;
  }

  create(praticien: Praticien) {
    let max = 0;
    for (let current of this.praticiens) {
      if (max < current.id) {
        max = current.id;
      }
    }
    praticien.id = ++max;

    this.praticiens.push(praticien);
  }

  modify(praticien: Praticien) {
    let find: boolean = false;
    for (var indice = 0; indice < this.praticiens.length; indice++) {
      if (this.praticiens[indice].id == praticien.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.praticiens[indice] = praticien;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.praticiens.length; indice++) {
      if (this.praticiens[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.praticiens.splice(indice, 1);
    }
  }
}
