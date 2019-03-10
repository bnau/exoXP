import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { EditComputersComponent } from './edit-computers.component';


describe('EditComputersComponent', () => {
  let component: EditComputersComponent;
  let fixture: ComponentFixture<EditComputersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EditComputersComponent],
      imports: [HttpClientModule, RouterTestingModule, FormsModule]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditComputersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
