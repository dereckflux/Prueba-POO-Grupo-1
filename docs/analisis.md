# Análisis — Control inteligente de zonas circulares (Grupo 1)

## 1. Problema

Una institución necesita saber qué parte de un plano está cubierta por sus dispositivos inalámbricos. Cada dispositivo cubre una **zona circular**, definida por un centro (x, y) y un radio. Se requiere registrar zonas, calcular sus medidas, saber si un punto está cubierto (interior, borde o exterior), detectar zonas que se superponen y generar un informe de los puntos cubiertos.

## 2. Entradas

| Dato | Tipo | Validación |
|---|---|---|
| Nombre de zona | `String` | No vacío; no duplicado (sin distinguir mayúsculas ni espacios extra) |
| Centro x, y | `double` | Debe ser numérico; se acepta coma o punto decimal |
| Radio | `double` | Estrictamente positivo (`radio > 0`) |
| Punto a evaluar x, y | `double` | Numérico; en el informe no se repite el mismo punto |
| Opción de menú | `int` | Entero entre 0 y 12 |

## 3. Procesos

1. **Distancia** entre dos puntos: `d = √((x2 − x1)² + (y2 − y1)²)`, en `Punto.distanciaA`.
2. **Área**: `A = π·r²`. **Perímetro**: `P = 2·π·r`, en `Zona`.
3. **Clasificación** de un punto con tolerancia `EPS = 1e-6`:
   - `|d − r| ≤ EPS` → BORDE
   - `d < r` → INTERIOR
   - si no, EXTERIOR
4. **Superposición** de dos zonas, con `d` = distancia entre centros:
   - `d > r1 + r2` → separadas
   - `d = r1 + r2` (con tolerancia) → tangentes (se tocan, sin área común; **no** cuenta como superposición)
   - `d ≤ |r1 − r2|` → una contenida en la otra (superpuestas)
   - en otro caso → se intersecan parcialmente (superpuestas)
5. **Informe de cobertura**: para cada punto registrado se revisan todas las zonas; el punto está cubierto si está en el interior o en el borde de al menos una. Al final se muestra el porcentaje de puntos cubiertos.
6. **Duplicados**: antes de crear una zona, `SistemaZonas.existeZona` busca el nombre con `equalsIgnoreCase` y `trim`.
7. **Mapa visual**: `Consola.dibujarMapa` recorre una cuadrícula de 60 × 24 caracteres; cada casilla se convierte en una coordenada real y se pregunta a cada `Zona` si la cubre (`cubrePunto`).

## 4. Salidas

- Mensajes de confirmación `[OK]`, error `[ERROR]` e información `[i]`, con colores.
- Listado de zonas con centro, radio, área y perímetro.
- Distancias con 4 decimales.
- Clasificación del punto en cada zona y cuántas zonas lo cubren.
- Análisis de superposición por pares y total de pares superpuestos.
- Informe de puntos cubiertos con porcentaje.
- Mapa de cobertura dibujado con caracteres y su leyenda.

## 5. Decisiones de diseño

- **Una responsabilidad por clase:** `Punto` (geometría básica), `Zona` (cálculos del círculo), `SistemaZonas` (reglas sobre el conjunto), `Consola` (cómo se ve) y `Main` (coordinar el menú).
- **Clase `Consola` separada:** toda la parte visual está en una sola clase. Si se quiere cambiar colores o el diseño de los recuadros, no hay que tocar la lógica. Main decide **qué** opciones hay y Consola decide **cómo** se ven.
- **Encapsulamiento:** todos los atributos son `private`; se accede con getters. No hay setters para el radio, así nunca puede quedar un radio inválido. `getZonas()` y `getPuntos()` devuelven copias para que `Consola` no pueda modificar las listas originales.
- **Validación en el constructor de `Zona`:** si el radio es ≤ 0 o el nombre está vacío, se lanza `IllegalArgumentException`; es imposible crear una zona inválida.
- **Manejo de errores:** las clases lanzan excepciones con mensajes claros y `Main` las captura con `try-catch` y las muestra con `Consola.error()`, sin cerrar el programa.
- **Lectura robusta:** se lee la línea completa con `nextLine()` y se convierte con `Double.parseDouble`, reemplazando coma por punto, para evitar errores del `Scanner` según la configuración regional del computador.
- **Compatibilidad visual:** los recuadros usan solo `+ - |` y los colores son códigos ANSI que se pueden desactivar (opción 12).
- **Tangentes no son superposición:** si dos círculos solo se tocan en un punto, no comparten área.
- **Inspiración:** `ch7/circles.java` del repositorio cpbook-code (función `insideCircle`, que devuelve interior/borde/exterior), adaptada con orientación a objetos y tolerancia para números decimales.

