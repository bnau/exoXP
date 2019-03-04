import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/business/domain/company';
import { CompanyService } from 'src/app/business/services/company.service';
import { Page } from 'src/app/business/domain/page';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.scss']
})
export class CompaniesComponent implements OnInit {

  companiesPage: Page<Company>;

  constructor(private readonly companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getCompanies().subscribe(compPage =>
      this.companiesPage = compPage);
  }

}
