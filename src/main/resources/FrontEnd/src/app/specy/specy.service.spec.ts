import { TestBed } from '@angular/core/testing';

import { SpecyService } from './specy.service';

describe('SpecyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SpecyService = TestBed.get(SpecyService);
    expect(service).toBeTruthy();
  });
});
