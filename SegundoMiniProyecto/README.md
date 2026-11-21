<div align="center">
    # ⚡🔥 Pokémon TCG Univalle 💧🔮 
 
### Simulación con interfaz gráfica del *Pokémon TCG Pocket* — expansión **Genetic Apex**
 
![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk&logoColor=white)
![Interfaz](https://img.shields.io/badge/Interfaz-Swing-blue)
![Curso](https://img.shields.io/badge/Curso-Programaci%C3%B3n%20Orientada%20a%20Eventos-green)
 
*Mini Proyecto 2 — Programación Orientada a Eventos · Universidad del Valle (Tuluá)*
 
</div>
---
 
## 📖 Descripción
 
**Pokémon TCG Univalle** es un juego de cartas para dos jugadores que comparten el mismo computador y juegan por turnos. Modela las mecánicas esenciales de la primera expansión de *Pokémon TCG Pocket*, **Genetic Apex**: armar un mazo, robar cartas, adjuntar energía, jugar cartas de entrenador, mantener un banco de Pokémon, retirar, **evolucionar** y atacar.
 
Este Mini Proyecto 2 continúa el [Mini Proyecto 1](#) con dos cambios:
 
- 🖼️ **Interfaz gráfica de escritorio en Java Swing**: el juego deja la consola. Los nombres, los mazos y todas las acciones se manejan con ventanas, botones y diálogos (ya no se lee nada por `Scanner`/`System.in`).
- 🌱 **Mecánica de evolución**: se agregan 7 cartas de evolución (Fase 1 y Fase 2) y la acción **Evolucionar Pokémon**.
El proyecto está construido con **Java 21 estándar** (sin librerías externas). El modelo (`logica`) no importa `javax.swing` ni `java.awt`; la interfaz vive en el paquete `vista`.
 
 
## 👥 Integrantes
 
| Integrante | Código |
|---|---|
| Juan José Palma | 2569091 |
| Sara Sofía Arcila | 2569267 |
| Samuel Zamora | 2569223 |
| Johan Henao | 2569195 |
 
---
 
## 🚀 Instrucciones de ejecución
 
### Requisitos
 
- **JDK 21** o superior (`java -version` y `javac -version` deben mostrar 21+).
- Un entorno con pantalla (la interfaz es una aplicación de escritorio Swing).
### 1. Clonar el repositorio
 
```bash
git clone https://github.com/johxnx2/PokemonProject2.git
cd PokemonProject2
```
 
### 2. Compilar
 
> Las imágenes se cargan desde el *classpath* con la ruta `/imagenes/...`, así que deben quedar copiadas dentro de `bin`.
 
**Linux / macOS**
 
```bash
javac -encoding UTF-8 -d bin $(find src -name "*.java")
cp -r src/Imagenes bin/imagenes
```
 
**Windows (PowerShell)**
 
```powershell
javac -encoding UTF-8 -d bin (Get-ChildItem -Recurse src -Filter *.java).FullName
Copy-Item src\Imagenes bin\imagenes -Recurse
```
 
### 3. Ejecutar
 
```bash
java -cp bin logica.App
```
 
> 💡 **Con NetBeans / VS Code:** abre la carpeta del proyecto y ejecuta `App.java` (el código fuente está en `src` y las imágenes en `src/Imagenes`).
 
---
 
## 🎮 Cómo se juega
 
1. En la **ventana de inicio** cada jugador escribe su **nombre** y elige uno de los **3 mazos predefinidos** (Agua, Fuego o Rayo). El botón **VER MAZOS** muestra su contenido. Si falta algún dato, se muestra un mensaje de error y no se avanza.
2. Se reparte una mano inicial de **5 cartas**. Si no hay ningún Pokémon **básico**, se hace **mulligan** (una carta de evolución no evita el mulligan).
3. Cada jugador coloca un **Pokémon activo** y, opcionalmente, hasta **2 Pokémon en el banco**. Desde la mano solo se pueden colocar **Pokémon básicos**: una carta de evolución solo entra en juego evolucionando.
4. En el **tablero** se ve el turno actual, el campo propio y el del rival (Pokémon activo y banco con su barra de PS y energías), los puntos de premio (x/3), la mano del jugador actual (una carta = un botón) y un **registro de eventos** con lo que va pasando.
5. En su turno, el jugador activo puede (con botones y diálogos; las acciones inválidas muestran un mensaje que explica por qué):
| Botón | Acción | Descripción |
|:-:|---|---|
| ADJUNTAR ENERGIA | Adjuntar energía de zona | Adjunta la energía del turno a un Pokémon propio (activo o banco). |
| ENTRENADOR | Jugar carta de entrenador | Objetos ilimitados; soportes, máximo 1 por turno. |
| BANCO | Colocar Pokémon en banco | Si hay espacio disponible. |
| ACTIVO | Colocar / retirar Pokémon activo | Retirar cuesta energías descartadas según el costo de retirada. |
| EVOLUCIONAR | Evolucionar Pokémon | Coloca una evolución de la mano sobre un Pokémon en juego (ver reglas abajo). |
| ATACAR | Atacar | Una sola vez por turno; si el Pokémon es ex y alcanza la energía de ambos ataques, se elige cuál usar. |
| PASAR TURNO | Pasar turno | Cede el turno al rival. |
 
### 🌱 Reglas de evolución
 
- Una **Fase 1** se coloca sobre su Pokémon básico; una **Fase 2** solo sobre su Fase 1. No se puede saltar de básico a Fase 2.
- **Ningún jugador puede evolucionar en su primer turno**, ni evolucionar un Pokémon que entró en juego ese mismo turno. Cada Pokémon evoluciona **una sola vez por turno**.
- Se puede evolucionar varios Pokémon distintos en un turno y **atacar después de evolucionar**.
- Al evolucionar, el Pokémon **conserva las energías y el daño recibido**; sus PS máximos pasan a ser los de la evolución (ej.: Charmander con 20/60 PS evoluciona a Charmeleon y queda con 50/90 PS). Tipo, ataques y costo de retirada pasan a ser los de la evolución.
- Las evoluciones **no son Pokémon-ex**: al ser derrotadas otorgan 1 punto de premio. **Poké Ball** sigue buscando solo Pokémon básicos.
### 🏆 Condiciones de victoria
 
- Acumular **3 puntos de premio** (1 por Pokémon derrotado, **2** si es Pokémon-ex).
- Que el rival **no pueda robar** carta al inicio de su turno (mazo vacío).
- Que el rival **se quede sin Pokémon** en juego (ni activo ni banco).
Al terminar se anuncia el ganador con un mensaje.
 
### ⚔️ Debilidades (+20 de daño)
 
Cada ataque define contra qué tipo recibe **+20 de daño** adicional:
 
| Atacante | Defensor débil |
|:-:|:-:|
| Fuego 🔥 | Agua 💧 |
| Agua 💧 | Fuego 🔥 |
| Eléctrico ⚡ | Agua 💧 |
| Psíquico 🔮 | Incoloro ☆ |
 
---
 
## 🃏 Cartas implementadas
 
### Pokémon básicos
 
| Pokémon | Tipo | PS | Ataque 1 | Ataque 2 |
|---|:-:|:-:|---|---|
| Pikachu | ⚡ Eléctrico | 60 | Mordisco (1) — 20 | — |
| Charmander | 🔥 Fuego | 60 | Ascuas (2) — 30 | — |
| Squirtle | 💧 Agua | 60 | Placaje (1) — 20 | — |
| Jigglypuff | ☆ Incoloro | 70 | Golpe (1) — 20 | — |
| Magikarp | 💧 Agua | 30 | Golpe (2) — 10 | — |
| Snorlax | ☆ Incoloro | 150 | Golpe Cuerpo (3) — 100 | — |
| **Mewtwo ex** | 🔮 Psíquico | 150 | Ataque Psíquico (2) — 50 | Psicorrayo (3) — 150 |
| **Zapdos ex** | ⚡ Eléctrico | 130 | Picotazo (2) — 30 | Tormenta Eléctrica (3) — 90 |
| **Moltres ex** | 🔥 Fuego | 130 | Aleteo (1) — 30 | Danza Infernal (3) — 70 |
| **Articuno ex** | 💧 Agua | 130 | Viento Helado (1) — 30 | Ventisca (3) — 100 |
 
### 🌱 Pokémon de evolución (nuevo en MP2)
 
| Pokémon | Etapa | Evoluciona de | Tipo | PS | Retirada | Ataque |
|---|:-:|---|:-:|:-:|:-:|---|
| Raichu | Fase 1 | Pikachu | ⚡ Eléctrico | 100 | 1 | Trueno (2) — 60 |
| Charmeleon | Fase 1 | Charmander | 🔥 Fuego | 90 | 2 | Garra Ígnea (2) — 50 |
| Charizard | Fase 2 | Charmeleon | 🔥 Fuego | 150 | 2 | Giro Fuego (4) — 120 |
| Wartortle | Fase 1 | Squirtle | 💧 Agua | 80 | 1 | Salpicadura (2) — 40 |
| Blastoise | Fase 2 | Wartortle | 💧 Agua | 150 | 3 | Hidrobomba (3) — 100 |
| Wigglytuff | Fase 1 | Jigglypuff | ☆ Incoloro | 110 | 2 | Bofetón (2) — 50 |
| Gyarados | Fase 1 | Magikarp | 💧 Agua | 150 | 4 | Hiperrayo (4) — 100 |
 
> El número entre paréntesis es el costo del ataque en energías.
 
### Entrenadores
 
| Carta | Tipo | Efecto |
|---|:-:|---|
| Investigación del Profesor | Soporte | Descarta tu mano y roba 2 cartas del mazo. |
| Poción | Objeto | Cura 20 PS al Pokémon elegido. |
| Poké Ball | Objeto | Busca en tu mazo 1 Pokémon básico (no ex, no evolución) y ponlo en tu mano. |
| Turbo Velocidad | Objeto | Reduce en 1 el costo de retirada del Pokémon activo este turno. |
| Misty | Soporte | Adjunta 3 energías a uno de tus Pokémon de Agua. |
 
---
 
## 🗂️ Mazos predefinidos
 
Cada mazo tiene **20 cartas**, con **máximo 2 copias** de cada una y al menos **6 Pokémon básicos** (las evoluciones no cuentan como básicos). Cada mazo incluye las líneas de evolución de sus Pokémon.
 
| Mazo | Pokémon | Entrenadores |
|:-:|---|---|
| **Agua** 💧 | Squirtle, Magikarp, Articuno ex, Wartortle, Blastoise, Gyarados | Misty, Poké Ball, Poción, Turbo Velocidad |
| **Fuego** 🔥 | Charmander, Moltres ex, Jigglypuff, Snorlax, Charmeleon, Charizard, Wigglytuff | Poké Ball, Poción, Turbo Velocidad |
| **Rayo** ⚡ | Pikachu, Zapdos ex, Mewtwo ex, Jigglypuff, Raichu, Wigglytuff | Poké Ball, Poción, Turbo Velocidad, Inv. del Profesor |
 
---
 
## 🧱 Estructura del código
 
```text
src
├── logica                         → MODELO (sin javax.swing ni java.awt)
│   ├── App.java                   → punto de entrada (main): abre la ventana de inicio
│   ├── Juego.java                 → reglas y flujo de la partida
│   ├── Jugador.java               → mazo, mano, banco, Pokémon activo, energía y puntos
│   ├── Ataque.java                → nombre, costo, daño y bono por debilidad
│   ├── CreadorMazosPDefecto.java  → fábrica de los 3 mazos predefinidos
│   ├── Carta.java                 → clase abstracta base de toda carta
│   ├── TipoCarta.java             → enum: POKEMON, ENTRENADOR
│   ├── TipoElementos.java         → enum: FUEGO, AGUA, ELECTRICO, PSIQUICO, INCOLORO
│   ├── pokemones
│   │   ├── Pokemon.java           → clase abstracta (PS, tipo, energía, ataques, retirada)
│   │   ├── Pikachu, Charmander, Squirtle, Jigglypuff, Magikarp, Snorlax,
│   │   │   Mewtwo, Zapdos, Moltres, Articuno
│   │   └── Evo
│   │       ├── PokemonEvo.java    → abstracta: "evoluciona de" y validación
│   │       ├── Fase1.java, Fase2.java
│   │       └── Raichu, Charmeleon, Charizard, Wartortle, Blastoise, Wigglytuff, Gyarados
│   └── CartasEntrenador
│       ├── CartaEntrenador.java   → clase abstracta (soporte/objeto, ActivarCarta)
│       └── InvestProfe, Pocion, Pokebola, TurboVelocidad, Misty
├── vista                          → INTERFAZ GRÁFICA (Swing)
│   ├── VentanaInicioPokemon.java  → nombres, selección de mazo (JComboBox), VER MAZOS e INICIAR
│   ├── VentanaJuego.java          → tablero: campos, PS (JProgressBar), mano, botones y registro
│   └── PanelConFondo.java         → panel con imagen de fondo
└── Imagenes                       → imágenes de las cartas y fondos
```
 
```text
                  Carta  (abstracta)
                 /                  \
        Pokemon (abstracta)     CartaEntrenador (abstracta)
         /          \                     │
 10 básicos     PokemonEvo (abstracta)   5 entrenadores concretos
                   /        \
          Fase1 (abstracta)  Fase2 (abstracta)
          /   |   |   |   \          /      \
   Raichu Charmeleon Wartortle     Charizard  Blastoise
   Wigglytuff Gyarados
```
 
Algunos puntos donde se usa POO:
 
- **Herencia:** `Carta` → `Pokemon` → `PokemonEvo` → `Fase1` / `Fase2` → evoluciones concretas. Las etapas se reflejan en la jerarquía y reutilizan los atributos y métodos de `Pokemon` (PS, energía, daño, ataques, retirada) sin duplicar lógica.
- **Polimorfismo:** `Fase1` y `Fase2` implementan `puedeEvolucionarSobre(...)` con su propia regla (una Fase 1 solo sobre un básico, una Fase 2 solo sobre una Fase 1) y cada entrenador sobrescribe `ActivarCarta()`.
- **Encapsulamiento:** atributos privados o protegidos con getters y setters, por ejemplo en `Jugador` y `Pokemon`.
- **Separación modelo–vista:** `logica` contiene las cartas y el jugador; `vista` los muestra y reacciona a los eventos de los botones.
---
 
## 🌿 Flujo de trabajo en GitHub
 
- La entrega final se encuentra en la rama **`main`**.
- Cada integrante trabajó en su propia rama (`palma`, `saraA`, `samuelZ`, `johanH`) y se integró con Pull Requests.
- Se usan commits pequeños y descriptivos.
---
 
<div align="center">
Hecho con ☕ y Java
</div>
 
