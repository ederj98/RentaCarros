import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { ActualizarReservaComponent } from './actualizar-reserva.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { ReservaService } from '../../shared/service/reserva.service';
import { HttpService } from 'src/app/core/services/http.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Reserva } from '../../shared/model/reserva';
import { CarroService } from 'src/app/feature/carro/shared/service/carro.service';
import { Carro } from 'src/app/feature/carro/shared/model/carro';

describe('ActualizarReservaComponent', () => {
  let component: ActualizarReservaComponent;
  let fixture: ComponentFixture<ActualizarReservaComponent>;
  let reservaService: ReservaService;
  let carroService: CarroService;
  const dummyReserva = new Reserva(1, 11147852741, 1, '2020-09-13 11:00');
  const listaCarros: Carro[] = [new Carro(1, 'Chevrolet beat 2020', 'Manual', 2, 2, 'Gas'), new Carro(2, 'Renault logan 2018', 'Manual', 5, 4, 'Gasolina')];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualizarReservaComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [ReservaService, CarroService, HttpService],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    spyOn(reservaService, 'actualizar').and.returnValue(
      of(dummyReserva)
    );
    carroService = TestBed.inject(CarroService);
    spyOn(carroService, 'consultar').and.returnValue(
      of(listaCarros)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.reservaForm.valid).toBeFalsy();
  });

  it('Actualizando reserva', () => {
    expect(component.reservaForm.valid).toBeFalsy();
    component.reservaForm.controls.idCarro.setValue(1);
    component.reservaForm.controls.fechaRecogida.setValue('2020-09-13 11:00:00');
    expect(component.reservaForm.valid).toBeTruthy();
  });
});
