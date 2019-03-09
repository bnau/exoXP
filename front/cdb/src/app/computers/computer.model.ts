import { Company } from 'src/app/companies/company.model';

export class Computer {
    id: number;
    name: string;
    introduced: Date;
    discontinued: Date;
    company: Company;
}
