import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { DetalleReservaComponent } from './detalle-reserva.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { ReservaService } from '../../shared/service/reserva.service';
import { DetalleReserva } from '../../shared/model/detalle-reserva';
import { HttpService } from 'src/app/core/services/http.service';

describe('ListarReservaComponent', () => {
  let component: DetalleReservaComponent;
  let fixture: ComponentFixture<DetalleReservaComponent>;
  let reservaService: ReservaService;
  const dummyDetalleReserva = new DetalleReserva(1, 1, '2020-09-13 11:00:00', 148000);

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DetalleReservaComponent],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [ReservaService, HttpService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    spyOn(reservaService, 'guardarDetalle').and.returnValue(
      of(dummyDetalleReserva)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
