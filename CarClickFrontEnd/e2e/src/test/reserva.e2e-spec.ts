//import { browser, logging } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { ReservaPage } from '../page/reserva/reserva.po';

describe('workspace-project Reserva', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let reserva: ReservaPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        reserva = new ReservaPage();
    });

    it('Deberia crear reserva', () => {
        const ID_CLIENTE = 1;
        const ID_CARRO = 'Chevrolet beat 2020';
        const FECHA_RECOGIDA = '2020-09-21 14:00:00';

        page.navigateTo();
        navBar.clickBotonReserva();
        reserva.clickBotonCrearReserva();
        reserva.ingresarIdCliente(ID_CLIENTE);
        reserva.ingresarIdCarro(ID_CARRO);
        reserva.ingresarFechaRecogida(FECHA_RECOGIDA);

        // Adicionamos las validaciones despues de la creación
        // expect(<>).toEqual(<>);
    });

    // it('Deberia listar productos', () => {
    //     page.navigateTo();
    //     navBar.clickBotonListarReserva();
    //     producto.clickBotonListarProductos();

    //     expect(4).toBe(producto.contarProductos());
    // });
});
