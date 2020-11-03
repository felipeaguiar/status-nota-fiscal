import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableModule } from 'primeng/table';
import { StatusComponent } from './status.component';
import { StatusRoutingModule } from './status-routing.module';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    StatusComponent
  ],
  imports: [
    CommonModule,
    StatusRoutingModule,
    TableModule,
    SharedModule
  ]
})
export class StatusModule { }
