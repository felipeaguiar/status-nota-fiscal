import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { StatusService } from '../services/status.service';

@Component({
  selector: 'app-status',
  templateUrl: './status.component.html',
  styleUrls: ['./status.component.scss']
})
export class StatusComponent implements OnInit {

  itens = [];

  constructor(
    private statusService: StatusService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
    this.statusService.statusAtual()
      .then(e => {
        this.itens = e.itens;
      })
      .catch(() => this.messageService.add({severity:'error', detail:'Erro ao recuperar dados.'}));
  }

}
