import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Company } from 'src/app/companies/company.model';
import { CompanyService } from 'src/app/companies/company.service';

@Component({
  selector: 'app-edit-companies',
  templateUrl: './edit-companies.component.html'
})
export class EditCompaniesComponent implements OnInit {

  company: Company;

  constructor(
    private readonly companyService: CompanyService,
    private readonly route: ActivatedRoute
  ) { }

  ngOnInit() {
    this.companyService.getCompany(this.route.snapshot.params['id']).subscribe(comp =>
      this.company = comp);
  }

  update() {
    this.companyService.updateCompany(this.company);
  }

}
