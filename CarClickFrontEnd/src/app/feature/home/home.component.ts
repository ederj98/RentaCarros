import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { ClienteService } from '../cliente/shared/service/cliente.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  title = 'Car Click';
  subtitle = 'Sistema de Gestión de Reservas';
  clienteForm: FormGroup;

  constructor(protected clienteServices: ClienteService) { }

  ngOnInit() {
  }

  consultar() {
    this.clienteServices.guardar(this.clienteForm.value);
  }
}
