import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Carro } from '../model/carro';


@Injectable()
export class CarroService {

  constructor(protected http: HttpService) {}

  public consultar() {
    return this.http.doGet<Carro[]>(`${environment.endpoint}/carro`, this.http.optsName('consultar carros'));
  }

  public guardar(carro: Carro) {
    return this.http.doPost<Carro, boolean>(`${environment.endpoint}/carro`, carro,
                                                this.http.optsName('crear/actualizar carros'));
  }
}
