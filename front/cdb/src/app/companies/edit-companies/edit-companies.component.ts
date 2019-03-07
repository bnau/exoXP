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

  delete() {
    if (confirm("Are you sure you want to delete this. company? This will also delete its computers.")) {
      this.companyService.deleteCompany(this.company.id).subscribe(() =>
        this.router.navigate(['/companies'])
      );
    }
  }
}
