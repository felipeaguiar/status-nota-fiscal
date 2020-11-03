import { Component, OnInit } from '@angular/core';
import { StatusService } from '../services/status.service';
import { MessageService, SelectItem } from 'primeng/api';

@Component({
  selector: 'app-status-por-estado',
  templateUrl: './status-por-estado.component.html',
  styleUrls: ['./status-por-estado.component.scss']
})
export class StatusPorEstadoComponent implements OnInit {

  estadoSelecionado: string = 'AM';

  estados = [
    { label: 'AM', value: 'AM' },
    { label: 'BA', value: 'BA' },
    { label: 'CE', value: 'CE' },
    { label: 'GO', value: 'GO' },
    { label: 'MG', value: 'MG' },
    { label: 'MS', value: 'MS' },
    { label: 'MT', value: 'MT' },
    { label: 'PE', value: 'PE' },
    { label: 'PR', value: 'PR' },
    { label: 'RS', value: 'RS' },
    { label: 'SP', value: 'SP' }
  ];

  status: any = {};

  constructor(
    private statusService: StatusService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
  }

  buscar() {
    this.statusService.statusPorEstado(this.estadoSelecionado)
      .then(e => this.status = e)
      .catch(() => this.messageService.add({severity:'error', detail:'Erro ao recuperar dados.'}));
  };

}
