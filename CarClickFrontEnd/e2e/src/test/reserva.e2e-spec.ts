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

    it('Cuando se ingresan los datos de la reserva, deberia crearse una reserva', () => {
        const ID_CLIENTE = 1102860900;
        const ID_CARRO = 'Chevrolet beat 2020';
        const FECHA_RECOGIDA = '2020-09-22 14:00:00';

        page.navigateTo();
        navBar.clickBotonReserva();
        reserva.clickTabCrearReserva();
        reserva.ingresarIdCliente(ID_CLIENTE);
        reserva.ingresarIdCarro(ID_CARRO);
        reserva.ingresarFechaRecogida(FECHA_RECOGIDA);
        reserva.clickBotonReserva();
        
        expect(reserva.validarRegistroExitoso()).toBeTruthy;
    });

    it('Cuando el cliente no se encuentra registrado, entonces deberia lanzar una alerta', () => {
        const ID_CLIENTE = 1203589741;
        const ID_CARRO = 'Chevrolet beat 2020';
        const FECHA_RECOGIDA = '2020-09-22 14:00:00';

        page.navigateTo();
        navBar.clickBotonReserva();
        reserva.clickTabCrearReserva();
        reserva.ingresarIdCliente(ID_CLIENTE);
        reserva.ingresarIdCarro(ID_CARRO);
        reserva.ingresarFechaRecogida(FECHA_RECOGIDA);
        reserva.clickBotonReserva();
        
        expect(reserva.obtenerTextoAlert()).toEqual('El cliente ingresado no se encuentra registrado');
    });

    it('Cuando la fecha recogida es anterior a la fecha actual, entonces deberia lanzar una alerta', () => {
        const ID_CLIENTE = 1589741523;
        const ID_CARRO = 'Chevrolet beat 2020';
        const FECHA_RECOGIDA = '2020-09-20 14:00:00';

        page.navigateTo();
        navBar.clickBotonReserva();
        reserva.clickTabCrearReserva();
        reserva.ingresarIdCliente(ID_CLIENTE);
        reserva.ingresarIdCarro(ID_CARRO);
        reserva.ingresarFechaRecogida(FECHA_RECOGIDA);
        reserva.clickBotonReserva();
        
        expect(reserva.obtenerTextoAlert()).toEqual('La fecha de recogida del vehiculo no puede ser menor a la fecha actual');
    });

    it('Cuando se consultan las reservas, entonces se deberian listar', () => {
        page.navigateTo();
        navBar.clickBotonReserva();
        reserva.clickTabListarReserva();

        expect(reserva.contarReservas()).toBeGreaterThan(0);
    });

    it('Cuando se selecciona una reserva, entonces deberia visualizarse el detalle de la reserva', () => {
        page.navigateTo();
        reserva.clickBotonVerReservas();
        expect(reserva.contarReservas()).toBeGreaterThan(0);
        reserva.clickReservaEspecifica();
        expect(reserva.validarDetalleReserva()).toBeTruthy;
    });
});
