
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