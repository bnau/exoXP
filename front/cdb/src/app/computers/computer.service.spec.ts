import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { ComputerService } from './computer.service';


describe('ComputerService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientModule]
  }));

  it('should be created', () => {
    const service: ComputerService = TestBed.get(ComputerService);
    expect(service).toBeTruthy();
  });
});
