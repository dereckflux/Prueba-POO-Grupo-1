import java.util.Locale;
import java.util.Scanner;

/**
 * ============================================================
 * CLASE: Main
 * ============================================================
 * ¿PARA QUÉ SIRVE?
 *   Es el punto de inicio del programa. SOLO coordina el menú:
 *   lee lo que escribe el usuario y llama a los objetos que hacen
 *   el trabajo. No hace cálculos ni reglas de negocio.
 *
 * ¿CON QUIÉN SE RELACIONA?
 *   - SistemaZonas: le pide todas las operaciones (registrar,
 *            clasificar, superposición, informe...).
 *   - Consola: le pide mostrar todo lo visual (menú, recuadros,
 *            mensajes y mapa).
 *   - Punto: crea puntos con las coordenadas ingresadas.
 *   - Scanner: lee los datos del teclado.
 * ============================================================
 */
public class Main {

    // ---------- 1. ATRIBUTOS ESTÁTICOS ----------
    // Scanner sirve para leer del teclado; Consola para mostrar en pantalla.
    // Son static porque se usan dentro de los métodos static de lectura.
    private static Scanner sc = new Scanner(System.in);
    private static Consola consola = new Consola(true);

    // Opciones del menú: Main decide QUÉ opciones existen; Consola decide CÓMO se ven.
    private static final String[] OPCIONES = {
            "1. Registrar zona",
            "2. Listar zonas (area y perimetro)",
            "3. Distancia entre dos puntos",
            "4. Distancia entre centros de dos zonas",
            "5. Clasificar punto (interior / borde / exterior)",
            "6. Detectar superposicion de zonas",
            "7. Registrar punto para informe",
            "8. Informe de puntos cubiertos",
            "9. Eliminar zona",
            "10. Cargar caso de prueba de referencia",
            "11. Ver mapa visual de cobertura",
            "12. Activar / desactivar colores",
            "0. Salir"
    };

    // ---------- 2. MÉTODO PRINCIPAL ----------
    public static void main(String[] args) {
        // Se crea el objeto que administra las zonas (integración entre clases)
        SistemaZonas sistema = new SistemaZonas();
        int opcion;

        consola.mostrarBienvenida();

        // Ciclo do-while: el menú se repite hasta que el usuario elija 0
        do {
            consola.mostrarMenu("MENU PRINCIPAL", OPCIONES);
            opcion = leerEntero("Seleccione una opcion: ");
            System.out.println();

            // try-catch: si alguna clase lanza un error de validación,
            // se muestra con Consola y el programa NO se cierra.
            try {
                switch (opcion) {
                    case 1: // Registrar zona -> SistemaZonas valida duplicados y Zona valida el radio
                        String nombre = leerTexto("Nombre de la zona: ");
                        double x = leerDouble("Centro X: ");
                        double y = leerDouble("Centro Y: ");
                        double r = leerDouble("Radio: ");
                        sistema.registrarZona(nombre, x, y, r);
                        consola.exito("Zona \"" + nombre + "\" registrada correctamente.");
                        break;

                    case 2: // Listar zonas -> Zona calcula área y perímetro
                        consola.mostrarResultado("Zonas registradas", sistema.listarZonas());
                        break;

                    case 3: // Distancia entre dos puntos -> Punto.distanciaA()
                        Punto p1 = new Punto(leerDouble("X1: "), leerDouble("Y1: "));
                        Punto p2 = new Punto(leerDouble("X2: "), leerDouble("Y2: "));
                        consola.mostrarResultado("Distancia",
                                String.format(Locale.US, "Distancia entre %s y %s = %.4f", p1, p2, p1.distanciaA(p2)));
                        break;

                    case 4: // Distancia entre centros -> SistemaZonas busca las zonas
                        String a = leerTexto("Nombre de la primera zona: ");
                        String b = leerTexto("Nombre de la segunda zona: ");
                        consola.mostrarResultado("Distancia entre centros",
                                String.format(Locale.US, "%s - %s = %.4f", a, b, sistema.distanciaEntreZonas(a, b)));
                        break;

                    case 5: // Clasificar punto -> cada Zona clasifica con tolerancia EPS
                        Punto p = new Punto(leerDouble("X del punto: "), leerDouble("Y del punto: "));
                        consola.mostrarResultado("Clasificacion del punto", sistema.clasificarPuntoEnZonas(p));
                        break;

                    case 6: // Superposición -> Zona.seSuperponeCon() y relacionCon()
                        consola.mostrarResultado("Analisis de superposicion", sistema.detectarSuperposiciones());
                        break;

                    case 7: // Registrar punto -> SistemaZonas evita puntos repetidos
                        sistema.registrarPunto(leerDouble("X del punto: "), leerDouble("Y del punto: "));
                        consola.exito("Punto registrado para el informe.");
                        break;

                    case 8: // Informe -> SistemaZonas recorre puntos y zonas
                        consola.mostrarResultado("Informe de puntos cubiertos", sistema.generarInformeCobertura());
                        break;

                    case 9: // Eliminar zona
                        String eliminar = leerTexto("Nombre de la zona a eliminar: ");
                        sistema.eliminarZona(eliminar);
                        consola.exito("Zona \"" + eliminar + "\" eliminada.");
                        break;

                    case 10: // Caso de referencia del enunciado
                        cargarCasoReferencia(sistema);
                        break;

                    case 11: // Mapa visual -> Consola dibuja con los datos de SistemaZonas
                        consola.dibujarMapa(sistema.getZonas(), sistema.getPuntos());
                        break;

                    case 12: // Colores -> Consola cambia su estado
                        consola.alternarColores();
                        consola.info("Colores " + (consola.isUsarColores() ? "activados." : "desactivados."));
                        break;

                    case 0:
                        consola.info("Saliendo del sistema... Hasta pronto.");
                        break;

                    default:
                        consola.error("Opcion invalida. Elija un numero del 0 al 12.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                consola.error(e.getMessage());
            }
            consola.separador();
        } while (opcion != 0);

        sc.close();
    }

    // ---------- 3. CASO DE REFERENCIA ----------
    /**
     * Sirve para cargar rápido el caso del enunciado:
     * centros (0,0) y (10,0), radios 7 y 6; el punto (5,2) debe estar dentro de ambas.
     * Se relaciona con SistemaZonas (registra y clasifica) y Consola (muestra).
     */
    private static void cargarCasoReferencia(SistemaZonas sistema) {
        if (!sistema.existeZona("Z1")) {
            sistema.registrarZona("Z1", 0, 0, 7);
        }
        if (!sistema.existeZona("Z2")) {
            sistema.registrarZona("Z2", 10, 0, 6);
        }
        consola.exito("Cargadas Z1 (0,0) r=7 y Z2 (10,0) r=6.");
        consola.mostrarResultado("Caso de referencia: punto (5,2)",
                sistema.clasificarPuntoEnZonas(new Punto(5, 2)));
    }

    // ---------- 4. LECTURA VALIDADA DE DATOS ----------
    // Estos métodos sirven para que el programa no se caiga si el usuario
    // escribe algo incorrecto. Usan Consola para pedir y mostrar errores.

    /** Lee un texto que no esté vacío. */
    private static String leerTexto(String mensaje) {
        String texto;
        do {
            consola.pedir(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                consola.error("El texto no puede estar vacio.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    /** Lee un número decimal; acepta coma o punto (ej: 2,5 o 2.5). */
    private static double leerDouble(String mensaje) {
        while (true) {
            consola.pedir(mensaje);
            String linea = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                consola.error("Valor invalido. Ingrese un numero.");
            }
        }
    }

    /** Lee un número entero (para las opciones del menú). */
    private static int leerEntero(String mensaje) {
        while (true) {
            consola.pedir(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                consola.error("Valor invalido. Ingrese un numero entero.");
            }
        }
    }
}
