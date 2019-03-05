import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CompaniesComponent } from './companies.component';
import { EditCompaniesComponent } from './edit-companies/edit-companies.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [CompaniesComponent, EditCompaniesComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [CompaniesComponent]
})
export class CompaniesModule { }
