export class TRM {
    valor: number;
    unidad: string;
    vigenciadesde: string;
    vigenciahasta: string;

    constructor(valor: number, unidad: string, vigenciadesde: string, vigenciahasta: string) {
        this.valor = valor;
        this.unidad = unidad;
        this.vigenciadesde = vigenciadesde;
        this.vigenciahasta = vigenciahasta;
    }
}