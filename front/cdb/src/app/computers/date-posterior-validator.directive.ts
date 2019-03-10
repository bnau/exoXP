import { Attribute, Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
    selector: '[appDatePosteriorValidator]',
    providers: [{ provide: NG_VALIDATORS, useExisting: DatePosteriorValidatorDirective, multi: true }]
})
export class DatePosteriorValidatorDirective implements Validator {

    constructor(
        @Attribute('anteriorDate') public anteriorDate: string,
        @Attribute('posteriorDate') public posteriorDate: string) {
    }

    validate(control: AbstractControl): ValidationErrors {
        let postDateControl;
        let postDate;
        let antDateControl;
        let antDate;
        if (this.anteriorDate != null) {
            postDateControl = control;
            postDate = postDateControl.value;
            antDateControl = control.root.get(this.anteriorDate);
            antDate = antDateControl.value;
        } else {
            antDateControl = control;
            antDate = antDateControl.value;
            postDateControl = control.root.get(this.posteriorDate);
            postDate = postDateControl && postDateControl.value;
        }
        if (postDate != null && antDate != null && new Date(postDate) < new Date(antDate)) {
            antDateControl.setErrors({ posteriorDate: { valid: false } });
            postDateControl.setErrors({ posteriorDate: { valid: false } });
            return { posteriorDate: { valid: false } };
        } else {
            antDateControl.setErrors(null);
            postDateControl && postDateControl.setErrors(null);
            return null;
        }
    }
}
