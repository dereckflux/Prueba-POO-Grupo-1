# Documentación técnica — Control inteligente de zonas circulares

**Proyecto:** Prueba-POO-Grupo-1
**Lenguaje:** Java (consola)
**Paradigma:** Programación Orientada a Objetos
**Archivos fuente:** `Punto.java`, `Zona.java`, `SistemaZonas.java`, `Consola.java`, `Main.java`

---

## Índice

1. Descripción general
2. Arquitectura y orden de construcción
3. Archivo `Punto.java`
4. Archivo `Zona.java`
5. Archivo `SistemaZonas.java`
6. Archivo `Consola.java`
7. Archivo `Main.java`
8. Flujo completo de ejecución
9. Diagramas de secuencia (paso a paso de las operaciones principales)
10. Validaciones y manejo de errores
11. Conceptos de POO aplicados
12. Glosario

---

## 1. Descripción general

El sistema determina la cobertura de dispositivos inalámbricos en un plano cartesiano. Cada dispositivo cubre un área circular llamada **zona**, definida por un **centro** (x, y) y un **radio**.

El programa permite:

| Funcionalidad del enunciado | Dónde se implementa |
|---|---|
| Registrar zonas con centro (x,y) y radio estrictamente positivo | `SistemaZonas.registrarZona()` + constructor de `Zona` |
| Calcular distancias, áreas y perímetros | `Punto.distanciaA()`, `Zona.calcularArea()`, `Zona.calcularPerimetro()` |
| Clasificar un punto como interior, borde o exterior con tolerancia | `Zona.clasificarPunto()` con la constante `Zona.EPS` |
| Detectar superposición y generar informe de puntos cubiertos | `SistemaZonas.detectarSuperposiciones()`, `SistemaZonas.generarInformeCobertura()` |
| Impedir nombres duplicados | `SistemaZonas.existeZona()` dentro de `registrarZona()` |
| Menú interactivo (extra: interfaz visual) | `Main` + `Consola` |

---

## 2. Arquitectura y orden de construcción

El sistema se construyó **de abajo hacia arriba**: primero las clases que no dependen de nadie y al final la que coordina todo.

```
 Orden de creación          Depende de
 ─────────────────          ──────────────────────────────
 1. Punto.java              (ninguna)
 2. Zona.java               Punto
 3. SistemaZonas.java       Zona, Punto
 4. Consola.java            Zona, Punto
 5. Main.java               SistemaZonas, Consola, Punto
```

### Responsabilidad de cada clase

| Capa | Clase | Responsabilidad única |
|---|---|---|
| Modelo (datos y cálculo) | `Punto` | Representar una coordenada y medir distancias |
| Modelo (datos y cálculo) | `Zona` | Representar un círculo y hacer sus cálculos geométricos |
| Lógica de negocio | `SistemaZonas` | Administrar la colección de zonas/puntos y aplicar reglas sobre el conjunto |
| Presentación | `Consola` | Mostrar la información en pantalla (formato, color, mapa) |
| Control | `Main` | Leer al usuario y decidir qué objeto realiza cada operación |

### Relaciones

| Relación | Tipo | Significado |
|---|---|---|
| `Zona` → `Punto` | Composición (1 a 1) | Toda zona tiene exactamente un centro; sin centro la zona no existe |
| `SistemaZonas` → `Zona` | Agregación (1 a muchos) | El sistema guarda una lista de zonas |
| `SistemaZonas` → `Punto` | Agregación (1 a muchos) | El sistema guarda una lista de puntos para el informe |
| `Main` → `SistemaZonas` | Asociación (uso) | Main le pide las operaciones del menú |
| `Main` → `Consola` | Asociación (uso) | Main le pide mostrar todo en pantalla |
| `Consola` → `Zona`, `Punto` | Dependencia | Consola los recibe para dibujar el mapa |

Ver diagrama: `docs/diagrama_clases.png`.

---

## 3. Archivo `Punto.java`

### 3.1 Propósito

Se creó la clase `Punto` para representar una ubicación (x, y) en el plano. Es la clase base del sistema: se usa como **centro de cada zona** y como **posición de un dispositivo** que se quiere evaluar.

### 3.2 Por qué se creó primero

Todas las demás operaciones geométricas (clasificar, superponer, informe, mapa) se reducen a **medir distancias entre puntos**. Por eso esta clase debía existir antes que las demás.

### 3.3 Atributos

| Atributo | Tipo | Visibilidad | Descripción |
|---|---|---|---|
| `x` | `double` | `private` | Coordenada horizontal |
| `y` | `double` | `private` | Coordenada vertical |

Son privados para aplicar **encapsulamiento**: ninguna otra clase puede modificarlos después de creado el punto.

### 3.4 Constructor

```java
public Punto(double x, double y)
```

- **Para qué:** crear un punto con sus coordenadas.
- **Quién lo usa:**
  - `Main` → al leer coordenadas del usuario (opciones 3 y 5).
  - `SistemaZonas` → al registrar una zona (crea su centro) y al registrar puntos del informe.
  - `Consola` → crea un punto temporal por cada casilla del mapa.

### 3.5 Métodos

| Método | Retorna | Para qué sirve | Quién lo usa |
|---|---|---|---|
| `getX()` | `double` | Leer la coordenada x | `Consola.dibujarMapa()` |
| `getY()` | `double` | Leer la coordenada y | `Consola.dibujarMapa()` |
| `distanciaA(Punto otro)` | `double` | Calcular la distancia euclidiana a otro punto | `Zona`, `SistemaZonas`, `Main` |
| `toString()` | `String` | Mostrar el punto como `(5, 2)` | Cualquier impresión del punto |
| `formatear(double)` *(privado)* | `String` | Mostrar `5` en vez de `5.00` si el valor es entero | Solo `toString()` |

### 3.6 Detalle del método principal: `distanciaA`

```java
public double distanciaA(Punto otro) {
    if (otro == null) {
        throw new IllegalArgumentException("El punto de comparación no puede ser nulo.");
    }
    double dx = otro.x - this.x;
    double dy = otro.y - this.y;
    return Math.sqrt(dx * dx + dy * dy);
}
```

**Funcionamiento paso a paso:**

1. Valida que el otro punto exista (evita `NullPointerException`).
2. Calcula la diferencia horizontal `dx` y vertical `dy`.
3. Aplica el teorema de Pitágoras: `d = √(dx² + dy²)`.

**Ejemplo:** de (0,0) a (3,4) → `dx = 3`, `dy = 4`, `d = √(9 + 16) = 5`.

---

## 4. Archivo `Zona.java`

### 4.1 Propósito

Se creó la clase `Zona` para representar el **área circular de cobertura** de un dispositivo. Contiene todos los cálculos que pertenecen a un círculo individual: área, perímetro, clasificación de un punto y relación con otra zona.

### 4.2 Constantes

| Constante | Valor | Para qué sirve |
|---|---|---|
| `EPS` | `1e-6` (0.000001) | Tolerancia numérica para comparar decimales |
| `INTERIOR` | `"INTERIOR"` | Resultado de clasificación |
| `BORDE` | `"BORDE"` | Resultado de clasificación |
| `EXTERIOR` | `"EXTERIOR"` | Resultado de clasificación |

**¿Por qué existe `EPS`?** En Java los `double` tienen errores de redondeo (por ejemplo `0.1 + 0.2 = 0.30000000000000004`). Si se compara `distancia == radio` directamente, un punto que matemáticamente está en el borde podría clasificarse mal. Con `EPS` se considera borde cuando la diferencia es prácticamente cero: `|distancia − radio| ≤ 0.000001`.

**¿Por qué son `public static final`?** `static` porque son iguales para todas las zonas; `final` porque no cambian; `public` porque `SistemaZonas` también las usa.

### 4.3 Atributos

| Atributo | Tipo | Visibilidad | Descripción | Regla |
|---|---|---|---|---|
| `nombre` | `String` | `private` | Identificador de la zona | No vacío; único (controlado por `SistemaZonas`) |
| `centro` | `Punto` | `private` | Centro del círculo | No nulo |
| `radio` | `double` | `private` | Radio del círculo | Estrictamente mayor que 0 |

### 4.4 Constructor con validaciones

```java
public Zona(String nombre, Punto centro, double radio) {
    if (nombre == null || nombre.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre de la zona no puede estar vacío.");
    }
    if (centro == null) {
        throw new IllegalArgumentException("La zona debe tener un centro.");
    }
    if (radio <= 0) {
        throw new IllegalArgumentException("El radio debe ser estrictamente positivo (radio > 0).");
    }
    this.nombre = nombre.trim();
    this.centro = centro;
    this.radio = radio;
}
```

- **Para qué:** crear una zona **solo si sus datos son válidos**.
- **Decisión de diseño:** la validación está en el constructor para que sea **imposible** que exista un objeto `Zona` con radio inválido. Si los datos están mal, se lanza la excepción y el objeto nunca se crea.
- **Quién lo usa:** `SistemaZonas.registrarZona()`.
- **Nota:** la clase no tiene *setters*; una vez creada la zona, su radio no se puede cambiar a un valor inválido.

### 4.5 Métodos

| Método | Retorna | Para qué sirve | Quién lo usa |
|---|---|---|---|
| `getNombre()` | `String` | Leer el nombre | `SistemaZonas`, `Consola` |
| `getCentro()` | `Punto` | Leer el centro | `SistemaZonas`, `Consola` |
| `getRadio()` | `double` | Leer el radio | `SistemaZonas`, `Consola` |
| `calcularArea()` | `double` | Área: `π · r²` | `toString()` → `listarZonas()` |
| `calcularPerimetro()` | `double` | Perímetro: `2 · π · r` | `toString()` → `listarZonas()` |
| `distanciaAlCentro(Punto p)` | `double` | Distancia de un punto al centro | `clasificarPunto()`, `SistemaZonas` |
| `clasificarPunto(Punto p)` | `String` | Devuelve INTERIOR, BORDE o EXTERIOR | `SistemaZonas`, `cubrePunto()` |
| `cubrePunto(Punto p)` | `boolean` | `true` si el punto está en interior o borde | `SistemaZonas` (informe), `Consola` (mapa) |
| `seSuperponeCon(Zona otra)` | `boolean` | `true` si dos zonas comparten área | `SistemaZonas.detectarSuperposiciones()` |
| `relacionCon(Zona otra)` | `String` | Describe la relación: separadas, tangentes, contenida o intersecadas | `SistemaZonas.detectarSuperposiciones()` |
| `toString()` | `String` | Una línea con nombre, centro, radio, área y perímetro | `SistemaZonas.listarZonas()` |

### 4.6 Detalle: `clasificarPunto`

```java
public String clasificarPunto(Punto p) {
    double d = distanciaAlCentro(p);
    if (Math.abs(d - radio) <= EPS) {
        return BORDE;
    } else if (d < radio) {
        return INTERIOR;
    } else {
        return EXTERIOR;
    }
}
```

**Paso a paso:**

1. Calcula `d`, la distancia del punto al centro (usa `Punto.distanciaA()`).
2. **Primero** pregunta si está en el borde. Va primero porque, si se preguntara antes `d < radio`, un punto a 6.9999999 de un radio 7 saldría INTERIOR en vez de BORDE.
3. Si no es borde y `d < radio` → INTERIOR.
4. En otro caso → EXTERIOR.

**Tabla de ejemplos (zona Z1, centro (0,0), radio 7):**

| Punto | Distancia | Resultado |
|---|---|---|
| (5, 2) | 5.3852 | INTERIOR |
| (7, 0) | 7.0000 | BORDE |
| (6.9999999, 0) | 6.9999999 | BORDE (diferencia 0.0000001 ≤ EPS) |
| (7.1, 0) | 7.1000 | EXTERIOR |

### 4.7 Detalle: `seSuperponeCon` y `relacionCon`

Sea `d` la distancia entre centros, `r1` y `r2` los radios:

| Condición | Relación | ¿Superposición? |
|---|---|---|
| `d > r1 + r2` | Separadas | No |
| `d = r1 + r2` (con tolerancia) | Tangentes (se tocan en un punto) | No, no comparten área |
| `d ≤ |r1 − r2|` | Una contenida en la otra | Sí |
| En otro caso | Se intersecan parcialmente | Sí |

```java
public boolean seSuperponeCon(Zona otra) {
    double d = centro.distanciaA(otra.centro);
    return d < (this.radio + otra.radio) - EPS;
}
```

**Ejemplo:** Z1 (0,0) r=7 y Z2 (10,0) r=6 → `d = 10`, `r1 + r2 = 13`, `10 < 13` → se superponen.

---

## 5. Archivo `SistemaZonas.java`

### 5.1 Propósito

Se creó la clase `SistemaZonas` como **administrador** del programa. Guarda todas las zonas y puntos registrados, y aplica las reglas de negocio que involucran **varias zonas a la vez**: duplicados, clasificación global, superposición e informe.

**Principio importante:** esta clase **no hace cálculos geométricos por sí misma**; se los **pide** a `Zona` y `Punto`. Eso es la integración (comunicación entre objetos).

### 5.2 Atributos

| Atributo | Tipo | Visibilidad | Descripción |
|---|---|---|---|
| `zonas` | `ArrayList<Zona>` | `private` | Lista de zonas registradas |
| `puntos` | `ArrayList<Punto>` | `private` | Lista de puntos para el informe de cobertura |

Se usó `ArrayList` porque la cantidad de registros es variable (el usuario puede agregar o eliminar zonas en cualquier momento).

### 5.3 Constructor

```java
public SistemaZonas() {
    zonas = new ArrayList<>();
    puntos = new ArrayList<>();
}
```

Inicia el sistema con las dos listas vacías. Lo llama `Main` una sola vez al arrancar.

### 5.4 Métodos

#### Consulta

| Método | Retorna | Para qué sirve | Quién lo usa |
|---|---|---|---|
| `getZonas()` | `ArrayList<Zona>` | Devuelve una **copia** de la lista de zonas | `Main` → `Consola.dibujarMapa()` |
| `getPuntos()` | `ArrayList<Punto>` | Devuelve una **copia** de la lista de puntos | `Main` → `Consola.dibujarMapa()` |
| `cantidadZonas()` | `int` | Número de zonas registradas | Disponible para consultas |
| `buscarZona(String)` | `Zona` o `null` | Encontrar una zona por nombre (ignora mayúsculas y espacios) | `existeZona`, `eliminarZona`, `distanciaEntreZonas` |
| `existeZona(String)` | `boolean` | Saber si un nombre ya está usado | `registrarZona`, `Main.cargarCasoReferencia` |

> Las copias en `getZonas()` y `getPuntos()` protegen el encapsulamiento: `Consola` puede leer las listas, pero si agrega o borra elementos, la lista original no cambia.

#### Gestión de zonas

| Método | Para qué sirve | Validaciones |
|---|---|---|
| `registrarZona(nombre, x, y, radio)` | Crear y guardar una zona | Nombre duplicado (aquí) + radio y nombre vacío (constructor de `Zona`) |
| `eliminarZona(nombre)` | Quitar una zona | La zona debe existir |
| `listarZonas()` | Texto con todas las zonas, su área y perímetro | Lista vacía → mensaje |
| `distanciaEntreZonas(a, b)` | Distancia entre los centros de dos zonas | Ambas zonas deben existir |

```java
public void registrarZona(String nombre, double x, double y, double radio) {
    if (existeZona(nombre)) {
        throw new IllegalArgumentException("Ya existe una zona llamada \"" + nombre.trim()
                + "\". No se permiten duplicados.");
    }
    Zona nueva = new Zona(nombre, new Punto(x, y), radio);
    zonas.add(nueva);
}
```

**Paso a paso:**

1. Verifica que el nombre no exista. Si existe, lanza error.
2. Crea el centro con `new Punto(x, y)`.
3. Crea la zona con `new Zona(...)`; el constructor valida el radio.
4. Si todo es válido, la agrega a la lista.

#### Análisis

| Método | Para qué sirve | Métodos de otras clases que usa |
|---|---|---|
| `clasificarPuntoEnZonas(Punto p)` | Clasifica un punto en todas las zonas y cuenta cuántas lo cubren | `Zona.clasificarPunto`, `Zona.distanciaAlCentro` |
| `detectarSuperposiciones()` | Revisa cada par de zonas y reporta cuáles se superponen | `Zona.seSuperponeCon`, `Zona.relacionCon`, `Punto.distanciaA` |
| `registrarPunto(x, y)` | Guarda un punto para el informe (sin repetir) | `Punto.distanciaA`, `Zona.EPS` |
| `generarInformeCobertura()` | Por cada punto, qué zonas lo cubren y el porcentaje total | `Zona.cubrePunto`, `Zona.clasificarPunto` |

**Detalle de `detectarSuperposiciones`:**

```java
for (int i = 0; i < zonas.size(); i++) {
    for (int j = i + 1; j < zonas.size(); j++) {
        Zona a = zonas.get(i);
        Zona b = zonas.get(j);
        ...
        if (a.seSuperponeCon(b)) {
            total++;
        }
    }
}
```

El segundo ciclo empieza en `j = i + 1` para:
- no comparar una zona consigo misma (`i = j`);
- no repetir pares (si ya se comparó Z1–Z2, no se compara Z2–Z1).

Con 3 zonas se revisan los pares: (Z1,Z2), (Z1,Z3), (Z2,Z3).

**Detalle de `generarInformeCobertura`:**

1. Recorre cada punto registrado.
2. Para cada punto, recorre todas las zonas y pregunta `cubrePunto()`.
3. Si al menos una zona lo cubre → "CUBIERTO por: ..."; si ninguna → "SIN COBERTURA".
4. Al final calcula: `porcentaje = 100 × cubiertos / total de puntos`.

---

## 6. Archivo `Consola.java`

### 6.1 Propósito

Se creó la clase `Consola` para concentrar **toda la presentación visual** del programa. Así `Main` no se llena de `System.out.println` con formato, y si se quiere cambiar el diseño solo se modifica esta clase, sin tocar la lógica.

**División de responsabilidades:** `Main` decide **qué** se muestra; `Consola` decide **cómo** se ve.

### 6.2 Constantes

| Constante | Uso |
|---|---|
| `RESET`, `ROJO`, `VERDE`, `AMARILLO`, `AZUL`, `CIAN`, `NEGRITA` | Códigos de color ANSI para la terminal |
| `ANCHO = 64` | Ancho fijo de los recuadros |

### 6.3 Atributo

| Atributo | Tipo | Descripción |
|---|---|---|
| `usarColores` | `boolean` | Indica si se imprimen colores. Se puede apagar si la terminal no los soporta |

### 6.4 Constructor

```java
public Consola(boolean usarColores)
```

Lo llama `Main` al iniciar: `new Consola(true)`.

### 6.5 Métodos públicos

| Método | Para qué sirve | Quién lo usa |
|---|---|---|
| `mostrarBienvenida()` | Portada del programa | `Main` al iniciar |
| `mostrarMenu(titulo, opciones[])` | Dibuja el menú dentro de un recuadro | `Main` en cada vuelta del ciclo |
| `mostrarResultado(titulo, contenido)` | Muestra un resultado multilínea en recuadro; resalta INTERIOR (verde), BORDE (amarillo), EXTERIOR (rojo) | `Main` con los textos de `SistemaZonas` |
| `exito(mensaje)` | Mensaje `[OK]` en verde | `Main` tras operaciones correctas |
| `error(mensaje)` | Mensaje `[ERROR]` en rojo | `Main` en el `catch` y en lecturas inválidas |
| `info(mensaje)` | Mensaje `[i]` en amarillo | `Main` (salir, colores) |
| `pedir(mensaje)` | Muestra `> ` antes de pedir un dato | Métodos de lectura de `Main` |
| `separador()` | Línea divisoria entre operaciones | `Main` al final de cada vuelta |
| `alternarColores()` | Prende/apaga los colores | `Main` opción 12 |
| `isUsarColores()` | Consulta el estado de los colores | `Main` opción 12 |
| `dibujarMapa(zonas, puntos)` | Dibuja el mapa de cobertura con caracteres | `Main` opción 11 |

### 6.6 Métodos privados (auxiliares)

| Método | Para qué sirve |
|---|---|
| `color(codigo, texto)` | Pinta un texto solo si los colores están activos |
| `repetir(char, n)` | Genera líneas de los recuadros (`-----`) |
| `rellenar(texto, largo)` | Completa con espacios para alinear el borde derecho |
| `resaltar(linea)` | Colorea palabras clave dentro de los resultados |
| `caracterCelda(...)` | Decide qué carácter va en cada casilla del mapa |
| `letraZona(indice)` | Convierte 0 → A, 1 → B, etc. |

### 6.7 Detalle: `dibujarMapa`

**Paso a paso:**

1. **Calcula los límites del plano:** recorre las zonas y toma el mínimo y máximo de `centro ± radio`, y también incluye los puntos registrados.
2. **Define la cuadrícula:** 60 columnas × 24 filas. Calcula cuánto mide cada casilla en unidades reales (`pasoX`, `pasoY`).
3. **Recorre fila por fila** (de arriba hacia abajo, por eso `y` empieza en el máximo).
4. **Para cada casilla** convierte la posición en una coordenada real (x, y) y llama a `caracterCelda()`:
   - Si hay un punto registrado en esa casilla → `*`
   - Si ninguna zona la cubre → `.`
   - Si una sola zona la cubre → la letra de esa zona (`A`, `B`, ...)
   - Si dos o más zonas la cubren → `#` (superposición)
5. **Imprime la leyenda** con la letra de cada zona.

Para saber si una casilla está cubierta, se reutiliza `Zona.cubrePunto()`: la presentación usa la misma lógica del modelo, sin duplicar cálculos.

---

## 7. Archivo `Main.java`

### 7.1 Propósito

Se creó la clase `Main` como **punto de entrada** del programa. Su única responsabilidad es **coordinar**: mostrar el menú, leer lo que el usuario escribe y delegar cada operación al objeto correspondiente. No contiene cálculos ni reglas de negocio (requisito del "desafío de integración").

### 7.2 Atributos estáticos

| Atributo | Tipo | Para qué sirve |
|---|---|---|
| `sc` | `Scanner` | Leer datos del teclado |
| `consola` | `Consola` | Mostrar todo en pantalla |
| `OPCIONES` | `String[]` | Textos del menú (se pasan a `Consola.mostrarMenu`) |

Son `static` porque los usan los métodos `static` de lectura.

### 7.3 Método `main`: estructura

```java
SistemaZonas sistema = new SistemaZonas();   // 1. crear el administrador
consola.mostrarBienvenida();                 // 2. portada
do {                                         // 3. ciclo del menú
    consola.mostrarMenu("MENU PRINCIPAL", OPCIONES);
    opcion = leerEntero("Seleccione una opcion: ");
    try {
        switch (opcion) { ... }              // 4. delegar según la opción
    } catch (IllegalArgumentException | IllegalStateException e) {
        consola.error(e.getMessage());       // 5. mostrar errores sin cerrar
    }
    consola.separador();
} while (opcion != 0);                       // 6. repetir hasta salir
```

### 7.4 Tabla de opciones del menú

| Opción | Qué hace Main | Objeto que realiza el trabajo |
|---|---|---|
| 1 | Lee nombre, x, y, radio | `sistema.registrarZona()` |
| 2 | Muestra el listado | `sistema.listarZonas()` → `consola.mostrarResultado()` |
| 3 | Lee dos puntos | `p1.distanciaA(p2)` |
| 4 | Lee dos nombres | `sistema.distanciaEntreZonas()` |
| 5 | Lee un punto | `sistema.clasificarPuntoEnZonas()` |
| 6 | — | `sistema.detectarSuperposiciones()` |
| 7 | Lee un punto | `sistema.registrarPunto()` |
| 8 | — | `sistema.generarInformeCobertura()` |
| 9 | Lee un nombre | `sistema.eliminarZona()` |
| 10 | — | `cargarCasoReferencia()` |
| 11 | — | `consola.dibujarMapa(sistema.getZonas(), sistema.getPuntos())` |
| 12 | — | `consola.alternarColores()` |
| 0 | Termina el ciclo | — |
| Otro | Mensaje de error | `consola.error()` |

### 7.5 Métodos auxiliares

| Método | Para qué sirve | Validación |
|---|---|---|
| `leerTexto(mensaje)` | Leer un texto | Repite mientras esté vacío |
| `leerDouble(mensaje)` | Leer un número decimal | Repite si no es número; acepta coma o punto (`2,5` o `2.5`) |
| `leerEntero(mensaje)` | Leer la opción del menú | Repite si no es entero |
| `cargarCasoReferencia(sistema)` | Carga Z1 (0,0) r=7 y Z2 (10,0) r=6, y clasifica (5,2) | No vuelve a crear las zonas si ya existen |

**¿Por qué `nextLine()` + `Double.parseDouble` en vez de `nextDouble()`?**
`nextDouble()` depende de la configuración regional del computador (en español espera coma decimal) y deja saltos de línea pendientes que causan errores en la siguiente lectura. Leer la línea completa y convertirla evita ambos problemas.

---

## 8. Flujo completo de ejecución

```
INICIO
  │
  ├─ Main crea SistemaZonas (listas vacías)
  ├─ Consola muestra la portada
  │
  └─ CICLO do-while
        ├─ Consola dibuja el menú
        ├─ Main lee la opción (leerEntero valida)
        ├─ switch → delega en SistemaZonas / Zona / Punto / Consola
        ├─ Si hay error → catch → Consola.error()
        ├─ Consola.separador()
        └─ ¿opción == 0? ── No → repetir
                          └─ Sí → FIN
```

---

## 9. Diagramas de secuencia (paso a paso)

### 9.1 Registrar una zona válida (opción 1)

Entrada: nombre `Z1`, centro `(0,0)`, radio `7`.

```
Usuario → Main:         escribe 1, Z1, 0, 0, 7
Main → SistemaZonas:    registrarZona("Z1", 0, 0, 7)
SistemaZonas:           existeZona("Z1") → false
SistemaZonas → Punto:   new Punto(0, 0)
SistemaZonas → Zona:    new Zona("Z1", centro, 7)   → radio válido
SistemaZonas:           zonas.add(zona)
Main → Consola:         exito("Zona \"Z1\" registrada correctamente.")
```

### 9.2 Registrar una zona con radio inválido

Entrada: nombre `Z3`, centro `(0,0)`, radio `-5`.

```
Main → SistemaZonas:    registrarZona("Z3", 0, 0, -5)
SistemaZonas → Zona:    new Zona("Z3", centro, -5)
Zona:                   radio <= 0 → lanza IllegalArgumentException
  (la excepción sube por SistemaZonas hasta Main)
Main (catch) → Consola: error("El radio debe ser estrictamente positivo (radio > 0).")
```

La zona **no se crea** y el programa **continúa**.

### 9.3 Clasificar un punto (opción 5)

Entrada: punto `(5,2)` con Z1 y Z2 registradas.

```
Main → Punto:           new Punto(5, 2)
Main → SistemaZonas:    clasificarPuntoEnZonas(p)
  para Z1:
    SistemaZonas → Zona:   clasificarPunto(p)
    Zona → Punto:          centro.distanciaA(p) = 5.3852
    Zona:                  5.3852 < 7 → INTERIOR
  para Z2:
    Zona → Punto:          distanciaA = 5.3852
    Zona:                  5.3852 < 6 → INTERIOR
SistemaZonas → Main:    texto con el resultado (cubierto por 2 de 2)
Main → Consola:         mostrarResultado("Clasificacion del punto", texto)
```

### 9.4 Mapa de cobertura (opción 11)

```
Main → SistemaZonas:    getZonas(), getPuntos()   (copias)
Main → Consola:         dibujarMapa(zonas, puntos)
  por cada casilla (60 × 24):
    Consola → Punto:    new Punto(x, y)
    Consola → Zona:     cubrePunto(celda) en cada zona
    Consola:            elige . / letra / # / *
Consola:                imprime mapa y leyenda
```

---

## 10. Validaciones y manejo de errores

| Validación | Dónde | Mecanismo | Mensaje |
|---|---|---|---|
| Radio ≤ 0 | Constructor de `Zona` | `IllegalArgumentException` | El radio debe ser estrictamente positivo |
| Nombre vacío | Constructor de `Zona` y `Main.leerTexto` | Excepción / repetir lectura | El nombre no puede estar vacío |
| Nombre duplicado | `SistemaZonas.registrarZona` | `IllegalArgumentException` | Ya existe una zona llamada... |
| Zona inexistente | `eliminarZona`, `distanciaEntreZonas` | `IllegalArgumentException` | No existe la zona... |
| Punto repetido | `SistemaZonas.registrarPunto` | `IllegalArgumentException` | El punto ya está registrado |
| Sin zonas para analizar | `clasificarPuntoEnZonas`, `generarInformeCobertura` | `IllegalStateException` | No hay zonas registradas |
| Menos de 2 zonas para superposición | `detectarSuperposiciones` | `IllegalStateException` | Se necesitan al menos 2 zonas |
| Texto donde va un número | `Main.leerDouble`, `leerEntero` | `try-catch NumberFormatException` + repetir | Valor inválido |
| Opción fuera de rango | `switch` → `default` | Mensaje | Opción inválida |

**Estrategia general:** las clases del modelo **detectan** el error y lanzan una excepción con un mensaje claro; `Main` la **atrapa** y `Consola` la **muestra**. Ningún error cierra el programa.

**Diferencia entre las excepciones usadas:**
- `IllegalArgumentException`: el dato recibido es inválido (radio negativo, nombre repetido).
- `IllegalStateException`: el dato está bien, pero el sistema no está en condiciones de hacer la operación (no hay zonas todavía).

---

## 11. Conceptos de POO aplicados

| Concepto | Dónde se ve en el código |
|---|---|
| **Clase** | `Punto`, `Zona`, `SistemaZonas`, `Consola`, `Main` |
| **Objeto / instancia** | `new SistemaZonas()`, `new Zona(...)`, `new Punto(...)`, `new Consola(true)` |
| **Atributos** | `x`, `y`, `nombre`, `centro`, `radio`, `zonas`, `puntos`, `usarColores` |
| **Constructor** | Uno por clase; el de `Zona` además valida |
| **Encapsulamiento** | Todos los atributos `private`; acceso con getters; `Zona` sin setters; listas devueltas como copias |
| **Métodos de negocio** | `distanciaA`, `calcularArea`, `calcularPerimetro`, `clasificarPunto`, `seSuperponeCon`, `registrarZona`, `detectarSuperposiciones`, `generarInformeCobertura`, entre otros |
| **Composición** | `Zona` contiene un `Punto` (centro) |
| **Agregación** | `SistemaZonas` contiene listas de `Zona` y `Punto` |
| **Constantes de clase** | `Zona.EPS`, `Zona.INTERIOR`, etc. (`static final`) |
| **Sobrescritura** | `toString()` en `Punto` y `Zona` (`@Override`) |
| **Manejo de excepciones** | `throw` en el modelo, `try-catch` en `Main` |
| **Estructuras de control** | `do-while` (menú), `switch` (opciones), `for` / `for-each` (recorridos), `if-else` (validaciones) |
| **Colecciones** | `ArrayList<Zona>`, `ArrayList<Punto>` |

---

## 12. Glosario

| Término | Significado en este proyecto |
|---|---|
| **Zona** | Círculo que representa el alcance de un dispositivo inalámbrico |
| **Centro** | Punto (x, y) donde está el dispositivo |
| **Radio** | Alcance del dispositivo; siempre mayor que 0 |
| **Interior** | El punto está dentro del círculo (distancia < radio) |
| **Borde** | El punto está sobre la circunferencia (distancia ≈ radio) |
| **Exterior** | El punto está fuera del círculo (distancia > radio) |
| **EPS / tolerancia** | Margen de 0.000001 para comparar decimales sin errores de redondeo |
| **Superposición** | Dos zonas comparten área (distancia entre centros < suma de radios) |
| **Tangentes** | Dos zonas se tocan en un solo punto, sin compartir área |
| **Cobertura** | Un punto está cubierto si está en el interior o borde de al menos una zona |
| **ANSI** | Códigos especiales que la terminal interpreta como colores |
