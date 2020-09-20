import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { ReservaService } from '../../shared/service/reserva.service';

@Component({
  selector: 'app-detalle-reserva',
  templateUrl: './detalle-reserva.component.html',
  styleUrls: ['./detalle-reserva.component.css']
})
export class DetalleReservaComponent implements OnInit {
  id: number;
  constructor(
    private route: ActivatedRoute,
    protected reservaService: ReservaService,
    private location: Location
    ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    
    //this.listaReserva = this.reservaService.consultar();
  }

  irAtras(): void {
    this.location.back();
  }
}
