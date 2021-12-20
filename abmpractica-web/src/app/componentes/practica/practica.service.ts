import { Injectable } from '@angular/core';
import {Practica } from './practica.model'
import { ApiService } from '../../shared/api/api.service'
import { Observable } from 'rxjs'


@Injectable({
  providedIn: 'root'
})
export class PracticaService {


  constructor(private apiService: ApiService) { }

  listarPracticas() : Observable<Practica[]>{
	  return this.apiService.invocar('practica')
  }

  borrarPractica(id) {
	  return this.apiService.invocar(`practica/borrar/${id}`)
  }
}
