import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', loadChildren: () => import('./feature/home/home.module').then(mod => mod.HomeModule) },
  { path: 'reserva', loadChildren: () => import('./feature/reserva/reserva.module').then(mod => mod.ReservaModule) },
  { path: 'cliente', loadChildren: () => import('./feature/cliente/cliente.module').then(mod => mod.ClienteModule) },
  { path: 'carro', loadChildren: () => import('./feature/carro/carro.module').then(mod => mod.CarroModule) }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
