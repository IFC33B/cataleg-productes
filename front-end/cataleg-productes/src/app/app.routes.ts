import { Routes } from '@angular/router';
import { LlistaProductes } from './components/llista-productes/llista-productes';

export const routes: Routes = [
    { path: '', redirectTo: '/productes', pathMatch: 'full' },
    { path: 'productes', component: LlistaProductes },
    // { path: 'formulari', component: FormulariProductes }
];
