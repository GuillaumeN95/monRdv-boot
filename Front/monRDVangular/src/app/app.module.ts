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
import { PriseRDVComponent } from './prise-rdv/prise-rdv.component';
import { AppConfigService } from './app-config.service';
import { PatientService } from './patient/patient.service';
import { PraticienService } from './praticien/praticien.service';
import { ConsultationService } from './consultation/consultation.service';
import { MotifService } from './motif/motif.service';
import { CreneauService } from './creneau/creneau.service';
import { LieuService } from './lieu/lieu.service';
import { SpecialiteService } from './specialite/specialite.service';
import { PriseRDVService } from './prise-rdv/prise-rdv.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    PraticienComponent,
    ConsultationComponent,
    MotifComponent,
    CreneauComponent,
    LieuComponent,
    SpecialiteComponent,
    PriseRDVComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [AppConfigService, PatientService,PraticienService,ConsultationService,MotifService,CreneauService,LieuService,SpecialiteService,PriseRDVService],
  bootstrap: [AppComponent]
})
export class AppModule { }
