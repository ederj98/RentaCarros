//import { browser, logging } from 'protractor';
import { NavbarPage } from '../page/navbar/navbar.po';
import { AppPage } from '../app.po';
import { CarroPage } from '../page/carro/carro.po';

describe('workspace-project Carro', () => {
    let page: AppPage;
    let navBar: NavbarPage;
    let carro: CarroPage;

    beforeEach(() => {
        page = new AppPage();
        navBar = new NavbarPage();
        carro = new CarroPage();
    });

    it('Cuando se ingresan los datos del carro, entonces se deberia crear un carro', () => {
        const MODELO = 'Renault sandero 2018';
        const TIPO_CAMBIOS = 'Automatico';
        const NUM_PASAJEROS = 5;
        const NUM_PUERTAS = 4;
        const TIPO_COMBUSTIBLE = 'Gasolina';

        page.navigateTo();
        navBar.clickBotonCarro();
        carro.ingresarModelo(MODELO);
        carro.ingresarTipoCambios(TIPO_CAMBIOS);
        carro.ingresarNumPasajeros(NUM_PASAJEROS);
        carro.ingresarNumPuertas(NUM_PUERTAS);
        carro.ingresarTipoCombustible(TIPO_COMBUSTIBLE);
        carro.clickBotonCarro();
        
        expect(carro.validarRegistroExitoso()).toBeTruthy;
    });
});
