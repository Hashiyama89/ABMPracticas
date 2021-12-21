import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AreaJerarquica, Practica, PracticaAreaJerarquica } from '../practica.model';
import { PracticaService } from '../practica.service';

@Component({
  selector: 'app-practica-area',
  templateUrl: './practica-area.component.html',
  styleUrls: ['./practica-area.component.css']
})
export class PracticaAreaComponent implements OnInit {

  practica: Practica
  areasAsignadas: AreaJerarquica[] = []
  filtroDescripcion: string = ""
  areasEncontradas: AreaJerarquica[]

  constructor(private activatedRoute: ActivatedRoute, private practicaService: PracticaService) { }

  async ngOnInit() {
	const id = this.activatedRoute.snapshot.params['id']

	this.practica = await this.practicaService.obtenerPractica(id)

	await this.cargarAreasAsignadas()


  }

  async cargarAreasAsignadas () {
	const resultado = await this.practicaService.obtenerAreasAsignadas(this.practica)
	this.areasAsignadas = resultado.map(area => area.idArea)
  }


  async buscarArea() {
	const areas = await this.practicaService.obtenerAreas(this.filtroDescripcion)
	this.areasEncontradas = areas
				.filter((area: AreaJerarquica) => !this.areasAsignadas.find( a => a.idArea == area.idArea))
  }

  async asignarArea(idArea) {
	  const idPractica = this.activatedRoute.snapshot.params['id']
	  const resultado = await this.practicaService.asignarArea(+idPractica, idArea)
	  console.log("resultado", resultado)

	  this.areasEncontradas = null
	  this.filtroDescripcion = null
	  await this.cargarAreasAsignadas()

  }
}
