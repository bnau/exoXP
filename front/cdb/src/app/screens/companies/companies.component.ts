import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/business/domain/company';
import { CompanyService } from 'src/app/business/services/company.service';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.scss']
})
export class CompaniesComponent implements OnInit {

  companies: Company[] = [];

  constructor(private readonly companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getCompanies().subscribe(comp =>
      this.companies = comp);
  }

}
