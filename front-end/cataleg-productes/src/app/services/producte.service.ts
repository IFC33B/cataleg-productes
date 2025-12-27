import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { Producte } from '../models';

@Injectable({
  providedIn: 'root',
})
export class ProducteService {
  private apiURL = 'http://localhost:8080/api/productes'

  constructor(private http: HttpClient) {};

  // Obtener todos los productos
  getAllProductes(): Observable<Producte> {
    return this.http.get<Producte>(this.apiURL)
      .pipe(
        catchError(this.handleError)
      )
  }
}
