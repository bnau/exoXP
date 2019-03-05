import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from './company.model';
import { Page } from '../shared/model/page';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private readonly httpClient: HttpClient) { }

  private companies: Page<Company>;

  private getDbCompanies(num?: number): void {
    if(!num){
      num=0;
    }
    this.httpClient.get<Page<Company>>(`/api/companies?page=${num}`).subscribe(compPage =>
      this.setCompanies((compPage)));

  }

  getCompanies(num?: number): Page<Company> {
    this.getDbCompanies(num);
    return this.companies;
  }

  setCompanies(companies: Page<Company>): void {
    this.companies=companies;
  }
}
