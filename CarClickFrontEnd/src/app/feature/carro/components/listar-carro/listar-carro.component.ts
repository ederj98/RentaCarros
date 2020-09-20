import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { CarroService } from '../../shared/service/carro.service';
import { Carro } from '../../shared/model/carro';

@Component({
  selector: 'app-listar-carro',
  templateUrl: './listar-carro.component.html',
  styleUrls: ['./listar-carro.component.css']
})
export class ListarCarroComponent implements OnInit {
  public listaCarros: Observable<Carro[]>;

  constructor(protected carroService: CarroService) { }

  ngOnInit() {
    this.listaCarros = this.carroService.consultar();
  }

}
