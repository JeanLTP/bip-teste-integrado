import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Benefit } from '../../models/benefit.model';
import { CreateBenefitRequest } from '../../models/create-benefit-request.model';
import { CreatedIdResponse } from '../../models/create-id-response.model';

@Injectable({ providedIn: 'root' })
export class BenefitService {
    private readonly http = inject(HttpClient);
    private readonly apiUrl = 'http://localhost:8080/api/v1/benefits';

    findAll(): Observable<Benefit[]> {
        return this.http.get<Benefit[]>(this.apiUrl);
    }

    findById(id: number): Observable<Benefit> {
        return this.http.get<Benefit>(`${this.apiUrl}/${id}`); 
    }

    create(payload: CreateBenefitRequest): Observable<CreatedIdResponse> {
        return this.http.post<CreatedIdResponse>(this.apiUrl, payload);
    }
    
    update(id: number, payload: Benefit): Observable<Benefit> {
        return this.http.put<Benefit>(`${this.apiUrl}/${id}`, payload);
    }
}
