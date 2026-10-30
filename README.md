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
- **Gestionar geometrías circulares**: Registrar centros $(x, y)$ con radios estrictamente positivos, calcular áreas, perímetros y distancias.
- **Clasificar puntos y detectar superposiciones**: Determinar si un punto está en el interior, borde o exterior de una zona, e identificar solapamientos entre áreas.
- **Construir un menú interactivo**: Manejar excepciones, entradas seguras y validaciones estrictas contra duplicados.

> [!TIP]
> **Lema del equipo:** «Si lo puedes modelar en clases, lo puedes programar».

## 🦇 La Batfamilia · Integrantes y roles

Todo gran plan de estudio necesita un equipo que lo sostenga. Estos son los integrantes del equipo que conforman la Batfamilia para este repositorio, con responsabilidades distribuidas para cada clase:

<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=600&amp;size=18&amp;duration=2400&amp;pause=1300&amp;color=FACC15&amp;background=0D1117&amp;center=true&amp;vCenter=true&amp;width=860&amp;height=52&amp;lines=Agente+01+%E2%80%BA+Detective+del+C%C3%B3digo+Oscuro+%E2%80%BA+Dereck+Shair;Agente+02+%E2%80%BA+Arquitecto+de+la+Baticueva+Digital+%E2%80%BA+Brishy+Anahy;Agente+03+%E2%80%BA+Caballero+del+Backend+%E2%80%BA+Fher+Dorian;Agente+04+%E2%80%BA+Guardi%C3%A1n+Nocturno+del+Testing+%E2%80%BA+Antony+Sebastian;Agente+05+%E2%80%BA+Or%C3%A1culo+del+Consumo+%E2%80%BA+Karina+Paola" width="100%" alt="Integrantes de la Batfamilia">
</div>

| N.º | BatIntegrante | BatOperaciones | BatObjetivo y Componente |
| :---: | :--- | :--- | :--- |
| **1** | **Paredes Acosta Dereck Shair** | **Detective del Código Oscuro · Investigar · Analista** | Diseñar la lógica geométrica inicial y coordinar la estructura de la clase **`Punto.java`**. |
| **2** | **Ashanga Yumbo Brishy Anahy** | **Arquitecto de la Baticueva Digital · Preparar · Diseñar** | Diseñar el modelo de las entidades circulares e implementar la clase **`Zona.java`**. |
| **3** | **Calderon Carvajal Fher Dorian** | **Caballero del Backend · Construir · Programar** | Desarrollar la lógica de gestión de colecciones y superposiciones en la clase **`Sistemazonas.java`**. |
| **4** | **Casillas Ochoa Antony Sebastian** | **Guardián Nocturno del Testing · Inspeccionar · Probar** | Programar la interacción y lectura de datos validados en la clase **`Consola.java`**. |
| **5** | **Sanchez Bastidas Karina Paola** | **Oráculo del Conocimiento · Archivar · Documentar** | Orquestar la ejecución general en el **`Main.java`**, redactar documentación técnica y gestionar casos de prueba. |

**La mejor herramienta de la Baticueva sigue siendo trabajar juntos.**

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
