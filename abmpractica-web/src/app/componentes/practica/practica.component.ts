import { Component, OnInit } from '@angular/core';
import { Practica } from './practica.model' 
import { PracticaService } from './practica.service'
import { Observable} from 'rxjs'
import {Router,} from '@angular/router';

@Component({
  selector: 'app-practica',
  templateUrl: './practica.component.html',
  styleUrls: ['./practica.component.css']
})
export class PracticaComponent implements OnInit {

	displayedColumns:string[] = ["idPractica","descripcion","visible","pedible","refinaMuestras","acciones"]
	dataSource$ :Observable<Practica[]>

  constructor(public practicaService: PracticaService, private router: Router) { }

  ngOnInit(): void {
	  this.dataSource$  = this.practicaService.listarPracticas()
  }


	editarPractica(practica: Practica) {
		console.log("editar")
	}

	 borrarPractica(practica: Practica) {
		this.practicaService
				.borrarPractica(practica.idPractica)
				.subscribe((param) => {
					location.reload();
		})
	}

	asignarArea(practica: Practica ) {

	}


}




