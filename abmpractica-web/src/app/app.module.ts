import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { SidenavComponent } from './shared/sidenav/sidenav.component';
import { MainComponent } from './componentes/main/main.component';
import { MaterialModule } from './shared/material/material.module'
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { PracticaModule} from './componentes/practica/practica.module'
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
	FormsModule,
	ReactiveFormsModule,
	MaterialModule,
	PracticaModule,
	HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
