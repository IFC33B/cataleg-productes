import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulariProductes } from './formulari-productes';

describe('FormulariProductes', () => {
  let component: FormulariProductes;
  let fixture: ComponentFixture<FormulariProductes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormulariProductes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulariProductes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
