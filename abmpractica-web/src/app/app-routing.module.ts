import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './componentes/main/main.component'
import { PracticaAreaComponent } from './componentes/practica/practica-area/practica-area.component';
import { PracticaEditComponent } from './componentes/practica/practica-edit/practica-edit.component';
import { PracticaComponent } from './componentes/practica/practica.component'

const routes: Routes = [{
        path: '',
        pathMatch: 'full',
		component: MainComponent
    },{
		path:'practica',
		children:[{
			path: '',
			pathMatch: 'full',
			component: PracticaComponent
		},{
			path: 'agregar',
			component: PracticaEditComponent
		},{
			path: 'editar/:id',
			component: PracticaEditComponent
		}]
	},{
		path:'area/:id',
		component: PracticaAreaComponent,
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
