import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticaEditComponent } from './practica-edit.component';

describe('PracticaEditComponent', () => {
  let component: PracticaEditComponent;
  let fixture: ComponentFixture<PracticaEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PracticaEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticaEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
