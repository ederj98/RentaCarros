import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { ListarReservaComponent } from './listar-reserva.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { ReservaService } from '../../shared/service/reserva.service';
import { Reserva } from '../../shared/model/reserva';
import { HttpService } from 'src/app/core/services/http.service';

describe('ListarReservaComponent', () => {
  let component: ListarReservaComponent;
  let fixture: ComponentFixture<ListarReservaComponent>;
  let reservaService: ReservaService;
  const listaReservas: Reserva[] = [new Reserva(1, 11147852741, 1, '2020-09-13 11:00'), new Reserva(2, 11147852741, 2, '2020-09-11 14:00')];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListarReservaComponent],
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
    fixture = TestBed.createComponent(ListarReservaComponent);
    component = fixture.componentInstance;
    reservaService = TestBed.inject(ReservaService);
    spyOn(reservaService, 'consultar').and.returnValue(
      of(listaReservas)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.listaReserva.subscribe(resultado => {
      expect(2).toBe(resultado.length);
  });
});

});
