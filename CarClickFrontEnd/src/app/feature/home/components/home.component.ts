import { Component, OnInit } from '@angular/core';
import { formatDate} from '@angular/common';
import { HomeService } from '../shared/service/home.service';
import { TRM } from '../shared/model/trm';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {
  title = 'Bienvenido';
  subtitle = 'Sistema de Gestión de Reservas';
  fechaActual: string;
  public listaTRM: Observable<TRM[]>;

  constructor(protected homeService: HomeService) { }

  ngOnInit() {
    this.consultar();
  }

  consultar() {
    this.fechaActual = formatDate(new Date(), 'yyyy-MM-dd', 'en-US');
    this.listaTRM = this.homeService.consultarPorFecha(`${this.fechaActual}T00:00:00.000`);
  }
}
