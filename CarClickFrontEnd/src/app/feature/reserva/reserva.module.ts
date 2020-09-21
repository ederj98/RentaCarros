import { NgModule } from '@angular/core';

import { ReservaRoutingModule } from './reserva-routing.module';
import { ListarReservaComponent } from './components/listar-reserva/listar-reserva.component';
import { CrearReservaComponent } from './components/crear-reserva/crear-reserva.component';
import { DetalleReservaComponent } from './components/detalle-reserva/detalle-reserva.component';
import { ReservaComponent } from './components/reserva/reserva.component';
import { SharedModule } from '@shared/shared.module';
import { ReservaService } from './shared/service/reserva.service';
import { ActualizarReservaComponent } from './components/actualizar-reserva/actualizar-reserva.component';


@NgModule({
  declarations: [
    CrearReservaComponent,
    ListarReservaComponent,
    DetalleReservaComponent,
    ActualizarReservaComponent,
    ReservaComponent
  ],
  imports: [
    ReservaRoutingModule,
    SharedModule
  ],
  providers: [ReservaService]
})
export class ReservaModule { }
