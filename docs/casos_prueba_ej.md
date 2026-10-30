# Casos de prueba

Resultados reales obtenidos al ejecutar la opción 8 del menú (clase `Pruebas`).

```text
Prueba 1: Caso de referencia del enunciado
  Entrada:   Z1 (0,0) r=7; Z2 (10,0) r=6; punto (5,2)
  Esperado:  INTERIOR/INTERIOR, cubren=2, superposiciones=1
  Obtenido:  INTERIOR/INTERIOR, cubren=2, superposiciones=1
  Resultado: APROBADA

Prueba 2: Radio no positivo
  Entrada:   Zona con radio 0 y zona con radio -3
  Esperado:  Rechazada/Rechazada
  Obtenido:  Rechazada/Rechazada
  Resultado: APROBADA

Prueba 3: Nombre duplicado (ignora mayusculas y espacios)
  Entrada:   Registrar 'Z1' y luego '  z1 '
  Esperado:  Registrada/Rechazada, total=1
  Obtenido:  Registrada/Rechazada, total=1
  Resultado: APROBADA

Prueba 4: Clasificacion de puntos
  Entrada:   Zona C (0,0) r=5; puntos (1,1), (3,4), (6,0)
  Esperado:  INTERIOR/BORDE/EXTERIOR
  Obtenido:  INTERIOR/BORDE/EXTERIOR
  Resultado: APROBADA

Prueba 5: Area y perimetro
  Entrada:   Radio 10
  Esperado:  area=314.16, perimetro=62.83
  Obtenido:  area=314.16, perimetro=62.83
  Resultado: APROBADA

Prueba 6: Zonas lejanas y tangentes
  Entrada:   A (0,0) r=3; B (10,0) r=3; T (0,6) r=3 (tangente a A)
  Esperado:  superposiciones=0
  Obtenido:  superposiciones=0
  Resultado: APROBADA

Resumen: 6 de 6 pruebas aprobadas.

```

