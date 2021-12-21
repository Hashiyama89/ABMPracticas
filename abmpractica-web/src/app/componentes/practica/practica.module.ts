import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PracticaComponent } from './practica.component'
import { PracticaService } from './practica.service'
import { MaterialModule } from '../../shared/material/material.module'
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';

import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import { PracticaEditComponent } from './practica-edit/practica-edit.component';
import { PracticaAreaComponent } from './practica-area/practica-area.component';


@NgModule({
  declarations: [
	  PracticaComponent,
	  PracticaEditComponent,
	  PracticaAreaComponent
  ],
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    MaterialModule,
    ReactiveFormsModule,

  ],
  providers: [
	  PracticaService
  ],
	bootstrap: [PracticaComponent],

})
export class PracticaModule { }
