import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { AppRoutingModule } from './app-routing.module';
import { CustomerBookingManageComponent } from './customer-booking-manage/customer-booking-manage.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CustomerSearchComponent,
    CustomerBookingManageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
