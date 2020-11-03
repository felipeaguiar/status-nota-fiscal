import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HistoricoComponent } from './historico.component';
import { HistoricoRoutingModule } from './historico-routing.module';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import { TableModule } from 'primeng/table';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    HistoricoComponent
  ],
  imports: [
    CommonModule,
    HistoricoRoutingModule,
    CalendarModule,
    FormsModule,
    TableModule,
    SharedModule
  ]
})
export class HistoricoModule { }
