import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompaniesComponent } from './companies/companies.component';
import { EditCompaniesComponent } from './companies/edit-companies/edit-companies.component';

const routes: Routes = [

  { path: 'companies', component: CompaniesComponent },
  { path: '', redirectTo: '/companies', pathMatch: 'full' },
  
  { path: 'companies/:id', component: EditCompaniesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
