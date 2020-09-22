import { NgModule } from '@angular/core';

import { ClienteRoutingModule } from './cliente-routing.module';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { SharedModule } from '@shared/shared.module';
import { ClienteService } from './shared/service/cliente.service';


@NgModule({
  declarations: [
    CrearClienteComponent,
    ClienteComponent
  ],
  imports: [
    ClienteRoutingModule,
    SharedModule
  ],
  providers: [ClienteService]
})
export class ClienteModule { }
