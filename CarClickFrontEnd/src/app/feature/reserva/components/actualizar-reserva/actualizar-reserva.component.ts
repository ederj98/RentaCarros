import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { formatDate} from '@angular/common';
import { Observable } from 'rxjs';

import { ReservaService } from '../../shared/service/reserva.service';
import { CarroService } from '../../../carro/shared/service/carro.service';
import { Carro } from '../../../carro/shared/model/carro';


@Component({
  selector: 'app-actualizar-reserva',
  templateUrl: './actualizar-reserva.component.html'
})
export class ActualizarReservaComponent implements OnInit {
  id: number;
  reservaForm: FormGroup;
  public listaCarros: Observable<Carro[]>;

  constructor(
    protected reservaServices: ReservaService,
    protected carroServices: CarroService,
    private route: ActivatedRoute,
    private location: Location
    ) { }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.construirFormularioReserva();
    this.consultar();
  }

  consultar() {
    
    this.reservaServices.consultarPorId(this.id).subscribe(
      response => {
      this.reservaForm.get('id').setValue(this.id);
      this.reservaForm.get('idCliente').setValue(response.idCliente);
      this.reservaForm.get('idCarro').setValue(response.idCarro);
      this.reservaForm.get('fechaRecogida').setValue(formatDate(new Date(response.fechaRecogida), "yyyy-MM-dd'T'HH:mm", 'en-US'));
      },
      error => {
        console.log(`Error ${error.status}: cliente no encontrado`);
      } 
    );
    
  }

  actualizar() {
    this.reservaServices.actualizar(this.reservaForm.value).subscribe(
      response => {
      console.log(response);
      this.reservaForm.reset();
      this.irAtras();
    });
  }

  irAtras(): void {
    this.location.back();
  }

  private construirFormularioReserva() {
    this.reservaForm = new FormGroup({
      id: new FormControl(''),
      idCliente: new FormControl(''),
      idCarro: new FormControl('', [Validators.required]),
      fechaRecogida: new FormControl('', [Validators.required])
    });
    this.listaCarros = this.carroServices.consultar();
  }
}
