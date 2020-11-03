import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DisponibilidadePipe } from './disponibilidade/disponibilidade.pipe';



@NgModule({
  declarations: [
    DisponibilidadePipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    DisponibilidadePipe
  ]
})
export class SharedModule { }
