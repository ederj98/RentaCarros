import { Component, OnInit } from '@angular/core';
import { CarroService } from '../../shared/service/carro.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-crear-carro',
  templateUrl: './crear-carro.component.html',
  styleUrls: ['./crear-carro.component.css']
})
export class CrearCarroComponent implements OnInit {
  carroForm: FormGroup;
  constructor(protected carroServices: CarroService) { }

  ngOnInit() {
    this.construirFormularioCarro();
  }

  crear() {
    this.carroServices.guardar(this.carroForm.value);
  }

  private construirFormularioCarro() {
    this.carroForm = new FormGroup({
      modelo: new FormControl('', [Validators.required]),
      tipoCambios: new FormControl('', [Validators.required]),
      numPasajeros: new FormControl('', [Validators.required]),
      numPuertas: new FormControl('', [Validators.required]),
      tipoCombustible: new FormControl('', [Validators.email])
    });
  }
}
