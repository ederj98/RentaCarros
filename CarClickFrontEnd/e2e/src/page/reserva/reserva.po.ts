import { by, element } from 'protractor';

export class ReservaPage {
    private linkCrearReserva = element(by.id('linkCrearReserva'));
    private linkListarProductos = element(by.id('linkListarReserva'));
    private inputIdCliente = element(by.id('idCliente'));
    private inputCarro = element(by.id('idCarro'));
    private inputFechaRecogida = element(by.id('fechaRecogida'));
    private listaReservas = element.all(by.css('ul.reservas li'));

    async clickBotonCrearReserva() {
        await this.linkCrearReserva.click();
    }

    async clickBotonListarReserva() {
        await this.linkListarProductos.click();
    }

    async ingresarIdCliente(idCliente) {
        await this.inputIdCliente.sendKeys(idCliente);
    }

    async ingresarIdCarro(idCarro) {
        await this.inputCarro.sendKeys(idCarro);
    }

    async ingresarFechaRecogida(fechaRecogida) {
        await this.inputFechaRecogida.sendKeys(fechaRecogida);
    }

    async contarReservas() {
        return this.listaReservas.count();
    }
}
