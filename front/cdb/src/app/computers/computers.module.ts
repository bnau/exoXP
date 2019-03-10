import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared-module';
import { ComputersComponent } from './computers.component';
import { DatePosteriorValidatorDirective } from './date-posterior-validator.directive';
import { EditComputersComponent } from './edit-computers/edit-computers.component';

@NgModule({
  declarations: [ComputersComponent, EditComputersComponent, DatePosteriorValidatorDirective],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    SharedModule
  ]
})
export class ComputersModule { }
