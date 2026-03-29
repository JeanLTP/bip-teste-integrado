import { ChangeDetectorRef, Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Benefit } from '../../models/benefit.model';
import { BenefitService } from '../../core/service/benefit.service';

@Component({
    selector: 'app-benefit-detail',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './benefit-detail.component.html',
    styleUrl: './benefit-detail.component.css'
})
export class BenefitDetailComponent implements OnInit {

    private readonly route = inject(ActivatedRoute);
    private readonly benefitService = inject(BenefitService);
    private readonly cdr = inject(ChangeDetectorRef);
    
    benefit?: Benefit;
    loading = true;
    error = '';
    
    ngOnInit(): void {
        this.loadingBenefit();
    }
    
    loadingBenefit(): void {
        this.loading = true;
        this.error = '';

        const id = Number(this.route.snapshot.paramMap.get('id'));
        this.benefitService.findById(id).subscribe({ 
            next: (response) => {
                this.benefit = response;
                this.loading = false;
                this.cdr.detectChanges();
            },
            error: (err) => {
                this.error = err?.error?.message ?? 'Benefício não encontrado.';
                this.loading = false;
                this.cdr.detectChanges();
            }
        });
    }
}
