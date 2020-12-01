import { NgModule } from '@angular/core';
import { SharedModule } from '@shared/shared.module';
import { HomeComponent } from './components/home.component';
import { HomeRoutingModule } from './home-routing.module';
import { HomeService } from './shared/service/home.service';

@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    HomeRoutingModule,
    SharedModule
  ],
  providers: [HomeService]
})
export class HomeModule { }
