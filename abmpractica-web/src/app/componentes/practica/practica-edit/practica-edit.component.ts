import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Practica } from '../practica.model';
import { PracticaService } from '../practica.service';

@Component({
	selector: 'app-practica-edit',
	templateUrl: './practica-edit.component.html',
	styleUrls: ['./practica-edit.component.css']
})
export class PracticaEditComponent implements OnInit {


	editMode: boolean = false

	formGroup: FormGroup = new FormGroup({
		idPractica: new FormControl({value:null, disabled:true}),
		descripcion: new FormControl("", Validators.required),
		visible: new FormControl(null),
		pedible: new FormControl(null),
		refinaMuestras: new FormControl(null),
	});

	constructor(public router: Router, private activatedRoute: ActivatedRoute, private practicaService: PracticaService) { }

	async ngOnInit() {
		const id = this.activatedRoute.snapshot.params['id']
		if (id) {
			this.editMode = true
			this.formGroup.get('idPractica').setValue(id)
			const practica = await this.practicaService.obtenerPractica(id)
			this.formGroup.setValue(practica)
		}

	}



	async guardar() {
		if (this.formGroup.invalid) return

		const practica = this.formGroup.value

		try {

			if (this.editMode) {
				practica.idPractica = this.activatedRoute.snapshot.params['id']
				const resultado = await this.practicaService.editarPractica(practica)
				alert("Practica modificada de forma éxitosa")

			} else {
				const resultado = await this.practicaService.agregarPractica(practica)
				alert("Practica creada de forma éxitosa")
			}


			this.cancelar()
		} catch (error) {
			console.log("error", error)
			alert("No se pudo crear la practica, por favor revise los campos")
		}
	}

	cancelar() {
		this.router.navigate(['/practica'])
	}

}
