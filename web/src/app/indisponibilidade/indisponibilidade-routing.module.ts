import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndisponibilidadeComponent } from './indisponibilidade.component';

const routes: Routes = [
  { path: '', component: IndisponibilidadeComponent }
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class IndisponibilidadeRoutingModule { }
