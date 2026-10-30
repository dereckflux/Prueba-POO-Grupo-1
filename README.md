<a name="inicio"></a>

<h1 align="center">Prueba POO grupo 1</h1>

<p align="center">
  <strong>🦇 LA BATICUEVA DEL CÓDIGO · GOTHAM STUDY DIVISION</strong><br>
  <em>Gotham tiene villanos. Nosotros tenemos un plan y POO orientada a objetos.</em>
</p>

<div align="center">

<img src="https://capsule-render.vercel.app/api?type=checkered&amp;color=0:000000,45:111114,75:1c1917,100:713f12&amp;height=240&amp;section=header&amp;text=PRUEBA%20POO%20GRUPO%201&amp;fontSize=55&amp;fontColor=FACC15&amp;stroke=713F12&amp;strokeWidth=1&amp;animation=twinkling&amp;fontAlignY=42&amp;desc=CONTROL%20INTELIGENTE%20DE%20ZONAS%20CIRCULARES%20%C2%B7%20UTA&amp;descSize=16&amp;descAlignY=67" width="100%" alt="Banner animado: Prueba POO Grupo 1, Control Inteligente de Zonas Circulares">

<h2>🦇 EL PLAN QUE GOTHAM NECESITA PARA APROBAR</h2>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=700&amp;size=21&amp;duration=3000&amp;pause=1400&amp;color=FACC15&amp;background=0D1117&amp;center=true&amp;vCenter=true&amp;width=860&amp;height=64&amp;lines=Si+lo+puedes+encapsular%2C+lo+puedes+controlar.;De+d%C3%ADa+estudiantes.+De+noche%2C+guardianes+del+codigo.;Cinco+mentes.+Un+equipo.+Gotham+nos+espera.;La+senal+est%C3%A1+encendida%3A+hora+de+compilar.;Hasta+el+mejor+detective+revisa+sus+constructores.;Control+inteligente+de+zonas+circulares." width="100%" alt="Frases animadas de Batman">

**La noche es larga. El sistema de zonas circulares tiene que compilar.**

<img src="https://img.shields.io/badge/BASE-BATICUEVA-FACC15?style=for-the-badge&amp;labelColor=18181B" alt="Base: Baticueva">
<img src="https://img.shields.io/badge/GRUPO-01_-_EQUIPO_BATMAN-FACC15?style=for-the-badge&amp;labelColor=18181B" alt="Grupo 1: Equipo Batman">
<img src="https://img.shields.io/badge/MISI%C3%93N-PROGRAMAR_DE_VERDAD-FACC15?style=for-the-badge&amp;labelColor=18181B" alt="Misión: programar de verdad">

<br>

<img src="https://img.shields.io/badge/ASIGNATURA-ALGORITMOS_Y_L%C3%93GICA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Algoritmos y Lógica de Programación">
<img src="https://img.shields.io/badge/LENGUAJE-JAVA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Java">
<img src="https://img.shields.io/badge/PROBLEMA-ZONAS_CIRCULARES-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Zonas circulares">
<img src="https://img.shields.io/badge/ESTADO-EN_PATRULLA-CA8A04?style=flat-square&amp;labelColor=18181B" alt="Estado: en patrulla">

<br><br>

**Bienvenidos a la Baticueva, nuestro centro de operaciones de POO.**<br>
Este repositorio contiene la solución oficial del **Grupo 1** para la Práctica Práctica Integradora de POO en Java.<br>
Implementamos el control inteligente de zonas circulares aplicando encapsulamiento, clases de dominio y arquitectura limpia.

**Cinco mentes. Un repositorio. Cero errores de compilación.**

[🌃 Expediente](#-el-expediente--de-qué-trata-este-repositorio) ·
[🦇 Batfamilia](#-la-batfamilia--integrantes-y-roles) ·
[🔎 Protocolo](#-protocolo-de-la-baticueva--clases-y-fases) ·
[🧰 Batcinturón](#-el-batcinturón--requisitos-comunes) ·
[☕ Descanso](#-zona-de-descanso--alfred-sirve-el-café)

</div>

---

## 🌃 El expediente · ¿De qué trata este repositorio?

Este repositorio guarda la solución al problema asignado al **Grupo 1**: **Control inteligente de zonas circulares**. El sistema permite a una institución determinar la cobertura de dispositivos inalámbricos en un plano mediante clases orientadas a objetos bien estructuradas[cite: 22].

Como en cualquier investigación de Gotham, primero recolectamos las coordenadas y radios, validamos que no existan nombres duplicados, calculamos distancias y áreas, y detectamos superposiciones de zonas[cite: 22].

<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=500&amp;size=16&amp;duration=900&amp;pause=380&amp;color=FACC15&amp;background=0A0A0A&amp;center=false&amp;vCenter=false&amp;width=560&amp;height=161&amp;multiline=true&amp;lines=%C2%A0%C2%A0%3E+INICIANDO+BATICOMPUTADORA+v2.0+............+%5B+OK+%5D;%C2%A0%C2%A0%3E+CARGANDO+GRUPO+1%3A+ZONAS+CIRCULARES+......+%5B+OK+%5D;%C2%A0%C2%A0%3E+SINCRONIZANDO+CLASES+DOMINIO+.........+%5B+OK+%5D;%C2%A0%C2%A0%3E+ESCANEANDO+GOTHAM%3A+ZONAS+VALIDADAS+.....+%5B+OK+%5D;%C2%A0%C2%A0%3E+ASIGNANDO+ROLES+A+LOS+5+AGENTES+...........+%5B+OK+%5D;%C2%A0%C2%A0%3E+MISI%C3%93N%3A+APROBAR+POO+%C2%B7+EN+CURSO+%E2%96%88;%C2%A0;%C2%A0" alt="Baticomputadora: registro animado cargando el expediente del Grupo 1">
</div>

### 🎯 Objetivos de la misión

- **Modelar clases de dominio robustas**: `Punto`, `Zona`, `Sistemazonas` y `Main`[cite: 20, 22].
- **Gestionar geometrías circulares**: Registrar centros $(x, y)$ con radios estrictamente positivos, calcular áreas, perímetros y distancias[cite: 22].
- **Clasificar puntos y detectar superposiciones**: Determinar si un punto está en el interior, borde o exterior de una zona, e identificar solapamientos entre áreas[cite: 22].
- **Construir un menú interactivo**: Manejar excepciones, entradas con `Scanner` y validaciones estrictas contra duplicados[cite: 20, 22].

> [!TIP]
> **Lema del equipo:** «Si lo puedes modelar en clases, lo puedes programar».

## 🦇 La Batfamilia · Integrantes y roles

Todo gran plan de estudio necesita un equipo que lo sostenga. Estos son los integrantes del equipo que conforman la Batfamilia para este repositorio (integrantes oficiales tomados del ejemplo base de Batman):

<div align="center">
<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&amp;weight=600&amp;size=18&amp;duration=2400&amp;pause=1300&amp;color=FACC15&amp;background=0D1117&amp;center=true&amp;vCenter=true&amp;width=860&amp;height=52&amp;lines=Agente+01+%E2%80%BA+Detective+del+C%C3%B3digo+Oscuro+%E2%80%BA+Dereck+Shair;Agente+02+%E2%80%BA+Arquitecto+de+la+Baticueva+Digital+%E2%80%BA+Brishy+Anahy;Agente+03+%E2%80%BA+Caballero+del+Backend+%E2%80%BA+Fher+Dorian;Agente+04+%E2%80%BA+Guardi%C3%A1n+Nocturno+del+Testing+%E2%80%BA+Antony+Sebastian;Agente+05+%E2%80%BA+Or%C3%A1culo+del+Conocimiento+%E2%80%BA+Karina+Paola" width="100%" alt="Presentación animada de los agentes: Dereck Shair, Brishy Anahy, Fher Dorian, Antony Sebastian y Karina Paola">
</div>

| N.º | BatIntegrante | BatOperaciones | BatObjetivo |
| :---: | :--- | :--- | :--- |
| **1** | **Paredes Acosta Dereck Shair** | **Detective del Código Oscuro · Investigar · Analista** | Reunir las pistas iniciales: requerimientos, reglas de negocio, validaciones y diseño inicial de clases. |
| **2** | **Ashanga Yumbo Brishy Anahy** | **Arquitecto de la Baticueva Digital · Preparar · Diseñar** | Diseñar la arquitectura de clases (`Punto`, `Zona`, `Sistemazonas`, `Main`) y estructurar el repositorio GitHub[cite: 20, 22, 30]. |
| **3** | **Calderon Carvajal Fher Dorian** | **Caballero del Backend · Construir · Programar** | Implementar los métodos de cálculo geométrico (distancias, áreas, perímetros) y la lógica de negocio en Java[cite: 20, 22]. |
| **4** | **Casillas Ochoa Antony Sebastian** | **Guardián Nocturno del Testing · Inspeccionar · Probar** | Comprobar el código con los cinco casos de prueba obligatorios, manejo de errores y validación de límites[cite: 20, 30]. |
| **5** | **Sanchez Bastidas Karina Paola** | **Oráculo del Conocimiento · Archivar · Documentar** | Redactar la documentación técnica en `docs/` (`analisis.md`, `casos_prueba.md`) y el reporte de commits. |

**La mejor herramienta de la Baticueva sigue siendo trabajar juntos.**

## 🔎 Protocolo de la Baticueva · Clases y fases

Estructura de archivos y clases implementadas para cumplir con los requerimientos de la prueba práctica:

```text
Prueba-POO-Grupo-1/
┣ 📂 src/
┃ ┣ 📜 Main.java
┃ ┣ 📜 Punto.java
┃ ┗ 📜 Zona.java
┃ ┗ 📜 Sistemazonas.java
┣ 📂 docs/
┃ ┣ 📜 analisis.md
┃ ┣ 📜 casos_prueba.md
┃ ┗ 📜 diagrama_clases.png
┣ 📜 .gitignore
┗ 📜 README.md
