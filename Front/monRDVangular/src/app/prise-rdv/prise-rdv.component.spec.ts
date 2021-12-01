import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PriseRDVComponent } from './prise-rdv.component';

describe('PriseRDVComponent', () => {
  let component: PriseRDVComponent;
  let fixture: ComponentFixture<PriseRDVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PriseRDVComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PriseRDVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
