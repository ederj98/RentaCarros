import { Injectable } from '@angular/core';
import { HttpService } from '@core-service/http.service';
import { environment } from 'src/environments/environment';
import { DetalleReserva } from '../model/detalle-reserva';
import { Reserva } from '../model/reserva';


@Injectable()
export class ReservaService {

  constructor(protected http: HttpService) {}

  public consultarDetallePorId(id: number) {
    return this.http.doGetWithParameter<DetalleReserva>(`${environment.endpoint}/detalleReserva`, id, this.http.optsName('consultar reservas'));
  }

  public consultar() {
    return this.http.doGet<Reserva[]>(`${environment.endpoint}/reserva`, this.http.optsName('consultar reservas'));
  }

  public guardar(reserva: Reserva) {
    return this.http.doPost<Reserva, Reserva>(`${environment.endpoint}/reserva`, reserva,
                                                this.http.optsName('crear/actualizar reservas'));
  }

  public guardarDetalle(detalle: DetalleReserva) {
    return this.http.doPost<DetalleReserva, DetalleReserva>(`${environment.endpoint}/detalleReserva`, detalle,
                                                this.http.optsName('crear/actualizar detalle reservas'));
  }
}
