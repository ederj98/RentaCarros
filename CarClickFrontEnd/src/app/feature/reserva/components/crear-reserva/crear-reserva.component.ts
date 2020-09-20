import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';

import { ReservaService } from '../../shared/service/reserva.service';
import { CarroService } from '../../../carro/shared/service/carro.service';
import { Carro } from '../../../carro/shared/model/carro';


@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html',
  styleUrls: ['./crear-reserva.component.css']
})
export class CrearReservaComponent implements OnInit {
  reservaForm: FormGroup;
  public listaCarros: Observable<Carro[]>;

  constructor(
    protected reservaServices: ReservaService,
    protected carroServices: CarroService,
    private location: Location
    ) { }

  ngOnInit() {
    this.construirFormularioReserva();
  }

  crear() {
    this.reservaServices.guardar(this.reservaForm.value);
    this.irAtras();
  }

  irAtras(): void {
    this.location.back();
  }

  private construirFormularioReserva() {
    this.reservaForm = new FormGroup({
      idCliente: new FormControl('', [Validators.required]),
      idCarro: new FormControl('', [Validators.required]),
      fechaRecogida: new FormControl('', [Validators.required])
    });
    this.listaCarros = this.carroServices.consultar();
  }
}
