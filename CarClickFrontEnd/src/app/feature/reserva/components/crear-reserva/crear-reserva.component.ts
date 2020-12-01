import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';
import { formatDate} from '@angular/common';

import { ReservaService } from '../../shared/service/reserva.service';
import { CarroService } from '../../../carro/shared/service/carro.service';
import { Carro } from '../../../carro/shared/model/carro';


@Component({
  selector: 'app-crear-reserva',
  templateUrl: './crear-reserva.component.html'
})
export class CrearReservaComponent implements OnInit {
  reservaForm: FormGroup;
  cabecera: string;
  mensaje: string;
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
    this.reservaForm.value.fechaRecogida = formatDate(new Date(this.reservaForm.value.fechaRecogida), 'yyyy-MM-dd HH:mm:ss', 'en-US');
    this.reservaServices.guardar(this.reservaForm.value).subscribe(
      response => {
      console.log(response);
      this.reservaForm.reset();
      this.cabecera = 'Guardado exitoso!'
      this.mensaje = 'Reserva creada exitosamente.'
    });
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
