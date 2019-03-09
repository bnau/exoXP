import { TestBed } from '@angular/core/testing';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { HttpErrorInterceptorService } from './http-error-interceptor.service';


describe('HttpErrorInterceptorService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [MatSnackBarModule]
  }));

  it('should be created', () => {
    const service: HttpErrorInterceptorService = TestBed.get(HttpErrorInterceptorService);
    expect(service).toBeTruthy();
  });
});
