
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
