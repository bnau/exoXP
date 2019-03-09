import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Computer } from 'src/app/computers/computer.model';
import { ComputerService } from 'src/app/computers/computer.service';

@Component({
  selector: 'app-edit-computers',
  templateUrl: './edit-computers.component.html'
})
export class EditComputersComponent implements OnInit {

  computer = new Computer();

  creationMode: boolean;

  constructor(
    private readonly computerService: ComputerService,
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) { }

  ngOnInit() {
    const id = this.route.snapshot.params['id'];

    this.creationMode = id === 'new';

    if (!this.creationMode) {
      this.computerService.getComputer(id).subscribe(comp =>
        this.computer = comp);
    }
  }

  update() {
    this.computerService.updateComputer(this.computer).subscribe(() =>
      this.cancel()
    );
  }

  delete() {
    if (confirm('Are you sure you want to delete this computer? This will also delete its computers.')) {
      this.computerService.deleteComputer(this.computer.id).subscribe(() =>
        this.cancel()
      );
    }
  }

  insert() {
    this.computerService.saveComputer(this.computer).subscribe(() =>
      this.cancel()
    );
  }

  cancel() {
    this.router.navigate(['/computers']);
  }
}
