import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../shared/service/cliente.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {
  clienteForm: FormGroup;
  btnNombre: string;

  constructor(protected clienteServices: ClienteService) { }

  ngOnInit() {
    this.btnNombre = 'Guardar cliente'
    this.construirFormularioCliente();
  }

  crear() {
    this.clienteServices.guardar(this.clienteForm.value);
  }

  private construirFormularioCliente() {
    this.clienteForm = new FormGroup({
      idCliente: new FormControl('', [Validators.required]),
      nombreCompleto: new FormControl('', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.email])
    });
  }
}
