import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearCarroComponent } from './components/crear-carro/crear-carro.component';
import { CarroComponent } from './components/carro/carro.component';


const routes: Routes = [
  {
    path: '',
    component: CarroComponent,
    children: [
      {
        path: 'crear',
        component: CrearCarroComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CarroRoutingModule { }
