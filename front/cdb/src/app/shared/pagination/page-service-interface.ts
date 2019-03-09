import { Observable } from 'rxjs';
import { Page } from './model/page';

export interface IPageService<T> {
    getEntities(num: number): Observable<Page<T>>;
}
