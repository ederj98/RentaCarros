import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-alert',
  templateUrl: 'alert.component.html',
})
export class AlertComponent implements OnInit {

  @Input()
  cabecera: string;

  @Input()
  mensaje: string;

  constructor() { }

  ngOnInit() {
  }

}
