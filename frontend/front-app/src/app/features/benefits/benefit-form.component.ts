import { ChangeDetectorRef, Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Benefit } from '../../models/benefit.model';
import { BenefitService } from '../../core/service/benefit.service';

@Component({
    selector: 'app-benefit-form',
    standalone: true,
    imports: [CommonModule, FormsModule, RouterLink],
    templateUrl: './benefit-form.component.html',
    styleUrl: './benefit-form.component.css'
})
export class BenefitFormComponent implements OnInit {
    
    private readonly benefitService = inject(BenefitService);
    private readonly route = inject(ActivatedRoute);
    private readonly router = inject(Router);
    private readonly cdr = inject(ChangeDetectorRef);
    
    isEdit = false;
    error = '';
    form: Benefit = {
        id: 0,
        name: '',
        description: '',
        value: 0,
        active: true,
        version: 0
    };

    ngOnInit(): void {
        const idParam = this.route.snapshot.paramMap.get('id');
        if (!idParam) return;
        
        this.isEdit = true;
        const id = Number(idParam);
        this.benefitService.findById(id).subscribe({
            next: (response) => {
                this.form = response,
                this.cdr.detectChanges();
            },
            error: (err) => {
                this.error = err?.error?.message ?? 'Erro ao carregar benefício.';
                this.cdr.detectChanges();
            }
        });
    }

    save(): void {
        if (this.isEdit) {
            this.benefitService.update(this.form.id, this.form).subscribe({
                next: () => {
                    this.router.navigate(['/benefits', this.form.id]);
                },
                error: (err) => {
                    this.error = err?.error?.message ?? 'Erro ao atualizar benefício.';
                    this.cdr.detectChanges();
                }
            });
        return;
    }

    const payload = {
        name: this.form.name,
        description: this.form.description,
        value: this.form.value,
        active: this.form.active
    };
    
    this.benefitService.create(payload).subscribe({
        next: (response) => {
            this.router.navigate(['/benefits', response.id])
        },
        error: (err) => {
            this.error = err?.error?.message ?? 'Erro ao criar benefício.';
            this.cdr.detectChanges();
        }
    });
}


}
