import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IndisponibilidadeComponent } from './indisponibilidade.component';
import { IndisponibilidadeRoutingModule } from './indisponibilidade-routing.module';

@NgModule({
  declarations: [
    IndisponibilidadeComponent
  ],
  imports: [
    CommonModule,
    IndisponibilidadeRoutingModule
  ]
})
export class IndisponibilidadeModule { }
