import { ChangeDetectorRef, Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Benefit } from '../../models/benefit.model';
import { BenefitService } from '../../core/service/benefit.service';

@Component({
    selector: 'app-benefit-list',
    standalone: true,
    imports: [CommonModule, RouterLink],
    templateUrl: './benefit-list.component.html',
    styleUrls: ['./benefit-list.component.css']
})
export class BenefitListComponent implements OnInit {
    
    private readonly benefitService = inject(BenefitService);
    private readonly cdr = inject(ChangeDetectorRef);
    
    benefits: Benefit[] = [];
    loading = true;
    error = '';

    ngOnInit(): void {
        this.loadingBenefits();
    }
    
    loadingBenefits(): void {
        this.loading = true;
        this.error = '';

        this.benefitService.findAll().subscribe({
            next: (response) => {
                this.benefits = [...response];
                this.loading = false;
                this.cdr.detectChanges();
            },
            error: (err) => {
                this.error = err?.error?.message ?? 'Erro ao carregar benefícios.';
                this.loading = false;
                this.cdr.detectChanges();
            }
        });
    }
}