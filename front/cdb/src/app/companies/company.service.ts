import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../shared/pagination/model/page';
import { IPageService } from '../shared/pagination/page-service-interface';
import { Company } from './company.model';

@Injectable({
  providedIn: 'root'
})
export class CompanyService implements IPageService<Company> {

  constructor(private readonly httpClient: HttpClient) { }

  getEntities(num?: number): Observable<Page<Company>> {
    if (!num) {
      num = 0;
    }
    return this.httpClient.get<Page<Company>>(`/api/companies?page=${num}`);
  }

  getCompany(id: number): Observable<Company> {
    return this.httpClient.get<Company>(`/api/companies/${id}`);
  }

  updateCompany(company: Company): Observable<any> {
    return this.httpClient.post('/api/companies', { ...company });
  }

  deleteCompany(id: number): Observable<any> {
    return this.httpClient.delete<Company>(`/api/companies/${id}`);
  }

  saveCompany(company: Company): Observable<number> {
    return this.httpClient.put<number>('/api/companies', { ...company });
  }
}

