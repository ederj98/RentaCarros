import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { Cliente } from '../model/cliente';


@Injectable()
export class ClienteService {

  constructor(protected http: HttpService) {}

  public consultarPorId(cliente: Cliente) {
    return this.http.doGetWithParameter<Cliente>(`${environment.endpoint}/cliente`, cliente.idCliente, this.http.optsName('consultar reservas'));
  }

  public guardar(cliente: Cliente) {
    return this.http.doPost<Cliente, boolean>(`${environment.endpoint}/cliente`, cliente,
                                                this.http.optsName('crear/actualizar clientes'));
  }

  public actualizar(cliente: Cliente) {
    return this.http.doPut<Cliente, boolean>(`${environment.endpoint}/cliente`, cliente,
                                                this.http.optsName('crear/actualizar clientes'));
  }
}
