import java.util.Locale;

/*
Zona de cobertura circular de un dispositivo inalambrico.
Contiene las reglas geometricas: area, perimetro, clasificacion de puntos
y deteccion de superposicion con otras zonas.
 */
public class Zona {

    /*
    Tolerancia numerica (1e-9) para comparar numeros decimales.
    Dos longitudes que difieren en menos que este valor se consideran iguales.
    Se usa para decidir si un punto esta exactamente en el borde.
    */
    public static final double TOLERANCIA = 1e-9;

    // Posible ubicacion de un punto respecto a una zona. 
    public enum Posicion { INTERIOR, BORDE, EXTERIOR }

    private final String nombre;
    private final Punto centro;
    private final double radio;

    public Zona(String nombre, Punto centro, double radio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la zona no puede estar vacio.");
        }
        if (centro == null) {
            throw new IllegalArgumentException("El centro de la zona no puede ser nulo.");
        }
        if (Double.isNaN(radio) || Double.isInfinite(radio) || radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser estrictamente positivo.");
        }
        this.nombre = nombre.trim();
        this.centro = centro;
        this.radio = radio;
    }

    public String getNombre() {
        return nombre;
    }

    public Punto getCentro() {
        return centro;
    }

    public double getRadio() {
        return radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    // Distancia entre el centro de esta zona y el de otra.
    public double distanciaCentros(Zona otra) {
        return centro.distanciaA(otra.centro);
    }

    // Clasifica un punto como INTERIOR, BORDE o EXTERIOR usando la tolerancia documentada.
    public Posicion clasificar(Punto p) {
        double diferencia = centro.distanciaA(p) - radio;
        if (Math.abs(diferencia) <= TOLERANCIA) {
            return Posicion.BORDE;
        }
        return diferencia < 0 ? Posicion.INTERIOR : Posicion.EXTERIOR;
    }

    // Un punto esta cubierto si es interior o esta en el borde.
    public boolean cubre(Punto p) {
        return clasificar(p) != Posicion.EXTERIOR;
    }

    /*
    Dos zonas se superponen cuando comparten area, es decir, cuando la distancia
    entre centros es menor que la suma de radios. Si solo se tocan en un punto
    (tangentes) NO se consideran superpuestas.
     */
    public boolean seSuperpone(Zona otra) {
        return distanciaCentros(otra) < radio + otra.radio - TOLERANCIA;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s | centro %s | radio %.2f | area %.2f | perimetro %.2f",
                nombre, centro, radio, calcularArea(), calcularPerimetro());
    }
}
