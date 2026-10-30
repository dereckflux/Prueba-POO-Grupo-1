import java.util.ArrayList;
import java.util.Locale;

// Esta clase maneja todas las zonas y puntos que se registran.
// Aqui van las reglas: que no se repitan nombres, ver si las zonas se cruzan
// y sacar el informe de que puntos tienen cobertura.
// Los calculos de cada circulo los hace Zona, aqui solo se los pedimos.
public class SistemaZonas {

    // listas donde guardamos todo lo que se va registrando
    private ArrayList<Zona> zonas;
    private ArrayList<Punto> puntos;

    public SistemaZonas() {
        zonas = new ArrayList<>();
        puntos = new ArrayList<>();
    }

    // devolvemos una copia para que desde Consola no se pueda modificar la lista original
    public ArrayList<Zona> getZonas() {
        return new ArrayList<>(zonas);
    }

    public ArrayList<Punto> getPuntos() {
        return new ArrayList<>(puntos);
    }

    public int cantidadZonas() {
        return zonas.size();
    }

    // busca la zona por nombre, no importa si esta en mayusculas o minusculas
    // si no la encuentra devuelve null
    public Zona buscarZona(String nombre) {
        if (nombre == null) {
            return null;
        }
        for (Zona z : zonas) {
            if (z.getNombre().equalsIgnoreCase(nombre.trim())) {
                return z;
            }
        }
        return null;
    }

    public boolean existeZona(String nombre) {
        return buscarZona(nombre) != null;
    }

    // primero revisamos que el nombre no este repetido,
    // lo del radio ya lo valida el constructor de Zona
    public void registrarZona(String nombre, double x, double y, double radio) {
        if (existeZona(nombre)) {
            throw new IllegalArgumentException("Ya existe una zona llamada \"" + nombre.trim()
                    + "\". No se permiten duplicados.");
        }
        Zona nueva = new Zona(nombre, new Punto(x, y), radio);
        zonas.add(nueva);
    }

    public void eliminarZona(String nombre) {
        Zona z = buscarZona(nombre);
        if (z == null) {
            throw new IllegalArgumentException("No existe la zona \"" + nombre + "\".");
        }
        zonas.remove(z);
    }

    // cada zona se imprime con su toString (ahi sale el area y perimetro)
    public String listarZonas() {
        if (zonas.isEmpty()) {
            return "No hay zonas registradas.";
        }
        StringBuilder sb = new StringBuilder("Total de zonas: " + zonas.size() + "\n");
        for (Zona z : zonas) {
            sb.append(z).append("\n");
        }
        return sb.toString().trim();
    }

    // distancia entre los centros de dos zonas
    public double distanciaEntreZonas(String nombreA, String nombreB) {
        Zona a = buscarZona(nombreA);
        Zona b = buscarZona(nombreB);
        if (a == null || b == null) {
            throw new IllegalArgumentException("Una o ambas zonas no existen.");
        }
        return a.getCentro().distanciaA(b.getCentro());
    }

    // revisa el punto en todas las zonas y cuenta en cuantas esta cubierto
    public String clasificarPuntoEnZonas(Punto p) {
        if (zonas.isEmpty()) {
            throw new IllegalStateException("No hay zonas registradas para clasificar el punto.");
        }
        StringBuilder sb = new StringBuilder("Punto " + p + "   (tolerancia EPS = " + Zona.EPS + ")\n");
        int cubierto = 0;
        for (Zona z : zonas) {
            String tipo = z.clasificarPunto(p);
            if (!tipo.equals(Zona.EXTERIOR)) {
                cubierto++;
            }
            sb.append(String.format(Locale.US, "%-10s distancia=%.4f  radio=%.2f  -> %s%n",
                    z.getNombre(), z.distanciaAlCentro(p), z.getRadio(), tipo));
        }
        sb.append("Cubierto por ").append(cubierto).append(" de ").append(zonas.size()).append(" zona(s).");
        return sb.toString();
    }

    // compara las zonas de dos en dos
    public String detectarSuperposiciones() {
        if (zonas.size() < 2) {
            throw new IllegalStateException("Se necesitan al menos 2 zonas para detectar superposición.");
        }
        StringBuilder sb = new StringBuilder();
        int total = 0;
        // j arranca en i+1 para no comparar una zona con ella misma
        // y para no repetir pares (Z1-Z2 y Z2-Z1 es lo mismo)
        for (int i = 0; i < zonas.size(); i++) {
            for (int j = i + 1; j < zonas.size(); j++) {
                Zona a = zonas.get(i);
                Zona b = zonas.get(j);
                double d = a.getCentro().distanciaA(b.getCentro());
                sb.append(String.format(Locale.US, "%s - %s: dist. centros=%.2f, suma radios=%.2f -> %s%n",
                        a.getNombre(), b.getNombre(), d, a.getRadio() + b.getRadio(), a.relacionCon(b)));
                if (a.seSuperponeCon(b)) {
                    total++;
                }
            }
        }
        sb.append("Total de pares superpuestos: ").append(total);
        return sb.toString();
    }

    // guarda un punto para el informe, si ya existe no lo deja meter otra vez
    public void registrarPunto(double x, double y) {
        Punto nuevo = new Punto(x, y);
        for (Punto p : puntos) {
            if (p.distanciaA(nuevo) <= Zona.EPS) {
                throw new IllegalArgumentException("El punto " + nuevo + " ya está registrado.");
            }
        }
        puntos.add(nuevo);
    }

    // por cada punto vemos que zonas lo cubren, y al final sacamos el porcentaje
    public String generarInformeCobertura() {
        if (zonas.isEmpty()) {
            throw new IllegalStateException("No hay zonas registradas.");
        }
        if (puntos.isEmpty()) {
            throw new IllegalStateException("No hay puntos registrados para el informe.");
        }
        StringBuilder sb = new StringBuilder();
        int cubiertos = 0;
        for (Punto p : puntos) {
            StringBuilder lista = new StringBuilder();
            for (Zona z : zonas) {
                if (z.cubrePunto(p)) {
                    if (lista.length() > 0) {
                        lista.append(", ");
                    }
                    lista.append(z.getNombre()).append(" [").append(z.clasificarPunto(p)).append("]");
                }
            }
            if (lista.length() > 0) {
                cubiertos++;
                sb.append(p).append(" CUBIERTO por: ").append(lista).append("\n");
            } else {
                sb.append(p).append(" SIN COBERTURA\n");
            }
        }
        double porcentaje = 100.0 * cubiertos / puntos.size();
        sb.append(String.format(Locale.US, "Resumen: %d de %d puntos cubiertos (%.2f%%)",
                cubiertos, puntos.size(), porcentaje));
        return sb.toString();
    }
}