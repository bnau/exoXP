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

  creationMode: boolean;

  constructor(
    private readonly companyService: CompanyService,
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];

    this.creationMode = id === 'new';

    if (!this.creationMode) {
      this.companyService.getCompany(id).subscribe(comp =>
        this.company = comp);
    }
  }

  update() {
    this.companyService.updateCompany(this.company).subscribe(() =>
      this.cancel()
    );
  }

  delete() {
    if (confirm('Are you sure you want to delete this company? This will also delete its computers.')) {
      this.companyService.deleteCompany(this.company.id).subscribe(() =>
        this.cancel()
      );
    }
  }

  insert() {
    this.companyService.saveCompany(this.company).subscribe(() =>
      this.cancel()
    );
  }

  cancel() {
    this.router.navigate(['/companies']);
  }
}
