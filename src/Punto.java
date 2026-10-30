// Traemos "Locale" para poder decirle a Java que escriba los decimales
// con punto (2.50) y no con coma (2,50).
import java.util.Locale;

/*
 * ============================================================
 * CLASE PUNTO
 * ============================================================
 * Esta clase es como un "molde" para crear puntos en el plano,
 * igual que los puntos (x, y) que dibujamos en matemáticas.
 *
 * Ejemplo: new Punto(5, 2) crea el punto que está 5 a la derecha
 * y 2 hacia arriba.
 *
 * ¿Para qué la usamos en el programa?
 *   - Para guardar el CENTRO de cada zona (donde está la antena).
 *   - Para guardar dónde está un celular o dispositivo.
 *   - Para medir la distancia entre dos puntos.
 *
 * ¿Quién usa esta clase?
 *   - Zona: cada zona tiene un punto como centro.
 *   - SistemaZonas: guarda una lista de puntos para el informe.
 *   - Consola: dibuja los puntos en el mapa con un '*'.
 *   - Main: crea puntos con los números que escribe el usuario.
 * ============================================================
 */
public class Punto {

    // ===================== ATRIBUTOS =====================
    // Son los datos que guarda cada punto: su x y su y.
    // "double" significa que pueden tener decimales (ej: 2.5).
    // "private" significa que ninguna otra clase puede cambiarlos
    // directamente. Así protegemos los datos (esto se llama
    // ENCAPSULAMIENTO).
    private double x;   // posición horizontal (izquierda - derecha)
    private double y;   // posición vertical (arriba - abajo)

    // ===================== CONSTRUCTOR =====================
    // El constructor se ejecuta cuando creamos un punto con "new".
    // Tiene el mismo nombre que la clase y no devuelve nada.
    //
    // Ejemplo: new Punto(5, 2)  ->  x = 5, y = 2
    //
    // "this.x" es la x DEL PUNTO (el atributo).
    // "x" solita es el número que nos mandaron.
    // Entonces "this.x = x" quiere decir: guarda el número que me
    // mandaron dentro de mi atributo x.
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // ===================== GETTERS =====================
    // Como x y y son privados, otras clases no pueden verlos.
    // Los getters son como una "ventanita" para LEER el valor,
    // pero sin poder cambiarlo.
    //
    // No pusimos setters (setX, setY) a propósito: una vez creado
    // el punto, ya no se puede modificar.

    // Devuelve el valor de x
    public double getX() {
        return x;
    }

    // Devuelve el valor de y
    public double getY() {
        return y;
    }

    // ===================== MÉTODOS =====================

    /*
     * MÉTODO distanciaA
     * Calcula qué tan lejos está este punto de otro punto.
     * Usamos el teorema de Pitágoras:
     *
     *     distancia = raíz( (x2 - x1)^2 + (y2 - y1)^2 )
     *
     * Ejemplo: de (0,0) a (5,2)
     *     dx = 5 - 0 = 5
     *     dy = 2 - 0 = 2
     *     distancia = raíz(25 + 4) = raíz(29) = 5.385
     *
     * Lo usa Zona para saber si un punto está dentro del círculo,
     * y SistemaZonas para medir la distancia entre zonas.
     */
    public double distanciaA(Punto otro) {
        // Si nos mandan un punto que no existe (null), no se puede
        // medir nada, así que lanzamos un error para avisar.
        if (otro == null) {
            throw new IllegalArgumentException("El punto de comparación no puede ser nulo.");
        }
        // Cuánto se separan en horizontal
        double dx = otro.x - this.x;
        // Cuánto se separan en vertical
        double dy = otro.y - this.y;
        // dx * dx es dx al cuadrado. Math.sqrt saca la raíz cuadrada.
        return Math.sqrt(dx * dx + dy * dy);
    }

    /*
     * MÉTODO toString
     * Sirve para que el punto se vea bonito cuando lo imprimimos.
     *
     * Si no existiera, al hacer System.out.println(punto) saldría
     * algo raro como "Punto@1b6d3586".
     * Con este método sale "(5, 2)".
     *
     * @Override significa que estamos REEMPLAZANDO el toString que
     * Java ya trae por defecto, por uno hecho por nosotros.
     *
     * Java lo llama solito cuando imprimimos el punto o cuando lo
     * juntamos con un texto, por ejemplo: "Punto " + p
     */
    @Override
    public String toString() {
        // Arma el texto: "(" + x + ", " + y + ")"
        return "(" + formatear(x) + ", " + formatear(y) + ")";
    }

    /*
     * MÉTODO formatear (método ayudante)
     * Es privado porque solo lo usa toString, nadie más.
     *
     * Problema: un double se imprime como "5.0" y se ve feo.
     * Solución:
     *   - Si el número es entero (5.0)  -> lo muestra como "5"
     *   - Si tiene decimales (2.5)      -> lo muestra con 2 decimales "2.50"
     */
    private String formatear(double valor) {
        // Math.rint redondea al entero más cercano.
        // Si el número no cambia al redondearlo, quiere decir que es entero.
        if (valor == Math.rint(valor)) {
            // (long) le quita el ".0" al número  ->  5.0 se vuelve 5
            // String.valueOf lo convierte en texto  ->  "5"
            return String.valueOf((long) valor);
        }
        // "%.2f" significa: número con 2 decimales.
        // Locale.US hace que use punto y no coma  ->  "2.50"
        return String.format(Locale.US, "%.2f", valor);
    }
}
