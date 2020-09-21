import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CrearCarroComponent } from './crear-carro.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { CarroService } from '../../shared/service/carro.service';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

describe('CrearCarroComponent', () => {
  let component: CrearCarroComponent;
  let fixture: ComponentFixture<CrearCarroComponent>;
  let carroService: CarroService;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearCarroComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [CarroService, HttpService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearCarroComponent);
    component = fixture.componentInstance;
    carroService = TestBed.inject(CarroService);
    spyOn(carroService, 'guardar').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.carroForm.valid).toBeFalsy();
  });

  it('Registrando carro', () => {
    expect(component.carroForm.valid).toBeFalsy();
    component.carroForm.controls.modelo.setValue('Chevrolet beat 2020');
    component.carroForm.controls.tipoCambios.setValue('Manual');
    component.carroForm.controls.numPasajeros.setValue(2);
    component.carroForm.controls.numPuertas.setValue(2);
    component.carroForm.controls.tipoCombustible.setValue('Gas');
    expect(component.carroForm.valid).toBeTruthy();
  });
});
