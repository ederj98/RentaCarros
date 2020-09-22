//import { browser, logging } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { ClientePage } from '../page/cliente/cliente.po';

describe('workspace-project Cliente', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let cliente: ClientePage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        cliente = new ClientePage();
    });

    it('Cuando se ingresan los datos del cliente, entonces se deberia crear un cliente', () => {
        const ID = 1589741523;
        const NOMBRE_COMPLETO = 'Jane Doe';
        const DIRECCION = 'Calle 80';
        const TELEFONO = '3225897485';
        const EMAIL = 'jd@gmail.com';

        page.navigateTo();
        navBar.clickBotonCliente();
        cliente.ingresarId(ID);
        cliente.ingresarNombreCompleto(NOMBRE_COMPLETO);
        cliente.ingresarDireccion(DIRECCION);
        cliente.ingresarTelefono(TELEFONO);
        cliente.ingresarEmail(EMAIL);
        cliente.clickBotonCliente();
        
        expect(cliente.validarRegistroExitoso()).toBeTruthy;
    });

    it('Cuando se ingresa el id de un cliente registrado y se modifican datos, entonces se deberia actualizar un cliente', () => {
        const ID = 1589741523;
        const DIRECCION = 'Carrera 108';
        const TELEFONO = '3189634128';

        page.navigateTo();
        navBar.clickBotonCliente();
        cliente.ingresarId(ID);
        cliente.ingresarDireccion(DIRECCION);
        cliente.ingresarTelefono(TELEFONO);
        cliente.clickBotonCliente();
        
        expect(cliente.validarRegistroExitoso()).toBeTruthy;
    });
});
