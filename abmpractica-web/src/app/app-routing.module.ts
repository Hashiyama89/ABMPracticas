import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainComponent } from './componentes/main/main.component'
import { PracticaComponent } from './componentes/practica/practica.component'

const routes: Routes = [{
        path: '',
        pathMatch: 'full',
		component: MainComponent
    },{
		path:'practica',
		component: PracticaComponent,
	},{
		path:'area',
		component: PracticaComponent,
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
