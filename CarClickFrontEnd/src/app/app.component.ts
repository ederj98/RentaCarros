import { Component } from '@angular/core';
import { MenuItem } from '@core/modelo/menu-item';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'car-click';
  public menu: MenuItem[] = [
    { url: '/home', nombre: 'Inicio' },
    { url: '/reserva', nombre: 'Reservas' },
    { url: '/cliente', nombre: 'Clientes' },
    { url: '/carro', nombre: 'Carros' }
  ];  
}
