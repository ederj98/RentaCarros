import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: '/reserva', pathMatch: 'full' },
  { path: 'reserva', loadChildren: () => import('./feature/reserva/reserva.module').then(mod => mod.ReservaModule) },
  { path: 'cliente', loadChildren: () => import('./feature/cliente/cliente.module').then(mod => mod.ClienteModule) },
  { path: 'carro', loadChildren: () => import('./feature/carro/carro.module').then(mod => mod.CarroModule) }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
