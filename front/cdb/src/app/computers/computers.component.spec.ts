import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { SharedModule } from '../shared/shared-module';
import { ComputersComponent } from './computers.component';


describe('ComputersComponent', () => {
  let component: ComputersComponent;
  let fixture: ComponentFixture<ComputersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ComputersComponent],
      imports: [HttpClientModule, RouterTestingModule, SharedModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComputersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
