import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { SharedModule } from '../shared/shared-module';
import { CompaniesComponent } from './companies.component';
import { EditCompaniesComponent } from './edit-companies/edit-companies.component';

@NgModule({
  declarations: [CompaniesComponent, EditCompaniesComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    SharedModule
  ]
})
export class CompaniesModule { }
