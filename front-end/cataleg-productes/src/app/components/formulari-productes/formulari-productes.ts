import { HttpErrorResponse } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { ProducteService } from '../../services/producte.service';
import { ProducteRequest } from '../../models';

@Component({
  selector: 'app-formulari-productes',
  imports: [],
  templateUrl: './formulari-productes.html',
  styleUrl: './formulari-productes.css',
})
export class FormulariProductes {
  carregant = signal(false);
  error = signal<HttpErrorResponse | null>(null);

  // datos del formulario
  nom: string = '';
  preu?: number;
  stock?: number;
  imatgeUrl?: string;

  constructor(private producteService: ProducteService) {}

  // Añadir productos
  afegirProducte(form: any) {
    this.carregant.set(true);
    this.error.set(null);

    // Request
    const request: ProducteRequest = {nom: this.nom, preu: this.preu!, imatgeUrl: this.imatgeUrl, stock: this.stock!}

    // Service
    this.producteService.createProducte(request).subscribe({
      next: (data) => {
        this.carregant.set(false);
      },

      error: (err) => {
        this.error.set(err);
        this.carregant.set(false);
        console.log(err);
      }
    })

    form.resetForm()
  }

  // Recargar página
  reload() {
    window.location.reload()
  }
}
