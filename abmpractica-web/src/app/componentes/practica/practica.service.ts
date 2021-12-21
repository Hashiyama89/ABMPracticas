import { Injectable } from '@angular/core';
import {Practica } from './practica.model'
import { ApiService } from '../../shared/api/api.service'
import { Observable } from 'rxjs'


@Injectable({
  providedIn: 'root'
})
export class PracticaService {


  constructor(private apiService: ApiService) { }

  async listarPracticas(filtro?: Practica) : Promise<Practica[]>{
	  return this.apiService.invocar('practica', filtro).toPromise()
  }

  async obtenerPractica(id: number) {
	return await this.apiService.invocar(`practica/${id}`).toPromise()
  }

  borrarPractica(id) {
	  return this.apiService.invocar(`practica/borrar/${id}`).toPromise()
  }


  editarPractica(practica: Practica) {
	return this.apiService.invocar(`practica/modificar`, practica).toPromise()
  }

  agregarPractica(practica: Practica) {
	return this.apiService.invocar(`practica/crear`, practica).toPromise()

  }

  obtenerAreasAsignadas(practica: Practica) {
	  return this.apiService.invocar(`areajerarquica/practica/${practica.idPractica}`).toPromise()
  }

  obtenerAreas(filtroDescripcion: string) {
	  const filtro = filtroDescripcion ? { descripcion: filtroDescripcion} : null
	  return this.apiService.invocar(`areajerarquica`, filtro).toPromise()
  } 

  asignarArea(idPractica, idArea) {
	  return this.apiService.invocar(`practica/asignarArea`, {
		  idArea,
		  idPractica
	  }).toPromise()
  }
}
