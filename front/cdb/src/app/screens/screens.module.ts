import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CompaniesComponent } from './companies/companies.component';
import { EditCompaniesComponent } from './edit-companies/edit-companies.component';

@NgModule({
  declarations: [CompaniesComponent, EditCompaniesComponent],
  imports: [
    CommonModule
  ],
  exports: [CompaniesComponent]
})
export class ScreensModule { }
