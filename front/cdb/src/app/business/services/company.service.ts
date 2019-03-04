import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Company } from '../domain/company';
import { Page } from '../domain/page';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private readonly httpClient: HttpClient) { }

  getCompanies(): Observable<Page<Company>> {
    return this.httpClient.get<Page<Company>>('/api/companies');
  }

  getCompaniesByPageNum(num: number): Observable<Page<Company>> {
    return this.httpClient.get<Page<Company>>(`/api/companies?page=${num}`);
  }
}
