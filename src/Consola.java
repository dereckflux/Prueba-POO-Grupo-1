import java.util.ArrayList;

/**
 * ============================================================
 * CLASE: Consola
 * ============================================================
 * ¿PARA QUÉ SIRVE?
 *   Se encarga SOLO de la forma visual del programa en la consola:
 *   colores, títulos, menú en recuadro, mensajes de éxito/error/
 *   información, recuadros de resultados y un mapa de cobertura
 *   dibujado con caracteres.
 *   Así Main no se llena de System.out.println y, si se quiere
 *   cambiar el diseño, solo se modifica esta clase.
 *
 * ¿CON QUIÉN SE RELACIONA?
 *   - Main:  crea un objeto Consola y lo usa para mostrar todo.
 *   - Zona y Punto: los recibe (en listas) para dibujar el mapa;
 *            usa Zona.cubrePunto() para saber qué pintar.
 *   - SistemaZonas: de él vienen las listas de zonas y puntos
 *            (getZonas() y getPuntos()) que se dibujan.
 *
 * NOTA: los colores usan códigos ANSI. Funcionan en la terminal de
 *   VS Code y en Windows 10/11. Si en algún equipo salen símbolos
 *   raros, se desactivan con la opción 12 del menú.
 *   Los bordes usan solo caracteres simples (+ - |) para que se vean
 *   bien en cualquier computador.
 * ============================================================
 */
public class Consola {

    // ---------- 1. CONSTANTES DE COLOR (códigos ANSI) ----------
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String CIAN = "\u001B[36m";
    private static final String NEGRITA = "\u001B[1m";

    // Ancho fijo de los recuadros
    private static final int ANCHO = 64;

    // ---------- 2. ATRIBUTO ----------
    // Sirve para activar o desactivar los colores.
    private boolean usarColores;

    // ---------- 3. CONSTRUCTOR ----------
    // Lo llama Main al iniciar el programa.
    public Consola(boolean usarColores) {
        this.usarColores = usarColores;
    }

    // ---------- 4. GETTER Y CAMBIO DE ESTADO ----------
    public boolean isUsarColores() {
        return usarColores;
    }

    /** Sirve para prender/apagar los colores. Lo usa Main en la opción 12. */
    public void alternarColores() {
        usarColores = !usarColores;
    }

    // ---------- 5. MÉTODO AUXILIAR PRIVADO ----------
    // Sirve para pintar un texto de un color solo si los colores están activos.
    private String color(String codigo, String texto) {
        if (usarColores) {
            return codigo + texto + RESET;
        }
        return texto;
    }

    // Sirve para repetir un carácter n veces (para las líneas de los recuadros).
    private String repetir(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Sirve para completar con espacios y que el borde derecho quede alineado.
    private String rellenar(String texto, int largo) {
        if (texto.length() >= largo) {
            return texto.substring(0, largo);
        }
        return texto + repetir(' ', largo - texto.length());
    }

    // ---------- 6. ELEMENTOS VISUALES ----------

    /** Sirve para mostrar la portada del programa al iniciar. Lo llama Main. */
    public void mostrarBienvenida() {
        String linea = "+" + repetir('=', ANCHO - 2) + "+";
        System.out.println(color(CIAN, linea));
        System.out.println(color(CIAN, "|") + color(NEGRITA, rellenar("   UNIVERSIDAD TECNICA DE AMBATO - POO EN JAVA", ANCHO - 2)) + color(CIAN, "|"));
        System.out.println(color(CIAN, "|") + color(AMARILLO, rellenar("   CONTROL INTELIGENTE DE ZONAS CIRCULARES - GRUPO 1", ANCHO - 2)) + color(CIAN, "|"));
        System.out.println(color(CIAN, linea));
        System.out.println();
    }

    /**
     * Sirve para dibujar el menú dentro de un recuadro.
     * Recibe las opciones desde Main, así Main decide QUÉ opciones hay
     * y Consola decide CÓMO se ven.
     */
    public void mostrarMenu(String titulo, String[] opciones) {
        String borde = "+" + repetir('-', ANCHO - 2) + "+";
        System.out.println(color(AZUL, borde));
        System.out.println(color(AZUL, "|") + color(NEGRITA, rellenar("  " + titulo, ANCHO - 2)) + color(AZUL, "|"));
        System.out.println(color(AZUL, borde));
        for (String op : opciones) {
            System.out.println(color(AZUL, "|") + rellenar("  " + op, ANCHO - 2) + color(AZUL, "|"));
        }
        System.out.println(color(AZUL, borde));
    }

    /**
     * Sirve para mostrar un resultado (texto de varias líneas) dentro de un
     * recuadro con título. Lo usa Main con lo que devuelve SistemaZonas.
     */
    public void mostrarResultado(String titulo, String contenido) {
        String[] lineas = contenido.split("\n");
        // El recuadro se agranda si alguna línea es más larga que ANCHO
        int largo = ANCHO - 4;
        for (String l : lineas) {
            if (l.length() > largo) {
                largo = l.length();
            }
        }
        String borde = "+" + repetir('-', largo + 2) + "+";
        System.out.println(color(CIAN, borde));
        System.out.println(color(CIAN, "| ") + color(NEGRITA, rellenar(titulo.toUpperCase(), largo)) + color(CIAN, " |"));
        System.out.println(color(CIAN, borde));
        for (String l : lineas) {
            System.out.println(color(CIAN, "| ") + resaltar(rellenar(l, largo)) + color(CIAN, " |"));
        }
        System.out.println(color(CIAN, borde));
    }

    // Sirve para colorear palabras clave dentro de los resultados.
    private String resaltar(String linea) {
        if (!usarColores) {
            return linea;
        }
        return linea.replace("EXTERIOR", ROJO + "EXTERIOR" + RESET)
                .replace("SIN COBERTURA", ROJO + "SIN COBERTURA" + RESET)
                .replace("INTERIOR", VERDE + "INTERIOR" + RESET)
                .replace("CUBIERTO por", VERDE + "CUBIERTO por" + RESET)
                .replace("BORDE", AMARILLO + "BORDE" + RESET)
                .replace("SUPERPUESTAS", AMARILLO + "SUPERPUESTAS" + RESET);
    }

    /** Sirve para mostrar que una operación salió bien (en verde). */
    public void exito(String mensaje) {
        System.out.println(color(VERDE, "[OK] " + mensaje));
    }

    /** Sirve para mostrar errores de validación (en rojo). Lo usa Main en el catch. */
    public void error(String mensaje) {
        System.out.println(color(ROJO, "[ERROR] " + mensaje));
    }

    /** Sirve para mensajes informativos o avisos (en amarillo). */
    public void info(String mensaje) {
        System.out.println(color(AMARILLO, "[i] " + mensaje));
    }

    /** Sirve para pedir un dato con un estilo uniforme. Lo usa Main al leer datos. */
    public void pedir(String mensaje) {
        System.out.print(color(CIAN, "> ") + mensaje);
    }

    /** Sirve para separar visualmente una operación de la siguiente. */
    public void separador() {
        System.out.println(color(AZUL, repetir('-', ANCHO)));
    }

    // ---------- 7. MAPA VISUAL DE COBERTURA ----------

    /**
     * Sirve para DIBUJAR en la consola las zonas y los puntos registrados.
     * Recorre una cuadrícula de caracteres; para cada casilla calcula su
     * coordenada (x, y) real y pregunta a cada Zona si la cubre.
     *   .   = sin cobertura
     *   A,B = cubierto solo por esa zona (A = primera zona, B = segunda...)
     *   #   = cubierto por 2 o más zonas (superposición)
     *   *   = punto registrado para el informe
     * Se relaciona con Zona (cubrePunto, getCentro, getRadio) y Punto (getX, getY).
     */
    public void dibujarMapa(ArrayList<Zona> zonas, ArrayList<Punto> puntos) {
        if (zonas.isEmpty()) {
            error("No hay zonas para dibujar.");
            return;
        }

        // 1) Buscar los límites del plano que hay que mostrar
        double minX = Double.MAX_VALUE, maxX = -Double.MAX_VALUE;
        double minY = Double.MAX_VALUE, maxY = -Double.MAX_VALUE;
        for (Zona z : zonas) {
            minX = Math.min(minX, z.getCentro().getX() - z.getRadio());
            maxX = Math.max(maxX, z.getCentro().getX() + z.getRadio());
            minY = Math.min(minY, z.getCentro().getY() - z.getRadio());
            maxY = Math.max(maxY, z.getCentro().getY() + z.getRadio());
        }
        for (Punto p : puntos) {
            minX = Math.min(minX, p.getX());
            maxX = Math.max(maxX, p.getX());
            minY = Math.min(minY, p.getY());
            maxY = Math.max(maxY, p.getY());
        }

        // 2) Tamaño de la cuadrícula (los caracteres son más altos que anchos,
        //    por eso hay más columnas que filas)
        int columnas = 60;
        int filas = 24;
        double pasoX = (maxX - minX) / (columnas - 1);
        double pasoY = (maxY - minY) / (filas - 1);

        System.out.println(color(NEGRITA, "MAPA DE COBERTURA"));
        System.out.printf("x: [%.1f , %.1f]   y: [%.1f , %.1f]%n", minX, maxX, minY, maxY);

        // 3) Recorrer fila por fila (de arriba hacia abajo, por eso y empieza en maxY)
        for (int f = 0; f < filas; f++) {
            StringBuilder linea = new StringBuilder();
            double y = maxY - f * pasoY;
            for (int c = 0; c < columnas; c++) {
                double x = minX + c * pasoX;
                linea.append(caracterCelda(x, y, pasoX, pasoY, zonas, puntos));
            }
            System.out.println("  " + linea);
        }

        // 4) Leyenda: qué letra corresponde a cada zona
        StringBuilder leyenda = new StringBuilder("Leyenda: ");
        for (int i = 0; i < zonas.size(); i++) {
            leyenda.append(letraZona(i)).append("=").append(zonas.get(i).getNombre()).append("  ");
        }
        System.out.println(leyenda);
        System.out.println("         #=superposicion  *=punto registrado  .=sin cobertura");
    }

    // Sirve para decidir qué carácter (y color) va en una casilla del mapa.
    private String caracterCelda(double x, double y, double pasoX, double pasoY,
                                 ArrayList<Zona> zonas, ArrayList<Punto> puntos) {
        // ¿Hay un punto registrado dentro de esta casilla?
        for (Punto p : puntos) {
            if (Math.abs(p.getX() - x) <= pasoX / 2 && Math.abs(p.getY() - y) <= pasoY / 2) {
                return color(ROJO + NEGRITA, "*");
            }
        }
        // ¿Cuántas zonas cubren esta casilla?
        Punto celda = new Punto(x, y);
        int cuantas = 0;
        int indice = -1;
        for (int i = 0; i < zonas.size(); i++) {
            if (zonas.get(i).cubrePunto(celda)) {
                cuantas++;
                indice = i;
            }
        }
        if (cuantas == 0) {
            return ".";
        } else if (cuantas == 1) {
            return color(VERDE, String.valueOf(letraZona(indice)));
        } else {
            return color(AMARILLO, "#");
        }
    }

    // Sirve para convertir el número de zona en letra: 0->A, 1->B, ...
    private char letraZona(int indice) {
        return (char) ('A' + (indice % 26));
    }
}
