import { Routes } from '@angular/router';
import { BenefitListComponent } from './features/benefits/benefit-list.component';
import { BenefitFormComponent } from './features/benefits/benefit-form.component';
import { BenefitDetailComponent } from './features/benefits/benefit-detail.component';

export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'benefits' },
    { path: 'benefits', component: BenefitListComponent },
    { path: 'benefits/new', component: BenefitFormComponent },
    { path: 'benefits/:id', component: BenefitDetailComponent },
    { path: 'benefits/:id/edit', component: BenefitFormComponent }
];
