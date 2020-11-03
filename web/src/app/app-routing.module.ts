import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'status', pathMatch: 'full' },
  { path: 'status', loadChildren: () => import('./status/status.module').then(m => m.StatusModule) },
  { path: 'status-por-estado', loadChildren: () => import('./status-por-estado/status-por-estado.module').then(m => m.StatusPorEstadoModule) },
  { path: 'historico', loadChildren: () => import('./historico/historico.module').then(m => m.HistoricoModule) },
  { path: 'indisponibilidade', loadChildren: () => import('./indisponibilidade/indisponibilidade.module').then(m => m.IndisponibilidadeModule) },
  { path: '**', redirectTo: 'status' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
