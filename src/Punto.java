// Locale sirve para que los decimales salgan con punto (2.50) y no con coma (2,50)
import java.util.Locale;

// Clase Punto
// Representa un punto (x, y) en el plano, como en matemáticas.
// La usamos para guardar el centro de cada zona y la posición de un celular.
// La usan Zona, SistemaZonas, Consola y Main.
public class Punto {

    // Atributos: la posición del punto
    // Son private para que ninguna otra clase los pueda cambiar (encapsulamiento)
    private double x; // posición horizontal
    private double y; // posición vertical

    // Constructor: se ejecuta cuando creamos un punto con new
    // Ejemplo: new Punto(5, 2) crea el punto con x = 5 y y = 2
    // this.x es el atributo del punto, x es el número que nos mandan
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters: sirven para leer x y y desde otras clases
    // No hay setters, así que el punto no se puede cambiar después de crearlo
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Calcula la distancia entre este punto y otro usando Pitágoras
    // Fórmula: raíz((x2 - x1)^2 + (y2 - y1)^2)
    // Ejemplo: de (0,0) a (5,2) da raíz(25 + 4) = 5.385
    // Lo usa Zona para saber si un punto está dentro del círculo
    public double distanciaA(Punto otro) {
        // Si el otro punto no existe (null) lanzamos un error
        if (otro == null) {
            throw new IllegalArgumentException("El punto de comparación no puede ser nulo.");
        }
        double dx = otro.x - this.x; // diferencia en x
        double dy = otro.y - this.y; // diferencia en y
        // Math.sqrt saca la raíz cuadrada
        return Math.sqrt(dx * dx + dy * dy);
    }

    // toString hace que el punto se muestre como (5, 2) al imprimirlo
    // Sin este método saldría algo raro como Punto@1b6d3586
    // @Override significa que reemplazamos el toString que Java trae por defecto
    @Override
    public String toString() {
        return "(" + formatear(x) + ", " + formatear(y) + ")";
    }

    // Método ayudante que solo usa toString
    // Si el número es entero muestra 5 en vez de 5.0
    // Si tiene decimales muestra 2 decimales, por ejemplo 2.50
    private String formatear(double valor) {
        // Math.rint redondea; si no cambia, el número es entero
        if (valor == Math.rint(valor)) {
            // (long) le quita el .0 y String.valueOf lo vuelve texto
            return String.valueOf((long) valor);
        }
        // %.2f significa número con 2 decimales
        return String.format(Locale.US, "%.2f", valor);
    }
}
