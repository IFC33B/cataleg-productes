import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Producte, ProducteRequest } from '../models';

@Injectable({
  providedIn: 'root',
})
export class ProducteService {
  private apiURL = 'http://localhost:8080/api/productes'

  constructor(private http: HttpClient) { };

  // Obtener todos los productos
  getAllProductes(): Observable<Producte> {
    return this.http.get<Producte>(this.apiURL)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Crear productos
  createProducte(request: ProducteRequest) {
    return this.http.post<Producte>(this.apiURL, request)
      .pipe(
        catchError(this.handleError)
      )
  }

  // Gestión de errores
    private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Error desconocido';
  
    if (error.error instanceof ErrorEvent) {
      // Error del cliente
      errorMessage = `Error: ${error.error.message}`
    } else {
      // Error del servidor
      errorMessage = `Codigo de error: ${error.status}, Mensaje: ${error.message}`;
    }
  
    console.log(errorMessage);
    return throwError(() => ({
      status: error.status,
      message: errorMessage,
      error: error.error
    }))
  }
}
