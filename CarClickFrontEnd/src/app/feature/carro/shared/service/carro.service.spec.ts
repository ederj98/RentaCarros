import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { CarroService } from './carro.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/services/http.service';
import { Carro } from '../model/carro';
import { HttpResponse } from '@angular/common/http';

describe('ProductoService', () => {
  let httpMock: HttpTestingController;
  let service: CarroService;
  const apiEndpointCarroConsulta = `${environment.endpoint}/carro`;
  const apiEndpointCarro = `${environment.endpoint}/carro`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CarroService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(CarroService);
  });

  it('should be created', () => {
    const productService: CarroService = TestBed.inject(CarroService);
    expect(productService).toBeTruthy();
  });

  it('deberia listar carros', () => {
    const dummyCarros = [
      new Carro(1231234321, '2020', 'Manual', 2, 2, 'Gas'), new Carro(1231234390, '2019', 'Manual', 4, 4, 'Gas')
    ];
    service.consultar().subscribe(carros => {
      expect(carros.length).toBe(2);
      expect(carros).toEqual(dummyCarros);
    });
    const req = httpMock.expectOne(apiEndpointCarroConsulta);
    expect(req.request.method).toBe('GET');
    req.flush(dummyCarros);
  });

  it('deberia crear un carro', () => {
    const dummyCarro = new Carro(1231234321, '2020', 'Manual', 2, 2, 'Gas');
    service.guardar(dummyCarro).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointCarro);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  });
});
