export interface Practica {
	idPractica: number,
	descripcion: string,
	visible: string,
	refinaMuestras: string,
	pedible: string

}

export interface AreaJerarquica {
	idArea: number,
	descripcion: string
}

export interface PracticaAreaJerarquica {
	idPracticaArea: number,
	idArea: AreaJerarquica,
	idPractica: Practica

}