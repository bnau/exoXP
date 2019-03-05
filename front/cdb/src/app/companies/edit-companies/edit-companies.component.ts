import { Component, OnInit } from '@angular/core';
import { Company } from 'src/app/companies/company.model';
import { CompanyService } from 'src/app/companies/company.service';

@Component({
  selector: 'app-edit-companies',
  templateUrl: './edit-companies.component.html'
})
export class EditCompaniesComponent implements OnInit {

  private company: Company;

  constructor(private readonly companyService: CompanyService) { }

  ngOnInit() {
  }

}
