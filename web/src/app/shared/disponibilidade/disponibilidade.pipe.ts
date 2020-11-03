import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'disponibilidade'
})
export class DisponibilidadePipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    if (value === 'VERDE') {
      return '<i class="pi pi-check"></i>';
    }

    if (value === 'AMARELO') {
      return '<i class="pi pi-question-circle"></i>'
    }

    if (value === 'VERMELHO') {
      return '<i class="pi pi-times"></i>'
    }

    return '';
  }

}
