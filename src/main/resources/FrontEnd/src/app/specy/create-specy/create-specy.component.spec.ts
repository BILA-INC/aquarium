import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSpecyComponent } from './create-specy.component';

describe('CreateSpecyComponent', () => {
  let component: CreateSpecyComponent;
  let fixture: ComponentFixture<CreateSpecyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSpecyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSpecyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
