export class Motif {
    id: number;
    version: number;
    nom: string;
    nbCreneau: number;
    specialité: Specialite;
    consultation: Consultation;

    constructor(id?: number, version?: number, nom?: string, nbCreneau?: number, specialité?: Specialite, consultation?: Consultation) {
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.nbCreneau = nbCreneau;
        this.specialité = specialité;
        this.consultation = consultation;

    }
}

export class Praticien {
    id: number;
    version: number;
    civilite: string;
    nom: string;
    prenom: string;
    telephone : string;
    carteVitale: boolean;
    dureeCreneau: number;
    specialite: Specialite;
    creneau: Crenau;
    lieu: Lieu;

    constructor(id?: number, version?: number, civilite?: string, nom?: string, prenom?: string, telephone?: string, carteVitale?: boolean, dureeCreneau?: number, specialite?: Specialite, creneau?: Creneau, lieu?: Lieu) {
        this.id = id;
        this.version = version;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.carteVitale = carteVitale;
        this.dureeCreneau = dureeCreneau;
        this.specialite = specialite;
        this.creneau = creneau;
        this.lieu = lieu;

    }

}
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
    praticien: Praticien;
    consultation: Consultation;
    lieu: Lieu;


    constructor(id?: number,version?: number, debut?: string, duree?: number, dispo?: boolean,praticien?: Praticien,consultation?: Consultation,lieu?: Lieu){
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

export class Patient
{
    id: number;
    version: number;
    //civilite: string;
    nom: string;
    prenom: string;
    dtNaissance: string;
    email: string;
    telephone: string;
    principal:boolean;
    adresse: Adresse;



    constructor(id?: number,version?: number,nom?: string,prenom?: string,dtNaissance?: string,email?: string,telephone?: string,principal?:boolean,adresse?: Adresse){
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.prenom = prenom;
        this.dtNaissance=dtNaissance;
        this.email = email;
        this.telephone = telephone;
        this.principal=principal;
        this.adresse = adresse;

    }
}

export class Adresse {
    voie: string;
    complement: string;
    codePostal: string;
    ville: string;

    constructor(voie?: string, complement?: string, codePostal?: string, ville?: string) {
        this.voie = voie;
        this.complement = complement;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}

export class Lieu{
    id: number;
    version: number;
    nom: string;
    informations: string;
    adresse: Adresse;
    praticien: Praticien;

    
    constructor(id?: number,version?: number,nom?: string,prenom?: string,dtNaissance?: string,email?: string,telephone?: string,principal?:boolean,adresse?: Adresse){
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.informations = this.informations;
        this.adresse=adresse;
        this.praticien = this.praticien;
}





export class Specialite{

    id: number;
    version: number;
    nom: string;
    praticien: Praticien;

    constructor( id?: number, version?: number,nom?: string, praticien?: Praticien){
        this.id = id;
        this.version = version;
        this.nom = nom;
        this.praticien = praticien;
    }
}