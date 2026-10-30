# Casos de prueba — Grupo 1

Para comprobar que el programa funcione correctamente, se realizaron varias pruebas utilizando el comando `java -cp bin Main`. En cada una se revisaron diferentes situaciones, desde el registro de zonas hasta el cálculo de áreas, la cobertura de puntos y la generación del mapa visual.

Para algunas pruebas se utilizó la opción **10**, que permite cargar las zonas del caso de referencia: **Z1**, ubicada en el centro (0,0) con radio 7, y **Z2**, ubicada en (10,0) con radio 6.

| # | Prueba realizada | Datos ingresados | Resultado esperado | Resultado obtenido | Estado |
|---|---|---|---|---|---|
| 1 | Comprobar el caso de referencia | Opción 10 (Z1, Z2 y punto (5,2)) | El punto debe quedar dentro de las dos zonas y mostrar una cobertura de 2 sobre 2. | El programa calculó una distancia de 5.3852 para ambas zonas. Como no supera sus respectivos radios, identificó el punto como INTERIOR en Z1 y Z2. Al final mostró: "Cubierto por 2 de 2 zona(s)". | ✅ |
| 2 | Verificar si las zonas se superponen | Opción 10 y después opción 6. | Identificar que las dos zonas se cruzan, ya que la distancia entre sus centros es menor que la suma de sus radios. | Se obtuvo una distancia entre centros de 10.00 y una suma de radios de 13.00. El programa indicó que Z1 y Z2 están SUPERPUESTAS y registró un total de 1 par superpuesto. | ✅ |
| 3 | Ingresar un radio incorrecto | Opción 1: nombre X, centro (0,0) y radio −3. También se probó con radio 0. | El sistema debe impedir el registro de zonas con radios iguales o menores que cero. | En ambos casos apareció el mensaje: "[ERROR] El radio debe ser estrictamente positivo (radio > 0)." | ✅ |
| 4 | Intentar registrar una zona con nombre repetido | Opción 10 y luego opción 1, ingresando el nombre `z1`, centro (1,1) y radio 1. | No permitir nombres duplicados, incluso si se escriben con diferentes mayúsculas o minúsculas. | El programa reconoció que la zona ya existía y mostró: "[ERROR] Ya existe una zona llamada "z1". No se permiten duplicados." | ✅ |
| 5 | Comprobar los límites de una zona | Opción 10 y opción 5. Se probaron los puntos (7,0), (6.9999999,0), (6.99,0) y (7.1,0). | Reconocer correctamente los puntos que están en el borde, dentro o fuera de Z1, tomando en cuenta la tolerancia definida. | Los resultados fueron: (7,0) BORDE; (6.9999999,0) BORDE; (6.99,0) INTERIOR y (7.1,0) EXTERIOR. | ✅ |
| 6 | Revisar cálculos e informe de cobertura | Opción 10, opción 2; después opción 7 con los puntos (5,2), (20,20) y (−7,0); finalmente opción 8. | Obtener correctamente el área y perímetro de cada zona, además de identificar cuántos puntos están cubiertos. | Los cálculos de áreas y perímetros fueron correctos. En el informe, (5,2) quedó dentro de Z1 y Z2, (20,20) no tuvo cobertura y (−7,0) quedó en el borde de Z1. El resumen indicó que 2 de los 3 puntos estaban cubiertos (66.67%). | ✅ |
| 7 | Comprobar puntos repetidos y datos incorrectos | Opción 7, ingresando nuevamente el punto (5,2). Después se escribió `abc` en el menú. | Evitar que se registre un mismo punto más de una vez y controlar los datos que no corresponden al tipo solicitado. | El programa detectó el punto repetido y mostró "[ERROR] El punto (5, 2) ya está registrado.". Al ingresar letras en el menú, indicó que se debía introducir un número entero. | ✅ |
| 8 | Revisar la representación gráfica de las zonas | Opción 10, opción 7 con los puntos (5,2) y (−7,0), y finalmente opción 11. | Mostrar las dos zonas, su área de intersección y los puntos registrados mediante los símbolos establecidos. | Se generó un mapa de 60 × 24. La zona Z1 se representó con la letra A, Z2 con B, la parte donde se cruzan con # y los puntos registrados con *. | ✅ |

## Comprobación manual del caso de referencia

Además de revisar los resultados que muestra el programa, se realizaron algunos cálculos manuales para comprobar que las distancias y medidas obtenidas fueran correctas.

### 1. Distancia del punto (5,2) al centro de Z1

Aplicando la fórmula de distancia entre dos puntos:

$$
d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
$$

$$
d = \sqrt{(5-0)^2 + (2-0)^2}
$$

$$
d = \sqrt{25 + 4} = \sqrt{29} \approx 5.385
$$

Como $5.385$ es menor que el radio de Z1 ($7$), el punto se encuentra en su **interior**.

### 2. Distancia del punto (5,2) al centro de Z2

$$
d = \sqrt{(5-10)^2 + (2-0)^2}
$$

$$
d = \sqrt{25 + 4} = \sqrt{29} \approx 5.385
$$

En este caso, la distancia también es menor que el radio de Z2 ($6$), por lo que el punto igualmente se encuentra en su **interior**.

### 3. Cálculo del área y perímetro de Z1

Para obtener el área se utilizó la fórmula $A = \pi r^2$, mientras que para el perímetro se aplicó $P = 2\pi r$.

$$
A = \pi (7)^2 \approx 153.94
$$

$$
P = 2\pi (7) \approx 43.98
$$

Los valores obtenidos coinciden con los que presenta el programa, por lo que se comprobó que los cálculos realizados son correctos.

## Conclusión de las pruebas

Después de ejecutar los ocho casos de prueba, se comprobó que el programa responde correctamente ante las diferentes situaciones planteadas. También se verificó que los cálculos, las validaciones de datos y la representación gráfica funcionan de acuerdo con lo esperado. Las pruebas permitieron revisar tanto los casos normales como aquellos en los que el usuario introduce información incorrecta o repetida.
