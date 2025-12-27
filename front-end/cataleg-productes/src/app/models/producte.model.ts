export interface Producte {
    id: number
    nom: string
    preu: number;
    imatgeUrl: string;
    stock: number;
}

export interface ProducteRequest {
    nom: string
    preu: number;
    imatgeUrl: string;
    stock: number;
}
