import { Component, OnInit } from '@angular/core';
import { Practica } from './practica.model' 
import { PracticaService } from './practica.service'
import { Observable} from 'rxjs'
import {Router,} from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-practica',
  templateUrl: './practica.component.html',
  styleUrls: ['./practica.component.css']
})
export class PracticaComponent implements OnInit {

	displayedColumns:string[] = ["idPractica","descripcion","visible","pedible","refinaMuestras","acciones"]
	listaPracticas :Practica[]

	formGroup: FormGroup = new FormGroup({
		descripcion: new FormControl(null),
		visible: new FormControl(null),
		pedible: new FormControl(null),
		refinaMuestras: new FormControl(null),
	});



  constructor(public practicaService: PracticaService, private router: Router) { }

  async ngOnInit() {
	this.listaPracticas  = await this.practicaService.listarPracticas()

  }

   agregarPractica() {
	   this.router.navigate(['/practica/agregar'])
   }


	editarPractica(practica: Practica) {
		this.router.navigate(['practica','editar',practica.idPractica])
	}

	 async borrarPractica(practica: Practica) {
		await this.practicaService.borrarPractica(practica.idPractica)
		location.reload()
	}

	asignarArea(practica: Practica ) {
		this.router.navigate(['area', practica.idPractica])
	}

	async buscarPractica() {
		const filtro = this.formGroup.value
		console.log("filtro", filtro)
		this.listaPracticas  = await this.practicaService.listarPracticas(filtro)


	}

	limpiarFiltro() {
		this.formGroup.reset()
	}


}




