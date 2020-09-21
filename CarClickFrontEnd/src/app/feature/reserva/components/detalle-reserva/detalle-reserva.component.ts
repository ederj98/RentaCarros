import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { ReservaService } from '../../shared/service/reserva.service';
import { DetalleReserva } from '../../shared/model/detalle-reserva';

@Component({
  selector: 'app-detalle-reserva',
  templateUrl: './detalle-reserva.component.html',
  styleUrls: ['./detalle-reserva.component.css']
})
export class DetalleReservaComponent implements OnInit {
  id: number;
  reserva: DetalleReserva;

  constructor(
    private route: ActivatedRoute,
    protected reservaService: ReservaService,
    private location: Location
    ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.reservaService.consultarDetallePorId(this.id).subscribe(
      response => {
        this.reserva = response;
      },
      error => {
        console.log(`Error ${error.status}: detalle reserva no encontrada`);
      } 
    );
  }

  crear() {
    this.reservaService.guardarDetalle(new DetalleReserva(null, this.id, null, null)).subscribe(
      response => {
      this.reserva = response;
    });
  }

  irAtras(): void {
    this.location.back();
  }
}
