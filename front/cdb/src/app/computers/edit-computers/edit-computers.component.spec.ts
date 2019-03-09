import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditComputersComponent } from './edit-computers.component';

describe('EditComputersComponent', () => {
  let component: EditComputersComponent;
  let fixture: ComponentFixture<EditComputersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditComputersComponent ]
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
