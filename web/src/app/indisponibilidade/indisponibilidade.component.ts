import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { StatusService } from '../services/status.service';

@Component({
  selector: 'app-indisponibilidade',
  templateUrl: './indisponibilidade.component.html',
  styleUrls: ['./indisponibilidade.component.scss']
})
export class IndisponibilidadeComponent implements OnInit {

  estado: string;

  constructor(
    private statusService: StatusService,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
    this.statusService.estadoComMaisIndisponibilidade()
      .then(e => this.estado = e.nome)
      .catch(() => this.messageService.add({severity:'error', detail:'Não há indisponibilidades.'}));
  }

}
