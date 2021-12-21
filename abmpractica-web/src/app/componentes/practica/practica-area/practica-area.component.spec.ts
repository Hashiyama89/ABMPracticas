import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticaAreaComponent } from './practica-area.component';

describe('PracticaAreaComponent', () => {
  let component: PracticaAreaComponent;
  let fixture: ComponentFixture<PracticaAreaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PracticaAreaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticaAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
