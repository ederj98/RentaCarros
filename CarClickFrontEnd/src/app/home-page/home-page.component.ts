import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  title = 'Car Click';
  subtitle = 'Sistema de Gestión de Reservas';

  constructor() { }

  ngOnInit(): void {
  }

}
