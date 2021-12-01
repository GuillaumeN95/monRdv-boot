import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientComponent } from './patient/patient.component';
import { PraticienComponent } from './praticien/praticien.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { MotifComponent } from './motif/motif.component';
import { CreneauComponent } from './creneau/creneau.component';
import { LieuComponent } from './lieu/lieu.component';
import { SpecialiteComponent } from './specialite/specialite.component';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    PraticienComponent,
    ConsultationComponent,
    MotifComponent,
    CreneauComponent,
    LieuComponent,
    SpecialiteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
