import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from 'src/app/companies/company.model';
import { CompanyService } from 'src/app/companies/company.service';

@Component({
  selector: 'app-edit-companies',
  templateUrl: './edit-companies.component.html'
})
export class EditCompaniesComponent implements OnInit {

  company = new Company();

  constructor(
    private readonly companyService: CompanyService,
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) { }

  ngOnInit() {
    this.companyService.getCompany(this.route.snapshot.params['id']).subscribe(comp =>
      this.company = comp);
  }

  update() {
    this.companyService.updateCompany(this.company).subscribe(() =>
      this.router.navigate(['/companies'])
    );
  }

}
