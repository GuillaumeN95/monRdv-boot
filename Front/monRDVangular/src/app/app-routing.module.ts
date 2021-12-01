import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PraticienComponent } from './praticien/praticien.component';
import { PriseRDVComponent } from './prise-rdv/prise-rdv.component';

const routes: Routes = [
  {path : "priseRdv", component: PriseRDVComponent},
  {path : "praticien", component: PraticienComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
