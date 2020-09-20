import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { CrearCarroComponent } from './crear-carro.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { CarroService } from '../../shared/service/carro.service';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

describe('CrearProductoComponent', () => {
  let component: CrearCarroComponent;
  let fixture: ComponentFixture<CrearCarroComponent>;
  let productoService: CarroService;

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
    productoService = TestBed.inject(CarroService);
    spyOn(productoService, 'guardar').and.returnValue(
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
    component.carroForm.controls.id.setValue(1);
    component.carroForm.controls.modelo.setValue('2020');
    component.carroForm.controls.tipoCambios.setValue('Manual');
    component.carroForm.controls.numPasajeros.setValue(2);
    component.carroForm.controls.numPuertas.setValue(2);
    component.carroForm.controls.tipoCombustible.setValue('Gas');
    expect(component.carroForm.valid).toBeTruthy();
    expect(component.guardar()).toBeTruthy();
  });
});
