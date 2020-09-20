export class DetalleReserva {
    id: number;
    idReserva: number;
    fechaEntrega: string;
    costo: number;

    constructor(id: number, idReserva: number, fechaEntrega: string, costo: number) {
        this.id = id;
        this.idReserva = idReserva;
        this.fechaEntrega = fechaEntrega;
        this.costo = costo;
    }
}