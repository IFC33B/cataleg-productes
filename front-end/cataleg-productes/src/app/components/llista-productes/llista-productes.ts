import { Component, signal } from '@angular/core';
import { Producte } from '../../models';
import { HttpErrorResponse } from '@angular/common/http';
import { ProducteService } from '../../services/producte.service';

@Component({
  selector: 'app-llista-productes',
  imports: [],
  templateUrl: './llista-productes.html',
  styleUrl: './llista-productes.css',
})
export class LlistaProductes {
  productes = signal<Producte[] | null>(null);
  carregant = signal(false);
  error = signal<HttpErrorResponse | null>(null);

  minPreu?: number;
  maxPreu?: number;

  constructor(private producteService: ProducteService) {}

  ngOnInit(): void {
    this.carregarProductes();
  }

  // Cargar productos
  carregarProductes() {
    this.carregant.set(true);
    this.error.set(null);

    // Service
    this.producteService.getAllProductes().subscribe({
      next: (data) => {
        this.productes.set(data);
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set(err);
        this.carregant.set(false);
        console.log(err);
      }
    })
  }
}
