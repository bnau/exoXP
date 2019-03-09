import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/companies/company.model';
import { CompanyService } from 'src/app/companies/company.service';
import { Page } from '../shared/pagination/model/page';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html'
})
export class CompaniesComponent implements OnInit {

  companiesPage: Page<Company>;

  constructor(private readonly companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getEntities().subscribe(compPage =>
      this.companiesPage = compPage);
  }

}
