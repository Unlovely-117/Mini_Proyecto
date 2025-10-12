# 🐉 Dragon Quest VIII - Battle Simulation

## 👥 Integrantes

* **David Lopez Restrepo** – 2380304
* **Manuela Guerrero Llanos** – 2459660
* **Kevin S. Bermeo Rico** – 2477363

---

## 🚀 Ejecución

Compilar y ejecutar desde la raíz del proyecto:

```bash
javac src/**/*.java
java src/Main
```

---

## 📦 Estructura del Proyecto

```
Mini_Proyecto/
├── README.md
└── src/
    ├── Main.java
    ├── Combate/
    │   └── Combate.java
    ├── Habilidades/
    │   ├── AtaqueBasico.java
    │   ├── Curar.java
    │   ├── Fuego.java
    │   └── Habilidad.java
    └── Personajes/
        ├── Enemigo.java
        ├── Heroe.java
        └── Personaje.java
```

---

## 🧩 Descripción General

Este proyecto es una **simulación de combate por turnos** inspirada en *Dragon Quest VIII*, desarrollada completamente en **Java** aplicando los principios de la **Programación Orientada a Objetos (POO)**.

El sistema permite crear **héroes** y **enemigos** con atributos y habilidades únicas, enfrentándolos en batallas dinámicas donde:

* El jugador elige acciones (ataques físicos, habilidades mágicas, curación o pasar turno).
* Los enemigos actúan de forma automática.
* La batalla continúa hasta que todos los héroes o enemigos sean derrotados.

---

## ⚙️ Componentes Principales

### 🧠 Main.java

Clase principal del programa.

* Contiene el método `main`, punto de entrada de la aplicación.
* Crea los personajes (héroes y enemigos).
* Lanza la simulación de combate mediante la clase `Combate`.

---

### ⚔️ Personaje.java

Clase abstracta que define la estructura básica de cualquier personaje del juego.

**Atributos:**

* `String nombre`
* `int hp` (vida)
* `int mp` (magia)
* `int ataque`
* `int defensa`
* `int velocidad`
* `boolean vivo`
* `LinkedList<Habilidad> habilidades`

**Métodos principales:**

* `recibirDano(int dano)` → Resta puntos de vida al personaje.
* `curar(int cantidad)` → Restaura puntos de vida.
* `estaVivo()` → Retorna si el personaje sigue con vida.
* `atacar(Personaje objetivo)` → Método abstracto implementado por las subclases.

---

### 🧙‍♂️ Heroe.java

Extiende la clase `Personaje`.
Representa a los personajes **controlados por el jugador**.

**Características:**

* Presenta un **menú interactivo** para elegir acciones:

  * Ataque físico
  * Usar habilidad
  * Pasar turno
* Consume **MP** al usar habilidades.
* Permite decisiones estratégicas según la situación del combate.

---

### 👹 Enemigo.java

Extiende la clase `Personaje`.
Representa a los enemigos **controlados por la CPU**.

**Características:**

* Selecciona automáticamente una habilidad de su lista.
* Puede ejecutar ataques físicos o mágicos sin intervención del jugador.
* Sirve como oponente directo del héroe en la batalla.

---

### ✨ Habilidad.java

Clase base para todas las habilidades del juego.

**Atributos:**

* `String nombre`
* `int poder`
* `int costoMP`

**Método principal:**

* `usar(Personaje usuario, Personaje objetivo)` → Aplica el efecto de la habilidad (daño, curación o efecto especial).

---

### 💥 Clases Derivadas de Habilidad

* **AtaqueBasico.java** → Realiza un ataque físico estándar.
* **Fuego.java** → Habilidad mágica ofensiva que causa daño adicional.
* **Curar.java** → Habilidad de tipo soporte que restaura puntos de vida.

---

### ⚔️ Combate.java

Controla todo el flujo de la batalla.

**Responsabilidades:**

* Iniciar el combate.
* Determinar el orden de turnos según la velocidad.
* Ejecutar las acciones seleccionadas por héroes y enemigos.
* Evaluar si la batalla ha terminado (victoria o derrota).
* Mostrar mensajes y resultados de cada turno.

---

## 🌀 Flujo de Combate

1. Se crean los héroes y enemigos.
2. Se asignan las habilidades correspondientes.
3. Se inicializa la clase `Combate`.
4. El jugador selecciona acciones en cada turno.
5. Los enemigos actúan automáticamente.
6. Se aplican los resultados (daño, curación, estados).
7. El ciclo se repite hasta que un bando sea derrotado.

---

## 💡 Posibles Extensiones

* Añadir sistema de **niveles y experiencia**.
* Implementar **inventario** y **objetos consumibles**.
* Incluir **efectos de estado** (veneno, parálisis, etc.).
* Mejorar la **interfaz visual** o integrar con una GUI.

---

## 🎓 Créditos y Licencia

Desarrollado con fines académicos para la **Universidad del Valle**.
Proyecto creado por los estudiantes del curso de **Programación Orientada a Objetos**.
