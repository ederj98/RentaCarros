export class Cliente {
    idCliente: number;
    nombreCompleto: string;
    telefono: string;
    direccion: string;
    email: string;

    constructor(idCliente: number, nombreCompleto: string, telefono: string, direccion: string, email:string) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }
}