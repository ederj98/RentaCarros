import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { HomeService } from './home.service';
import { HttpService } from 'src/app/core/services/http.service';
import { TRM } from '../model/trm';

describe('HomeService', () => {
  let httpMock: HttpTestingController;
  let service: HomeService;
  const apiEndpointTRM = `/resource/32sa-8pi3.json?vigenciahasta=2020-09-21T00:00:00.000`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HomeService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(HomeService);
  });

  it('should be created', () => {
    const trmService: HomeService = TestBed.inject(HomeService);
    expect(trmService).toBeTruthy();
  });

  it('deberia listar TRM', () => {
    const dummyTRM = [
      new TRM(3725.37, 'COP', '2020-09-19T00:00:00.000', '2020-09-21T00:00:00.000')
    ];
    service.consultarPorFecha('2020-09-21T00:00:00.000').subscribe(trm => {
      expect(trm.length).toBe(1);
      expect(trm).toEqual(dummyTRM);
    });

    const req = httpMock.expectOne(apiEndpointTRM);
    expect(req.request.method).toBe('GET');
    req.flush(dummyTRM);
  });
});
