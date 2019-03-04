import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { CompanyService } from './company.service';


describe('CompanyService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientModule]
  }));

  it('should be created', () => {
    const service: CompanyService = TestBed.get(CompanyService);
    expect(service).toBeTruthy();
  });
});
