import { Component, OnInit } from '@angular/core';
import { CarroService } from '../../shared/service/carro.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-carro',
  templateUrl: './crear-carro.component.html'
})
export class CrearCarroComponent implements OnInit {
  carroForm: FormGroup;
  mensaje: string;
  cabecera: string;
  constructor(protected carroServices: CarroService) { }

  ngOnInit() {
    this.construirFormularioCarro();
  }

  crear() {
    this.carroServices.guardar(this.carroForm.value).subscribe(
      response => {
      console.log(response);
      this.carroForm.reset();
      this.cabecera = 'Guardado exitoso!'
      this.mensaje = 'Carro creado exitosamente.'
    });  
  }

  private construirFormularioCarro() {
    this.carroForm = new FormGroup({
      modelo: new FormControl('', [Validators.required]),
      tipoCambios: new FormControl('', [Validators.required]),
      numPasajeros: new FormControl('', [Validators.required, Validators.min(1)]),
      numPuertas: new FormControl('', [Validators.required, Validators.min(1)]),
      tipoCombustible: new FormControl('', [Validators.required])
    });
  }
}
