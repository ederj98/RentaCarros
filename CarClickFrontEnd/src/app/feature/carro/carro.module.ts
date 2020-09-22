import { NgModule } from '@angular/core';

import { CarroRoutingModule } from './carro-routing.module';
import { CrearCarroComponent } from './components/crear-carro/crear-carro.component';
import { CarroComponent } from './components/carro/carro.component';
import { SharedModule } from '@shared/shared.module';
import { CarroService } from './shared/service/carro.service';


@NgModule({
  declarations: [
    CrearCarroComponent,
    CarroComponent
  ],
  imports: [
    CarroRoutingModule,
    SharedModule
  ],
  providers: [CarroService]
})
export class CarroModule { }
