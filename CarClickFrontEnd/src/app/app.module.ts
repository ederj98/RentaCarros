import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { CoreModule } from '@core/core.module';
import { CookieService } from 'ngx-cookie-service';
import { HomeModule } from '@home/home.module';
import { ClienteModule } from './feature/cliente/cliente.module';
import { CarroModule } from './feature/carro/carro.module';
import { ReservaModule } from './feature/reserva/reserva.module';
import { HomeService } from './feature/home/shared/service/home.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HomeModule,
    ClienteModule,
    CarroModule,
    ReservaModule,
    CoreModule
  ],
  providers: [CookieService,HomeService],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
