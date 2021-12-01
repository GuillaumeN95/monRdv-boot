import { ConsultationComponent } from "./consultation/consultation.component";
import { LieuComponent } from "./lieu/lieu.component";

export class Consultation
{
    id: number;
    version: number;
    instruction : string;
    motif : Motif;
    patient : Patient;



    constructor(id?: number, version?: number, instruction?:string,motif?:Motif,patient:Patient){
        this.id = id;
        this.version = version;
        this.instruction=instruction;
        this.motif=motif;
        this.patient=patient

    }
}
export class Creneau{

    id: number;
    version: number;
    debut: string;
    duree: number;
    dispo: boolean;
    praticien: Practicien;
    consultation: Consultation;
    lieu: Lieu;


    constructor(id?: number,version?: number, debut?: string, duree?: number, dispo?: boolean,praticien?: Practicien,consultation?: Consultation,lieu?: Lieu){
        this.id = id;
        this.version = version;
        this.debut = debut;
        this.duree = duree;
        this.dispo = dispo;
        this.praticien = praticien;
        this.consultation = consultation;
        this.lieu = lieu;
    }
}