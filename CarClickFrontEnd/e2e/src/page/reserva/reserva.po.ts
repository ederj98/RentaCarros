import { browser, by, element } from 'protractor';

export class ReservaPage {
    private linkCrearReserva = element(by.id('linkCrearReserva'));
    private linkListarReservas = element(by.id('linkReserva'));
    private inputIdCliente = element(by.id('idCliente'));
    private inputCarro = element(by.id('idCarro'));
    private inputFechaRecogida = element(by.id('fechaRecogida'));
    private btnReserva = element(by.id('btnReserva'));
    private btnModificarReserva = element(by.id('btnModificarReserva'));
    private btnConfirmarEntrega = element(by.id('btnConfirmarEntrega'));
    private btnVerReservas = element(by.id('btnVerReservas'));
    private alert = element(by.id('infoAlert'));
    private vistaDetalleReserva = element(by.id('vistaDetalleReserva'));
    private listaReservas = element.all(by.xpath('/html/body/app-root/div/app-reserva/app-listar-reserva/div/a'));
    private linkReservaEspecifica = element(by.xpath('/html/body/app-root/div/app-reserva/app-listar-reserva/div/a[1]'));

    async clickTabCrearReserva() {
        await this.linkCrearReserva.click();
    }

    async clickBotonReserva() {
        await this.btnReserva.click();
    }

    async clickBotonConfirmarEntrega() {
        await this.btnConfirmarEntrega.click();
    }

    async clickBotonModificarReserva() {
        await this.btnModificarReserva.click();
    }

    async clickBotonVerReservas() {
        await this.btnVerReservas.click();
    }

    async clickReservaEspecifica() {
        var timeoutInMilliseconds = 100000;
        browser.wait(this.linkReservaEspecifica.isDisplayed(), timeoutInMilliseconds);
        await this.linkReservaEspecifica.click();
    }

    async clickTabListarReserva() {
        await this.linkListarReservas.click();
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

    async validarRegistroExitoso() {
        return this.alert.isDisplayed();
    }

    async validarDetalleReserva() {
        return this.vistaDetalleReserva.isDisplayed();
    }

    async obtenerTextoAlert() {
        var timeoutInMilliseconds = 1000;
        browser.wait(browser.ExpectedConditions.alertIsPresent(), timeoutInMilliseconds);
        var alertDialog = browser.switchTo().alert();     
        var texto = (await alertDialog).getText();
        (await alertDialog).accept();
        return texto;
    }

    async contarReservas() {
        return this.listaReservas.count();
    }
}
