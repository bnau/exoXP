import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/companies/company.model';
import { CompanyService } from 'src/app/companies/company.service';
import { Page } from '../shared/model/page';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html'
})
export class CompaniesComponent implements OnInit {

  companiesPage: Page<Company>;

  constructor(private readonly companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getCompanies().subscribe(compPage =>
      this.companiesPage = compPage);
  }

  getRoute(num: number) {
    this.companyService.getCompanies(num).subscribe(compPage =>
      this.companiesPage = compPage);
  }

  getNext() {
    this.getRoute(this.companiesPage.number + 1);
  }

  getPrev() {
    this.getRoute(this.companiesPage.number - 1);
  }

}
