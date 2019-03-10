import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Page } from '../shared/pagination/model/page';
import { IPageService } from '../shared/pagination/page-service-interface';
import { Computer } from './computer.model';

@Injectable({
  providedIn: 'root'
})
export class ComputerService implements IPageService<Computer> {

  constructor(private readonly httpClient: HttpClient) { }

  getEntities(num?: number): Observable<Page<Computer>> {
    if (!num) {
      num = 0;
    }
    return this.httpClient.get<Page<Computer>>(`/api/computers?page=${num}`);
  }

  getComputer(id: number): Observable<Computer> {
    return this.httpClient.get<Computer>(`/api/computers/${id}`);
  }

  updateComputer(computer: Computer): Observable<any> {
    return this.httpClient.post('/api/computers', { ...computer });
  }

  deleteComputer(id: number): Observable<any> {
    return this.httpClient.delete<Computer>(`/api/computers/${id}`);
  }

  saveComputer(computer: Computer): Observable<number> {
    return this.httpClient.put<number>('/api/computers', { ...computer });
  }
}

