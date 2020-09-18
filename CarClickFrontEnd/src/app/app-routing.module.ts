import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerBookingManageComponent } from './customer-booking-manage/customer-booking-manage.component';
import { HomePageComponent } from './home-page/home-page.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'customer-booking', component: CustomerBookingManageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }