import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PriseRDVComponent } from './prise-rdv/prise-rdv.component';

const routes: Routes = [
  {path : "priseRdv", component: PriseRDVComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
