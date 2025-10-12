# Dragon Quest VIII - Battle Simulation

## 👥 Integrantes
- David Lopez Restrepo - 2380304
- Manuela Guerrero Llanos - 2459660
- Kevin S. Bermeo Rico - 2477363

## 🚀 Ejecución
Compilar y ejecutar con:
```bash
javac src/**/*.java
java src/Main
```

---

## 📦 Estructura del Proyecto

```
Mini_Proyecto/
├── README.md
├── src/
│   ├── Main.java
│   ├── [Otras clases y paquetes...]
```

### Descripción General

Este proyecto simula batallas en el universo de Dragon Quest VIII. Implementa un sistema de combate por turnos entre personajes, enemigos y habilidades, siguiendo la lógica de los RPG clásicos.

### Componentes Principales

#### Main.java

Punto de entrada de la aplicación. Aquí se inicializa la simulación, se crean los personajes, enemigos y se gestiona el flujo principal de la batalla.

#### [Clase Personaje.java]

Define los atributos y métodos de los personajes jugables. Incluye estadísticas como vida, ataque, defensa, habilidades y lógica para realizar acciones en combate.

#### [Clase Enemigo.java]

Representa a los enemigos enfrentados por los personajes. Maneja sus propias estadísticas y acciones.

#### [Clase Habilidad.java]

Modela las distintas habilidades que pueden usar los personajes y enemigos. Permite aplicar efectos como daño, curación, estados alterados, etc.

#### [Clase Batalla.java]

Gestiona el desarrollo de la batalla, turnos, orden de acciones, aplicación de efectos y determina el resultado (victoria/derrota).

---

## 🔍 Detalle de Clases y Métodos

A continuación se detalla el funcionamiento de cada clase y sus métodos más relevantes:

### Main.java

```java
public class Main {
    public static void main(String[] args) {
        // Inicialización de personajes y enemigos
        // Configuración de la batalla
        // Ciclo principal del combate
    }
}
```
- **main:** Método principal; orquesta toda la simulación.

### Personaje.java

```java
public class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    // ...

    public void atacar(Enemigo enemigo) { ... }
    public void usarHabilidad(Habilidad habilidad, Enemigo enemigo) { ... }
    // ...
}
```
- **atacar:** Realiza un ataque estándar al enemigo.
- **usarHabilidad:** Ejecuta una habilidad sobre un objetivo.

### Enemigo.java

```java
public class Enemigo {
    private String nombre;
    private int vida;
    // ...

    public void atacar(Personaje personaje) { ... }
    // ...
}
```
- **atacar:** El enemigo realiza su acción sobre el jugador.

### Habilidad.java

```java
public class Habilidad {
    private String nombre;
    private int poder;
    // ...

    public void aplicar(Personaje objetivo) { ... }
    // ...
}
```
- **aplicar:** Ejecuta el efecto de la habilidad en el objetivo.

### Batalla.java

```java
public class Batalla {
    private List<Personaje> personajes;
    private List<Enemigo> enemigos;
    // ...

    public void iniciar() { ... }
    public void ejecutarTurno() { ... }
    public boolean batallaTerminada() { ... }
    // ...
}
```
- **iniciar:** Prepara la batalla.
- **ejecutarTurno:** Gestiona las acciones de cada participante en cada turno.
- **batallaTerminada:** Evalúa si la batalla ha finalizado.

---

## 📝 Ejemplo de Flujo de Combate

1. Se inicializan personajes y enemigos.
2. Se asignan habilidades a cada participante.
3. Se inicia la batalla.
4. Cada turno, los personajes y enemigos realizan acciones.
5. Se aplica el resultado de cada acción (daño, curación, estados).
6. El ciclo se repite hasta que uno de los bandos queda sin vida.

---

## 💡 Notas Adicionales

- El proyecto puede expandirse agregando nuevas clases como Inventario, Estado, Items, etc.
- Se recomienda comentar el código fuente para facilitar futuras modificaciones.

---

## 📚 Créditos y Licencia

Este proyecto es desarrollado con fines académicos en la Universidad del Valle.
