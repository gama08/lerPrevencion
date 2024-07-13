import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearActualizarComponent } from './crear-actualizar.component';

describe('CrearActualizarComponent', () => {
  let component: CrearActualizarComponent;
  let fixture: ComponentFixture<CrearActualizarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearActualizarComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearActualizarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
