import { Component, OnInit } from '@angular/core';
import { ComputerService } from 'src/app/computers/computer.service';
import { Page } from '../shared/pagination/model/page';
import { Computer } from './computer.model';

@Component({
  selector: 'app-computers',
  templateUrl: './computers.component.html'
})
export class ComputersComponent implements OnInit {

  computersPage: Page<Computer>;

  constructor(private readonly computerService: ComputerService) { }

  ngOnInit() {
    this.computerService.getEntities().subscribe(compPage =>
      this.computersPage = compPage);
  }

}
