import { by, element } from 'protractor';

export class ClientePage {
    private inputIdentificacion = element(by.id('idCliente'));
    private inputNombreCompleto = element(by.id('nombreCompleto'));
    private inputDireccion = element(by.id('direccion'));
    private inputTelefono = element(by.id('telefono'));
    private inputEmail = element(by.id('email'));
    private btnCliente = element(by.id('btnCliente'));
    private alert = element(by.id('infoAlert'));

    async clickBotonCliente() {
        await this.btnCliente.click();
    }

    async ingresarId(id) {
        await this.inputIdentificacion.sendKeys(id);
    }

    async ingresarNombreCompleto(nombreCompleto) {
        await this.inputNombreCompleto.clear();
        await this.inputNombreCompleto.sendKeys(nombreCompleto);
    }

    async ingresarDireccion(direccion) {
        await this.inputDireccion.clear();
        await this.inputDireccion.sendKeys(direccion);
    }

    async ingresarTelefono(telefono) {
        await this.inputTelefono.clear();
        await this.inputTelefono.sendKeys(telefono);
    }

    async ingresarEmail(email) {
        await this.inputEmail.clear();
        await this.inputEmail.sendKeys(email);
    }

    async validarRegistroExitoso() {
        return this.alert.isDisplayed();
    }
}
