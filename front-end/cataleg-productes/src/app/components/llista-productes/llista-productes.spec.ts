import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LlistaProductes } from './llista-productes';

describe('LlistaProductes', () => {
  let component: LlistaProductes;
  let fixture: ComponentFixture<LlistaProductes>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LlistaProductes]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LlistaProductes);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
