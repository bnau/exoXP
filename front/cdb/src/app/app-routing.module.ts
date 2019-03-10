import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompaniesComponent } from './companies/companies.component';
import { EditCompaniesComponent } from './companies/edit-companies/edit-companies.component';
import { ComputersComponent } from './computers/computers.component';
import { EditComputersComponent } from './computers/edit-computers/edit-computers.component';

const routes: Routes = [

  { path: 'companies', component: CompaniesComponent },
  { path: '', redirectTo: '/companies', pathMatch: 'full' },

  { path: 'companies/:id', component: EditCompaniesComponent },

  { path: 'computers', component: ComputersComponent },
  { path: 'computers/:id', component: EditComputersComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
