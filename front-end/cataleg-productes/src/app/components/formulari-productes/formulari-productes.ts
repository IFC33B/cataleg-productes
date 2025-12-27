import { HttpErrorResponse } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { ProducteService } from '../../services/producte.service';
import { ProducteRequest } from '../../models';
import { FormControl, FormGroup, FormsModule, Validators, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulari-productes',
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './formulari-productes.html',
  styleUrl: './formulari-productes.css',
})
export class FormulariProductes {
  carregant = signal(false);
  error = signal<HttpErrorResponse | null>(null);

  // Formulario reactivo
  producteForm!: FormGroup;

  constructor(private producteService: ProducteService) { }

  ngOnInit(): void {
    this.producteForm = new FormGroup({
      nom: new FormControl('', [Validators.required, Validators.minLength(4)]),
      preu: new FormControl(null, [Validators.required, Validators.min(0.01)]),
      stock: new FormControl(null, [Validators.required, Validators.min(0)]),
      imatgeUrl: new FormControl('')
    })
  }

  // Añadir productos
  afegirProducte() {
    this.carregant.set(true);
    this.error.set(null);

    if (this.producteForm.valid) {
      // Service
      this.producteService.createProducte(this.producteForm.value).subscribe({
        next: (data) => {
          this.carregant.set(false);
          this.producteForm.reset()
        },
  
        error: (err) => {
          this.error.set(err);
          this.carregant.set(false);
          console.log(err);
        }
      })
    } else {
      alert("Datos inválidos")
    }
  }

  // Recargar página
  reload() {
    window.location.reload()
  }
}
