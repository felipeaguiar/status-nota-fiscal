import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  items: MenuItem[];

  ngOnInit() {
    this.items = [
      {
        label: 'Status',
        icon: 'pi pi-fw pi-file',
        items: [
          {
            label: 'Status Atual',
            icon: 'pi pi-fw pi-globe',
            routerLink: 'status'
          },
          {
            label: 'Status Por Estado',
            icon: 'pi pi-fw pi-map-marker',
            routerLink: 'status-por-estado'
          }
        ]
      },
      {
        label: 'Histórico',
        icon: 'pi pi-fw pi-clock',
        items: [
          {
            label: 'Histórico Por Estado',
            icon: 'pi pi-fw pi-search',
            routerLink: 'historico'
          },
          {
            label: 'Estado Que Teve Mais Indisponibilidade',
            icon: 'pi pi-fw pi-exclamation-triangle',
            routerLink: 'indisponibilidade'
          }
        ]
      }
    ];
  }
}

