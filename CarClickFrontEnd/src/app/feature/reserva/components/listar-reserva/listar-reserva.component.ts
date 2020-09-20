import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { ReservaService } from '../../shared/service/reserva.service';
import { Reserva } from '../../shared/model/reserva';

@Component({
  selector: 'app-listar-reserva',
  templateUrl: './listar-reserva.component.html',
  styleUrls: ['./listar-reserva.component.css']
})
export class ListarReservaComponent implements OnInit {
  public listaReserva: Observable<Reserva[]>;

  constructor(protected reservaService: ReservaService) { }

  ngOnInit() {
    this.listaReserva = this.reservaService.consultar();
  }

}
