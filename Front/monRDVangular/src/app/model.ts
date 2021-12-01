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