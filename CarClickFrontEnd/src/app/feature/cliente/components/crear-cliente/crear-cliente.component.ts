import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../../shared/service/cliente.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html'
})
export class CrearClienteComponent implements OnInit {
  private searchTerms = new Subject<string>();
  clienteForm: FormGroup;
  btnNombre: string;
  cabecera: string;
  mensaje: string;

  constructor(protected clienteService: ClienteService) { }

  ngOnInit() {
    this.btnNombre = 'Guardar cliente'
    this.construirFormularioCliente();
  }

  consultar(term: string) {
    this.searchTerms.next(term);
    this.clienteService.consultarPorId(this.clienteForm.value).subscribe(
      response => {
      this.clienteForm.get('nombreCompleto').setValue(response.nombreCompleto);
      this.clienteForm.get('direccion').setValue(response.direccion);
      this.clienteForm.get('telefono').setValue(response.telefono);
      this.clienteForm.get('email').setValue(response.email);
      this.clienteForm.get('idCliente').disable();
      this.btnNombre = 'Actualizar cliente';
      },
      error => {
        console.log(`Error ${error.status}: cliente no encontrado`);
      } 
    );
  }

  gestionar() {
    if (this.btnNombre == 'Guardar cliente') {
      this.clienteService.guardar(this.clienteForm.value).subscribe(
        response => {
        console.log(response);
        this.clienteForm.reset();
        this.cabecera = 'Guardado exitoso!'
        this.mensaje = 'Cliente creado exitosamente.'
      });
    } else {
      this.clienteForm.get('idCliente').enable();
      this.clienteService.actualizar(this.clienteForm.value).subscribe(
        response => {
        console.log(response);
        this.clienteForm.reset();
        this.cabecera = 'Actualización exitosa!'
        this.mensaje = 'Cliente actualizado exitosamente.'
        this.btnNombre = 'Guardar cliente';
      }); 
    }
  }

  private construirFormularioCliente() {
    this.clienteForm = new FormGroup({
      idCliente: new FormControl('', [Validators.required]),
      nombreCompleto: new FormControl('', [Validators.required]),
      direccion: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email])
    });
  }
}
