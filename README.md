<a name="inicio"></a>

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&amp;color=0:000000,45:111114,75:1c1917,100:713f12&amp;height=220&amp;section=header&amp;text=PRUEBA%20POO%20%C2%B7%20GRUPO%201&amp;fontSize=50&amp;fontColor=FACC15&amp;stroke=713F12&amp;strokeWidth=2&amp;animation=fadeIn&amp;fontAlignY=38&amp;desc=CONTROL%20INTELIGENTE%20DE%20ZONAS%20CIRCULARES&amp;descSize=16&amp;descAlignY=65" width="100%" alt="Banner Principal">

# 🦇 GOTHAM STUDY DIVISION · BAT-COMPUTER v3.0 🦇

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=800&amp;size=22&amp;duration=3500&amp;pause=1200&amp;color=FACC15&amp;background=0D1117&amp;center=true&amp;vCenter=true&amp;width=900&amp;height=70&amp;lines=%E2%9A%A1+SISTEMA+TACTICO+DE+ZONAS+CIRCULARES+%E2%9A%A1;%F0%9F%A6%87+UNIVERSIDAD+TECNICA+DE+AMBATO+%F0%9F%A6%87;%F0%9F%94%A7+ENCAPSULAMIENTO%2C+CLASES+Y+OBJETOS;%E2%9C%A8+EL+PLAN+QUE+GOTHAM+NECESITA+PARA+APROBAR+" width="100%" alt="Typing SVG">

</div>

<p align="center">
  <strong>🦇 LA BATICUEVA DEL CÓDIGO · FACULTAD DE INGENIERÍA EN SISTEMAS</strong><br>
  <em>«Gotham tiene villanos y alertas de zona. Nosotros tenemos POO y clases bien estructuradas.»</em>
</p>

<div align="center">

<img src="https://img.shields.io/badge/BASE-BATICUEVA-FACC15?style=for-the-badge&amp;labelColor=18181B" alt="Base: Baticueva">
<img src="https://img.shields.io/badge/GRUPO-01_-_EQUIPO_BATMAN-FACC15?style=for-the-badge&amp;labelColor=18181B" alt="Grupo 1: Equipo Batman">
<img src="https://img.shields.io/badge/MISI%C3%93N-CONTROL_DE_ZONAS-FACC15?style=for-the-badge&amp;labelColor=18181B" alt="Misión: Control de Zonas">

<br>

<img src="https://img.shields.io/badge/ASIGNATURA-ALGORITMOS_Y_L%C3%93GICA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Algoritmos y Lógica de Programación">
<img src="https://img.shields.io/badge/LENGUAJE-JAVA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Java">
<img src="https://img.shields.io/badge/ARQUITECTURA-POO_LIMPIA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="POO Limpia">
<img src="https://img.shields.io/badge/ESTADO-EN_PATRULLA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Estado: en patrulla">

<br><br>

**Bienvenidos al centro de operaciones de la Baticueva.**<br>
Este repositorio contiene la solución oficial del **Grupo 1** para la Prueba Práctica Integradora de POO en Java.<br>
Implementamos el control inteligente de zonas circulares aplicando encapsulamiento estricto, clases de dominio especializadas y una arquitectura robusta con gestión de consola integrada.

**Cinco agentes. Un repositorio. Cero errores de compilación.**

[🌃 Expediente](#-el-expediente--de-qué-trata-este-repositorio) ·
[🦇 Batfamilia](#-la-batfamilia--integrantes-y-roles) ·
[🔎 Protocolo](#-protocolo-de-la-baticueva--clases-y-fases) ·
[🧰 Batcinturón](#-el-batcinturón--requisitos-comunes) ·
[☕ Descanso](#-zona-de-descanso--alfred-sirve-el-café)

</div>

---

## 🌃 El expediente · ¿De qué trata este repositorio?

Este repositorio guarda la solución al problema asignado al **Grupo 1**: **Control inteligente de zonas circulares**. El sistema permite a una institución determinar la cobertura de dispositivos inalámbricos en un plano mediante clases orientadas a objetos bien estructuradas.

Como en cualquier investigación de Gotham, primero recolectamos las coordenadas y radios, validamos que no existan nombres duplicados, calculamos distancias y áreas, y detectamos superposiciones de zonas.

<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=500&amp;size=16&amp;duration=900&amp;pause=380&amp;color=FACC15&amp;background=0A0A0A&amp;center=false&amp;vCenter=false&amp;width=560&amp;height=161&amp;multiline=true&amp;lines=%C2%A0%C2%A0%3E+INICIANDO+BATICOMPUTADORA+v3.0+............+%5B+OK+%5D;%C2%A0%C2%A0%3E+CARGANDO+GRUPO+1%3A+ZONAS+CIRCULARES+......+%5B+OK+%5D;%C2%A0%C2%A0%3E+SINCRONIZANDO+CLASES+DOMINIO+.........+%5B+OK+%5D;%C2%A0%C2%A0%3E+ESCANEANDO+GOTHAM%3A+ZONAS+VALIDADAS+.....+%5B+OK+%5D;%C2%A0%C2%A0%3E+ASIGNANDO+ROLES+A+LOS+5+AGENTES+...........+%5B+OK+%5D;%C2%A0%C2%A0%3E+MISI%C3%93N%3A+APROBAR+POO+%C2%B7+EN+CURSO+%E2%96%88;%C2%A0;%C2%A0" alt="Baticomputadora Terminal">
</div>

### 🎯 Objetivos de la misión

- **Modelar clases de dominio robustas**: `Punto`, `Zona`, `Sistemazonas`, `Consola` y `Main`.
- **Gestionar geometrías circulares**: Registrar centros $(x, y)$ con radios estrictamente positivos, calcular áreas, perímetros y distancias[cite: 22].
- **Clasificar puntos y detectar superposiciones**: Determinar si un punto está en el interior, borde o exterior de una zona, e identificar solapamientos entre áreas[cite: 22].
- **Construir un menú interactivo**: Manejar excepciones, entradas seguras y validaciones estrictas contra duplicados[cite: 20, 22].

> [!TIP]
> **Lema del equipo:** «Si lo puedes modelar en clases, lo puedes programar».

---

## 🦇 La Batfamilia · Integrantes y roles

Todo gran plan de estudio necesita un equipo que lo sostenga. Estos son los integrantes del equipo que conforman la Batfamilia para este repositorio y las clases asignadas a cada uno:

<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=600&amp;size=18&amp;duration=2400&amp;pause=1300&amp;color=FACC15&amp;background=0D1117&amp;center=true&amp;vCenter=true&amp;width=860&amp;height=52&amp;lines=Agente+01+%E2%80%BA+Dereck+Paredes+%E2%80%BA+Punto.java;Agente+02+%E2%80%BA+Antony+Casillas+%E2%80%BA+Zona.java;Agente+03+%E2%80%BA+Fher+Dorian+%E2%80%BA+Sistemazonas.java;Agente+04+%E2%80%BA+Brishy+Ashanga+%E2%80%BA+Main.java;Agente+05+%E2%80%BA+Karina+Sanchez+%E2%80%BA+Consola.java" width="100%" alt="Integrantes de la Batfamilia">
</div>

| N.º | BatIntegrante | BatOperaciones | Componente / Clase Asignada |
| :---: | :--- | :--- | :--- |
| **1** | **Paredes Acosta Dereck Shair** | **Detective del Código Oscuro · Modelar** | Implementación de la clase **`Punto.java`** (coordenadas cartesianas y distancias)[cite: 22]. |
| **2** | **Casillas Ochoa Antony Sebastian** | **Guardián Nocturno del Testing · Estructurar** | Desarrollo de la clase **`Zona.java`** (geometría, radios y clasificación de puntos)[cite: 22]. |
| **3** | **Calderon Carvajal Fher Dorian** | **Caballero del Backend · Construir** | Lógica de gestión de colecciones y superposiciones en **`Sistemazonas.java`**[cite: 22]. |
| **4** | **Ashanga Yumbo Brishy Anahy** | **Arquitecto de la Baticueva Digital · Orquestar** | Coordinación del flujo principal y despliegue en **`Main.java`**[cite: 20, 22]. |
| **5** | **Sanchez Bastidas Karina Paola** | **Oráculo del Consumo · Validar** | Encapsulamiento de entradas por teclado e interfaz de **`Consola.java`**. |

**La mejor herramienta de la Baticueva sigue siendo trabajar juntos.**

---

## 🔎 Protocolo de la Baticueva · Clases y fases

Estructura de archivos y clases implementadas para cumplir con los requerimientos de la prueba práctica:

```text
Prueba-POO-Grupo-1/
┣ 📂 src/
┃ ┣ 📜 Main.java
┃ ┣ 📜 Punto.java
┃ ┣ 📜 Zona.java
┃ ┣ 📜 Sistemazonas.java
┃ ┗ 📜 Consola.java
┣ 📂 docs/
┃ ┣ 📜 analisis.md
┃ ┣ 📜 casos_prueba.md
┃ ┗ 📜 diagrama_clases.png
┣ 📜 .gitignore
┗ 📜 README.md
## 🧰 El Batcinturón · Requisitos comunes

Cumplimiento estricto de las directrices de la Universidad Técnica de Ambato (Facultad de Ingeniería en Sistemas, Electrónica e Industrial):

- **Encapsulamiento:** Uso de atributos privados, constructores parametrizados y métodos públicos de acceso y modificación.
- **Métodos funcionales:** Al menos cinco métodos de negocio implementados de forma modular en las clases de dominio.
- **Validaciones de seguridad:** Control de radios negativos, nombres de zonas duplicados e ingresos de datos erróneos mediante la clase `Consola`.
- **Evidencias de commits:** Participación verificable de todos los integrantes de la Batfamilia en el control de versiones.

---

## ☕ Zona de descanso · Alfred sirve el café

Hasta el Caballero Oscuro necesita una pausa entre compilaciones. Un pequeño descanso antes de volver a la terminal.

<details>
<summary><b>🦇 Batman, ¿cuál es tu verdadero superpoder en Java?</b></summary>

<br>

**Compilar un programa con múltiples clases y `Consola.java` separada sin arrojar `NullPointerException` al primer intento.**

Ni toda la fortuna de Wayne Enterprises puede comprar esa satisfacción en plena prueba de 90 minutos.

</details>

<details>
<summary><b>🤵 Un consejo de Alfred</b></summary>

<br>

—Señor, debería documentar el código antes de hacer el último commit.

—Alfred, Gotham necesita este diagrama de clases ya mismo.

**A la mañana siguiente, el profesor revisaba los casos de prueba con una sonrisa.**

Esa noche nació una nueva regla: el `README` completo es parte del plan.

</details>

---

<div align="center">

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=600&amp;size=19&amp;duration=2600&amp;pause=1500&amp;color=FACC15&amp;background=0D1117&amp;center=true&amp;vCenter=true&amp;width=860&amp;height=56&amp;lines=Gotham+puede+dormir.+El+codigo+ya+compila.;Primero+lo+dise%C3%B1amos.+Luego+lo+instanciamos.;Y+si+algo+falla%2C+lo+repasamos+en+el+main." width="100%" alt="Frases animadas de cierre">

🦇

*No hace falta una capa para aprobar POO.*<br>
*Hace falta encapsulamiento, clases limpias y trabajo en equipo.*

**La próxima respuesta puede estar en ese método que todavía no refactorizas.**

<sub>Un plan con estrategia, diseño orientado a objetos y espíritu de detective.</sub>

<br>

[⬆️ Volver a la Baticueva](#inicio)

<img src="https://capsule-render.vercel.app/api?type=waving&amp;color=0:000000,45:18181B,100:CA8A04&amp;height=130&amp;section=footer" width="100%" alt="Ondas animadas de cierre">

</div>
