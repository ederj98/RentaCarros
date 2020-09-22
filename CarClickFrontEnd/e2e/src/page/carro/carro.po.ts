import { by, element } from 'protractor';

export class CarroPage {
    private inputModelo = element(by.id('modelo'));
    private inputTipoCambios = element(by.id('tipoCambios'));
    private inputNumPasajeros = element(by.id('numPasajeros'));
    private inputNumPuertas = element(by.id('numPuertas'));
    private inputTipoCombustible = element(by.id('tipoCombustible'));
    private btnCarro = element(by.id('btnCarro'));
    private alert = element(by.id('infoAlert'));

    async clickBotonCarro() {
        await this.btnCarro.click();
    }

    async ingresarModelo(modelo) {
        await this.inputModelo.sendKeys(modelo);
    }

    async ingresarTipoCambios(tipoCambios) {
        await this.inputTipoCambios.sendKeys(tipoCambios);
    }

    async ingresarNumPasajeros(numPasajeros) {
        await this.inputNumPasajeros.sendKeys(numPasajeros);
    }

    async ingresarNumPuertas(numPuertas) {
        await this.inputNumPuertas.sendKeys(numPuertas);
    }

    async ingresarTipoCombustible(tipoCombustible) {
        await this.inputTipoCombustible.sendKeys(tipoCombustible);
    }

    async validarRegistroExitoso() {
        return this.alert.isDisplayed();
    }
}
