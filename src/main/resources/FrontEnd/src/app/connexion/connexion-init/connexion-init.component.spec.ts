import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnexionInitComponent } from './connexion-init.component';

describe('ConnexionInitComponent', () => {
  let component: ConnexionInitComponent;
  let fixture: ComponentFixture<ConnexionInitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConnexionInitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConnexionInitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
