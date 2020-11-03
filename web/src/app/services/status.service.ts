import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import * as moment from 'moment';

export class Filtro {
  dataDe: Date;
  dataAte: Date;
  page = 0;
  size = 5;
}

@Injectable({
  providedIn: 'root'
})
export class StatusService {

  url: string;

  constructor(
    private http: HttpClient,
  ) {
    this.url = environment.url;
  }

  async statusAtual() {
    return await this.http.get<any>(`${this.url}/status/status-atual`).toPromise();
  }

  async statusPorEstado(estado: string) {
    return await this.http.get<any>(`${this.url}/status/status-atual-por-estado/${estado}`).toPromise();
  }

  async estadoComMaisIndisponibilidade() {
    return await this.http.get<any>(`${this.url}/status/obter-estado-com-maior-indisponibilidade`).toPromise();
  }

  async historico(filtro: Filtro) {
    let params = new HttpParams();

    if (filtro.dataDe) {
      params = params.set('dataDe', moment(filtro.dataDe).format(''))
    }

    if (filtro.dataAte) {
      params = params.set('dataAte', moment(filtro.dataAte).format(''))
    }

    return await this.http.get<any>(`${this.url}/status`, { params }).toPromise();
  }

}
