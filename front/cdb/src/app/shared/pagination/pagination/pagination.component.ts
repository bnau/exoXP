import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Page } from '../model/page';
import { IPageService } from '../page-service-interface';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html'
})
export class PaginationComponent implements OnInit {

  @Input() page: Page<unknown>;

  @Output() pageChange = new EventEmitter<unknown>();

  @Input() service: IPageService<unknown>;

  constructor() { }

  ngOnInit() {
  }

  getRoute(num: number) {
    this.service.getEntities(num).subscribe(compPage => {
      this.page = compPage;
      this.pageChange.emit(this.page);
    });
  }

  getNext() {
    this.getRoute(this.page.number + 1);
  }

  getPrev() {
    this.getRoute(this.page.number - 1);
  }

}
