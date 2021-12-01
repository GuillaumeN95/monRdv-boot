import { Injectable } from '@angular/core';
import { Motif } from '../model';
import { HttpClient } from '@angular/common/http';
import { AppConfigService } from '../app-config.service';

@Injectable({
  providedIn: 'root'
})
export class MotifService {
  motifs: Array<Motif> = new Array<Motif>();
motifUrl:string;
  constructor(private http: HttpClient, private appConfig: AppConfigService) {
    this.motifUrl = this.appConfig.backEndUrl + "motif/"
    this.load();
   }

  findAll(): Array<Motif> {
    return this.motifs;
  }

  findById(id: number): Motif {
    for (let motif of this.motifs) {
      if (motif.id == id) {
        return motif;
      }
    }
    return null;
  }

  create(motif: Motif) {
    let max = 0;
    for (let current of this.motifs) {
      if (max < current.id) {
        max = current.id;
      }
    }
    motif.id = ++max;

    this.motifs.push(motif);
  }

  modify(motif: Motif) {
    let find: boolean = false;
    for (var indice = 0; indice < this.motifs.length; indice++) {
      if (this.motifs[indice].id == motif.id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.motifs[indice] = motif;
    }
  }

  deleteById(id: number) {
    let find: boolean = false;
    for (var indice = 0; indice < this.motifs.length; indice++) {
      if (this.motifs[indice].id == id) {
        find = true;
        break;
      }
    }
    if (find) {
      this.motifs.splice(indice, 1);
    }
  }
  load() {
    this.http.get<Array<Motif>>(this.motifUrl).subscribe(response => {
      this.motifs = response;
    }, error => console.log(error));
  }
}

