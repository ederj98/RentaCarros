import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Cliente } from '../model/cliente';


@Injectable()
export class ClienteService {

  constructor(protected http: HttpService) {}

  /*public consultarPorId(id: number) {
    return this.http.doGetParameters<Cliente>(`${environment.endpoint}/cliente`, , this.http.optsName('consultar productos')):
  }*/

  public guardar(cliente: Cliente) {
    return this.http.doPost<Cliente, boolean>(`${environment.endpoint}/cliente`, cliente,
                                                this.http.optsName('crear/actualizar clientes'));
  }
}
