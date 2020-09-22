import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { TRM } from '../model/trm';


@Injectable()
export class HomeService {
  urlTRM = `/resource/32sa-8pi3.json?vigenciahasta=`;

  constructor(protected http: HttpService) {}

  public consultarPorFecha(fecha: string) {
    return this.http.doGet<TRM[]>(`${this.urlTRM}${fecha}`, this.http.optsName('consultar TRM'));
  }
}
