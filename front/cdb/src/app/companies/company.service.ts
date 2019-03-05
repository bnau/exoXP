import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../shared/model/page';
import { Company } from './company.model';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private readonly httpClient: HttpClient) { }

  getCompanies(num?: number): Observable<Page<Company>> {
    if (!num) {
      num = 0;
    }
    return this.httpClient.get<Page<Company>>(`/api/companies?page=${num}`);
  }

  getCompany(num: number): Observable<Company> {
    return this.httpClient.get<Company>(`/api/companies/${num}`);
  }

  updateCompany(company: Company): void {
    this.httpClient.post('/api/companies', { company });
  }
}
