import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecyDetailsComponent } from './specy-details.component';

describe('SpecyDetailsComponent', () => {
  let component: SpecyDetailsComponent;
  let fixture: ComponentFixture<SpecyDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpecyDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
