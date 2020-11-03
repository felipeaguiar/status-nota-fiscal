import { Component, OnInit } from '@angular/core';
import { Filtro, StatusService } from '../services/status.service';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-historico',
  templateUrl: './historico.component.html',
  styleUrls: ['./historico.component.scss']
})
export class HistoricoComponent implements OnInit {

  filtro = new Filtro();
  status = [];

  constructor(
    private statusService: StatusService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
  }

  buscar() {
    this.statusService.historico(this.filtro)
      .then(e => this.status = e.content)
      .catch(() => this.messageService.add({severity:'error', detail:'Erro ao recuperar dados.'}));
  }

}
