import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecyListComponent } from './specy-list.component';

describe('SpecyListComponent', () => {
  let component: SpecyListComponent;
  let fixture: ComponentFixture<SpecyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpecyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
