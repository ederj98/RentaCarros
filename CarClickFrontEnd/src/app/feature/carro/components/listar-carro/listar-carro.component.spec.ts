import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';

import { ListarCarroComponent } from './listar-carro.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { CarroService } from '../../shared/service/carro.service';
import { Carro } from '../../shared/model/carro';
import { HttpService } from 'src/app/core/services/http.service';

describe('ListarCarroComponent', () => {
  let component: ListarCarroComponent;
  let fixture: ComponentFixture<ListarCarroComponent>;
  let carroService: CarroService;
  const listaCarros: Carro[] = [new Carro(1231234321, '2020', 'Manual', 2, 2, 'Gas'), new Carro(1231234390, '2019', 'Manual', 4, 4, 'Gas')];

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ListarCarroComponent],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [CarroService, HttpService]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarCarroComponent);
    component = fixture.componentInstance;
    carroService = TestBed.inject(CarroService);
    spyOn(carroService, 'consultar').and.returnValue(
      of(listaCarros)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.listaCarros.subscribe(resultado => {
      expect(2).toBe(resultado.length);
  });
});
});
