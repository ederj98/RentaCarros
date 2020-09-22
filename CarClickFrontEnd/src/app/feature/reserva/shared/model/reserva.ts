export class Reserva {
    id: number;
    idCliente: number;
    idCarro: number;
    fechaRecogida: string;

    constructor(id: number, idCliente: number, idCarro: number, fechaRecogida: string) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.fechaRecogida = fechaRecogida;
    }
}