export class Carro {
    id: number;
    modelo: string;
    tipoCambios: string;
    numPasajeros: number;
    numPuertas: number;
    tipoCombustible: string;

    constructor(id: number, modelo: string, tipoCambios: string, numPasajeros: number, numPuertas: number, tipoCombustible: string) {
        this.id = id;
        this.modelo = modelo;
        this.tipoCambios = tipoCambios;
        this.numPasajeros = numPasajeros;
        this.numPuertas = numPuertas;
        this.tipoCombustible = tipoCombustible;
    }
}