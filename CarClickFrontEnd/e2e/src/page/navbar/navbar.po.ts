import { by, element } from 'protractor';

export class NavbarPage {
    linkHome = element(by.xpath('/html/body/app-root/div/app-navbar/ul/a[1]/li/a'));
    linkReserva = element(by.xpath('/html/body/app-root/div/app-navbar/ul/a[2]/li/a'));
    linkCliente = element(by.xpath('/html/body/app-root/div/app-navbar/ul/a[3]/li/a'));
    linkCarro = element(by.xpath('/html/body/app-root/div/app-navbar/ul/a[4]/li/a'));

    async clickBotonReserva() {
        await this.linkReserva.click();
    }

    async clickBotonCliente() {
        await this.linkCliente.click();
    }

    async clickBotonCarro() {
        await this.linkCarro.click();
    }
}
