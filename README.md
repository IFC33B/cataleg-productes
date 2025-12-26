# Catálogo de productos

Aplicación que simula un catálogo de productos con backend en Spring Boot y frontend en Angular.

## Requisitos

- Java 21
- Maven
- Node.js 18+ (para el frontend)
- npm

## Estructura de Carpetas

### Backend (Spring Boot)
- `back-end/cataleg-productes/` - Aplicación Spring Boot
  - `src/main/java/ifc33b/dwesc/cataleg_productes/` - Código fuente Java
    - `controller` - Controladores
    - `dto` - Modelos de transferencia entre front y back
    - `model` - Modelos Java
    - `repository` - JPA
    - `service` - Lógica de negocio
  - `src/main/resources/` - Recursos de la aplicación
  - `src/test/` - Tests unitarios
  - `pom.xml` - Dependencias Maven

### Frontend (Angular)
- `front-end/cataleg-productes/` - Aplicación Angular
  - `src/app/` - Código Angular
    - `components/` - Componentes reutilizables
    - `models/` - Modelos TypeScript
    - `services/` - Servicios (comunicación con backend)
  - `src/` - Assets y configuración
  - `package.json` - Dependencias npm

## Instalación

### Backend

1. Acceder a la carpeta del backend:
```bash
cd back-end/cataleg-productes
```

2. Compilar y ejecutar:
```bash
mvn spring-boot:run
```

El servidor estará disponible en `http://localhost:8080`

### Frontend

1. Acceder a la carpeta del frontend:
```bash
cd front-end/cataleg-productes
```

2. Instalar dependencias:
```bash
npm install
```

3. Ejecutar servidor de desarrollo:
```bash
npm start
```

La aplicación estará disponible en `http://localhost:4200`

## Desarrollo

### Backend

El backend está construido con:
- **Spring Boot 3.x** - Framework web
- **Spring Data JPA** - Acceso a datos
- **Maven** - Gestor de dependencias

### Frontend

El frontend está construido con:
- **Angular 18+** - Framework de desarrollo
- **TypeScript** - Lenguaje de programación
- **SCSS** - Estilos
- **npm** - Gestor de dependencias

## Endpoints API

La API está disponible en `http://localhost:8080/api/productes`

### Tabla Resumen de Endpoints

| Método | Ruta | Descripción | Status |
|--------|------|-------------|--------|
| GET | `/api/productes?minPreu=x&maxPreu=x` | Obtener todos los productos, con filtro por precios opcional | 200 |
| POST | `/api/productes` | Crear un nuevo producto | 201 |

### 1. Obtener todos los productos

**GET** `/api/productes`

Devuelve la lista de todos los productos

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "imatgeUrl": "https://....",
    "nom": "Producto1",
    "preu": 4.5,
    "stock": 2
  }
  {
    "id": 2,
    "imatgeUrl": "https://....",
    "nom": "Producto2",
    "preu": 6.5,
    "stock": 4
  }
]
```

***Posibilidades de filtros de precios***

**GET** `/api/productes?minPreu=5`
**GET** `/api/productes?maxPreu=7`
**GET** `/api/productes?minPreu=5&maxPreu=7`

---

### 2. Crear un nuevo producto

**POST** `/api/productes`

Crea un nuevo producto.

**Headers:**
```
Content-Type: application/json
```

**Request Body:**
```json
{
"nom": "Producto1",
"preu": 4.5,
"imatgeUrl": "https://....",
"stock": 2
}
```

**Parámetros requeridos:**
- `nombre` (string, obligatorio): Nombre del producto
- `preu` (double, obligatorio): Precios del producto, este debe ser un número positivo
- `imatgeUrl` (string, opcional): Enlace disponible de una imagen del producto
- `stock` (integer, obligatorio): Cantidad del stock del producto, este debe ser un número positivo o 0

**Response (201 Created):**
```json
{
"id": 1,
"imatgeUrl": "https://....",
"nom": "Producto1",
"preu": 4.5,
"stock": 2
}
```

---

## Ejemplos de uso

### Con cURL

**Crear productos:**
```bash
curl -v -X POST "http://localhost:8080/api/productes"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"nom": "Producte1", "preu": 2.50, "stock": 2}'
```

```bash
curl -v -X POST "http://localhost:8080/api/productes"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"nom": "Producte2", "preu": 4.50, "stock": 2}'
```

```bash
curl -v -X POST "http://localhost:8080/api/productes"   -H "Content-Type: application/json; charset=UTF-8"   --data-raw '{"nom": "Producte3", "preu": 6.50, "stock": 2}'
```

**Obtener productos**

- Obtener todos los productos
```bash
curl -X GET "http://localhost:8080/api/productes"
```

- Obtener el producto2 por el precio
```bash
curl -X GET "http://localhost:8080/api/productes?minPreu=4&maxPreu=6"
```

## Estructura del Proyecto

```
cataleg-productes/
├── README.md
├── back-end/
│   └── cataleg-productes/
│       ├── mvnw
│       ├── mvnw.cmd
│       ├── pom.xml
│       ├── src/
│       │   ├── main/
│       │   │   ├── java/ifc33b/dwesc/cataleg_productes/
│       │   │   │   ├── CatalegProductesApplication.java
│       │   │   │   ├── controller/
│       │   │   │   │   └── CatalegController.java
│       │   │   │   ├── dto/
│       │   │   │   │   ├── ProducteRequest.java
│       │   │   │   │   └── ProducteResponse.java
│       │   │   │   ├── model/
│       │   │   │   │   └── Producte.java
│       │   │   │   ├── repository/
│       │   │   │   │   └──   ProducteRepository.java
│       │   │   │   └── service/
│       │   │   │       └──  CatalegService.java
│       │   │   └── resources/
│       │   │       └── application.properties
│       │   └── test/
│       │       └── java/ifc33b/dwesc/cataleg_productes/
│       │           └── CatalegProductesApplication.java
│       └── target/ (generado por Maven)
└── front-end/
    └── cataleg-productes/
        ├── angular.json
        ├── package.json
        ├── tsconfig.json
        ├── tsconfig.app.json
        ├── tsconfig.spec.json
        ├── README.md
        ├── public/
        ├── src/
        │   ├── index.html
        │   ├── main.ts
        │   ├── styles.scss
        │   └── app/
        │       ├── app.config.ts
        │       ├── app.html
        │       ├── app.routes.ts
        │       ├── app.scss
        │       ├── app.ts
        │       ├── app.spec.ts
        │       ├── components/
        │       │   ├── formulari-productes/
        │       │   │   ├── formulari-producte.html
        │       │   │   ├── formulari-producte.scss
        │       │   │   ├── formulari-producte.ts
        │       │   │   └── formulari-producte.spec.ts
        │       │   └── llista-productes/
        │       │       ├── llista-producte.html
        │       │       ├── llista-producte.scss
        │       │       ├── llista-producte.ts
        │       │       └── llista-producte.spec.ts
        │       ├── models/
        │       │   ├── index.ts
        │       │   ├── producte.model.ts
        │       │   └── producte.model.spec.ts
        │       └── services/
        │           ├── cataleg.service.ts
        │           └── cataleg.service.spec.ts
```