import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { CompaniesComponent } from './companies/companies.component';

@NgModule({
  declarations: [CompaniesComponent],
  imports: [
    CommonModule
  ],
  exports: [CompaniesComponent]
})
export class ScreensModule { }
