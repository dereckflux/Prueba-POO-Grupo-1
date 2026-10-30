<a name="inicio"></a>

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:000000,45:111114,75:1c1917,100:713f12&height=220&section=header&text=PRUEBA%20POO%20%C2%B7%20GRUPO%201&fontSize=50&fontColor=FACC15&stroke=713F12&strokeWidth=2&animation=fadeIn&fontAlignY=38&desc=CONTROL%20INTELIGENTE%20DE%20ZONAS%20CIRCULARES&descSize=16&descAlignY=65" width="100%" alt="Banner Principal">

# 🦇 GOTHAM STUDY DIVISION · BAT-COMPUTER v3.0 🦇

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=800&size=22&duration=3500&pause=1200&color=FACC15&background=0D1117&center=true&vCenter=true&width=900&height=70&lines=%E2%9A%A1+SISTEMA+TACTICO+DE+ZONAS+CIRCULARES+%E2%9A%A1;%F0%9F%A6%87+UNIVERSIDAD+TECNICA+DE+AMBATO+%F0%9F%A6%87;%F0%9F%94%A7+ENCAPSULAMIENTO%2C+CLASES+Y+OBJETOS;%E2%9C%A8+EL+PLAN+QUE+GOTHAM+NECESITA+PARA+APROBAR+" width="100%" alt="Typing SVG">

</div>

<p align="center">
  <strong>🦇 LA BATICUEVA DEL CÓDIGO · FACULTAD DE INGENIERÍA EN SISTEMAS</strong><br>
  <em>«Gotham tiene villanos y alertas de zona. Nosotros tenemos POO y clases bien estructuradas.»</em>
</p>

<div align="center">

<img src="https://img.shields.io/badge/BASE-BATICUEVA-FACC15?style=for-the-badge&labelColor=18181B" alt="Base: Baticueva">
<img src="https://img.shields.io/badge/GRUPO-01_--_EQUIPO_BATMAN-FACC15?style=for-the-badge&labelColor=18181B" alt="Grupo 1: Equipo Batman">
<img src="https://img.shields.io/badge/MISI%C3%93N-CONTROL_DE_ZONAS-FACC15?style=for-the-badge&labelColor=18181B" alt="Misión: Control de Zonas">

<br>

<img src="https://img.shields.io/badge/ASIGNATURA-ALGORITMOS_Y_L%C3%93GICA-CA8A04?style=flat-square&labelColor=18181B" alt="Algoritmos y Lógica de Programación">
<img src="https://img.shields.io/badge/LENGUAJE-JAVA-CA8A04?style=flat-square&labelColor=18181B" alt="Java">
<img src="https://img.shields.io/badge/ARQUITECTURA-POO_LIMPIA-CA8A04?style=flat-square&labelColor=18181B" alt="POO Limpia">
<img src="https://img.shields.io/badge/ESTADO-EN_PATRULLA-CA8A04?style=flat-square&labelColor=18181B" alt="Estado: en patrulla">

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
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=500&size=16&duration=900&pause=380&color=FACC15&background=0A0A0A&center=false&vCenter=false&width=560&height=161&multiline=true&lines=%C2%A0%C2%A0%3E+INICIANDO+BATICOMPUTADORA+v3.0+............+%5B+OK+%5D;%C2%A0%C2%A0%3E+CARGANDO+GRUPO+1%3A+ZONAS+CIRCULARES+......+%5B+OK+%5D;%C2%A0%C2%A0%3E+SINCRONIZANDO+CLASES+DOMINIO+.........+%5B+OK+%5D;%C2%A0%C2%A0%3E+ESCANEANDO+GOTHAM%3A+ZONAS+VALIDADAS+.....+%5B+OK+%5D;%C2%A0%C2%A0%3E+ASIGNANDO+ROLES+A+LOS+5+AGENTES+...........+%5B+OK+%5D;%C2%A0%C2%A0%3E+MISI%C3%93N%3A+APROBAR+POO+%C2%B7+EN+CURSO+%E2%96%88;%C2%A0;%C2%A0" alt="Baticomputadora Terminal">
</div>

### 🎯 Objetivos de la misión

- **Modelar clases de dominio robustas**: `Punto`, `Zona`, `Sistemazonas`, `Consola` y `Main`.
- **Gestionar geometrías circulares**: Registrar centros $(x, y)$ con radios estrictamente positivos, calcular áreas, perímetros y distancias.
- **Clasificar puntos y detectar superposiciones**: Determinar si un punto está en el interior, borde o exterior de una zona, e identificar solapamientos entre áreas.
- **Construir un menú interactivo**: Manejar excepciones, entradas seguras y validaciones estrictas contra duplicados.

> [!TIP]
> **Lema del equipo:** «Si lo puedes modelar en clases, lo puedes programar».

---

## 🦇 La Batfamilia · Integrantes y roles

Todo gran plan de estudio necesita un equipo que lo sostenga. Estos son los integrantes del equipo que conforman la Batfamilia para este repositorio y las clases asignadas a cada uno:

<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=18&duration=2400&pause=1300&color=FACC15&background=0D1117&center=true&vCenter=true&width=860&height=52&lines=Agente+01+%E2%80%BA+Dereck+Paredes+%E2%80%BA+Punto.java;Agente+02+%E2%80%BA+Antony+Casillas+%E2%80%BA+Zona.java;Agente+03+%E2%80%BA+Fher+Dorian+%E2%80%BA+Sistemazonas.java;Agente+04+%E2%80%BA+Brishy+Ashanga+%E2%80%BA+Main.java;Agente+05+%E2%80%BA+Karina+Sanchez+%E2%80%BA+Consola.java" width="100%" alt="Integrantes de la Batfamilia">
</div>

| N.º | BatIntegrante | BatOperaciones | Componente / Clase Asignada |
| :---: | :--- | :--- | :--- |
| **1** | **Paredes Acosta Dereck Shair** | **Detective del Código Oscuro · Modelar** | Implementación de la clase **`Punto.java`** (coordenadas cartesianas y distancias). |
| **2** | **Casillas Ochoa Antony Sebastian** | **Guardián Nocturno del Testing · Estructurar** | Desarrollo de la clase **`Zona.java`** (geometría, radios y clasificación de puntos). |
| **3** | **Calderon Carvajal Fher Dorian** | **Caballero del Backend · Construir** | Lógica de gestión de colecciones y superposiciones en **`Sistemazonas.java`**. |
| **4** | **Ashanga Yumbo Brishy Anahy** | **Arquitecto de la Baticueva Digital · Orquestar** | Coordinación del flujo principal y despliegue en **`Main.java`**. |
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
```

| Clase | Responsabilidad principal |
| :--- | :--- |
| `Punto` | Representa una coordenada $(x, y)$ y calcula la distancia euclidiana a otro punto. |
| `Zona` | Modela una zona circular con nombre, centro y radio; calcula área, perímetro y clasifica puntos (interior, borde, exterior). |
| `Sistemazonas` | Administra la colección de zonas, evita nombres duplicados y detecta superposiciones. |
| `Consola` | Centraliza la lectura segura de datos por teclado y la validación de entradas. |
| `Main` | Punto de entrada: muestra el menú y coordina el flujo del programa. |

### 🧭 Fases de la misión

1. **Análisis** · Lectura del enunciado e identificación de clases, atributos y métodos.
2. **Diseño** · Elaboración del diagrama de clases (`docs/diagrama_clases.png`).
3. **Implementación** · Cada agente programa su clase asignada.
4. **Integración** · Unión de todas las clases en `Main.java` y pruebas del menú.
5. **Pruebas** · Ejecución de los casos documentados en `docs/casos_prueba.md`.

---

## 🧰 El Batcinturón · Requisitos comunes

Los gadgets de POO que todo agente debe llevar en su clase:

- 🔒 **Encapsulamiento**: atributos `private` con *getters* y *setters* controlados.
- 🏗️ **Constructores**: inicialización correcta de cada objeto.
- ✅ **Validaciones**: radios estrictamente positivos y nombres de zona no repetidos.
- 🧮 **Cálculos geométricos**: área $\pi r^2$, perímetro $2\pi r$ y distancia $\sqrt{(x_2-x_1)^2 + (y_2-y_1)^2}$.
- 🛡️ **Manejo de excepciones**: entradas inválidas por teclado sin que el programa se detenga.
- 📋 **Colecciones**: uso de `ArrayList` para almacenar y recorrer las zonas.
- 🖨️ **`toString()`**: representación legible de cada objeto en consola.

### ▶️ Cómo ejecutar

```bash
cd src
javac *.java
java Main
```

---

## ☕ Zona de descanso · Alfred sirve el café

<div align="center">

*«¿Por qué caemos, señor? Para aprender a levantarnos… y a depurar el código.»* — Alfred

Si llegaste hasta aquí, la Baticueva te agradece la visita. 🦇☕

[⬆️ Volver al inicio](#inicio)

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:713f12,25:1c1917,55:111114,100:000000&height=120&section=footer" width="100%" alt="Footer">

</div>
