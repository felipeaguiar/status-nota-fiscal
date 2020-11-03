import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StatusPorEstadoComponent } from './status-por-estado.component';
import { StatusPorEstadoRoutingModule } from './status-por-estado-routing.module';
import { FormsModule } from '@angular/forms'
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    StatusPorEstadoComponent
  ],
  imports: [
    CommonModule,
    StatusPorEstadoRoutingModule,
    FormsModule,
    DropdownModule,
    ButtonModule,
    SharedModule
  ]
})
export class StatusPorEstadoModule { }
