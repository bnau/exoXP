import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/business/domain/company';
import { Page } from 'src/app/business/domain/page';
import { CompanyService } from 'src/app/business/services/company.service';

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
    this.companyService.getCompaniesByPageNum(num).subscribe(compPage =>
      this.companiesPage = compPage);
  }

  getNext() {
    this.getRoute(this.companiesPage.number + 1);
  }

  getPrev() {
    this.getRoute(this.companiesPage.number - 1);
  }

}
