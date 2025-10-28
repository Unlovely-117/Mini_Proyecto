package Combate;

import GUI.VentanaCombate;
import Personajes.*;
import java.util.*;

/**
 * Sistema de combate estilo Dragon Quest VIII.
 * Compatible con modo consola y con interfaz gráfica (GUI).
 */
public class Combate {

    private final List<Heroe> heroes;
    private final List<Enemigo> enemigos;
    private VentanaCombate ventana;
    private boolean enCombateGUI = false;

    // --- Constructor modo consola ---
    public Combate(List<Heroe> heroes, List<Enemigo> enemigos) {
        this.heroes = heroes;
        this.enemigos = enemigos;
    }

    // --- Constructor modo GUI (acepta cualquier tipo de lista de personajes) ---
    public Combate(List<? extends Personaje> listaHeroes, List<? extends Personaje> listaEnemigos, VentanaCombate ventana) {
        this.heroes = new ArrayList<>();
        this.enemigos = new ArrayList<>();

        // Convierte dinámicamente a héroes y enemigos
        for (Personaje p : listaHeroes) {
            if (p instanceof Heroe h) this.heroes.add(h);
        }
        for (Personaje p : listaEnemigos) {
            if (p instanceof Enemigo e) this.enemigos.add(e);
        }

        this.ventana = ventana;
        this.enCombateGUI = true;
    }

    // --- Inicia el combate ---
    public void iniciarCombate() {
        if (enCombateGUI) bucleCombateGUI();
        else bucleCombateConsola();
    }

    // ====== MODO CONSOLA ======
    private void bucleCombateConsola() {
        System.out.println("\n⚔️ ¡Comienza el combate! ⚔️\n");

        while (equipoVivo(heroes) && equipoVivo(enemigos)) {
            for (Heroe h : heroes) {
                if (!h.estaVivo()) continue;
                System.out.println("\n--- Turno de " + h.getNombre() + " ---");
                System.out.println("1. Atacar  2. Magia  3. Curar  4. Pasar");
                System.out.print("Elige una opción: ");
                int opcion = leerEntero();

                switch (opcion) {
                    case 1 -> atacar(h);
                    case 2 -> usarMagia(h);
                    case 3 -> h.curar(20);
                    case 4 -> System.out.println(h.getNombre() + " pasa su turno.");
                }
            }

            for (Enemigo e : enemigos) {
                if (e.estaVivo()) turnoEnemigo(e);
            }
        }

        System.out.println(equipoVivo(heroes)
                ? "\n🎉 ¡Has ganado el combate! 🎉"
                : "\n💀 Todos los héroes han caído...");
    }

    // ====== MODO GUI ======
    private void bucleCombateGUI() {
        ventana.registrarEvento("⚔️ ¡Comienza el combate!");
        while (equipoVivo(heroes) && equipoVivo(enemigos)) {
            for (Heroe h : heroes) {
                if (!h.estaVivo()) continue;
                ventana.setTurnoActual(h);
                ventana.registrarEvento("🧙 Turno de " + h.getNombre());
                esperarAccionJugador();
                ventana.actualizarEstado();
                if (!equipoVivo(enemigos)) break;
            }

            for (Enemigo e : enemigos) {
                if (!e.estaVivo()) continue;
                ventana.registrarEvento("💢 Turno del enemigo " + e.getNombre());
                turnoEnemigo(e);
                ventana.actualizarEstado();
                if (!equipoVivo(heroes)) break;
            }
        }

        ventana.registrarEvento(equipoVivo(heroes)
                ? "🎉 ¡Victoria! ¡Has ganado el combate!"
                : "💀 Derrota... Fin del juego");
    }

    // --- Método llamado desde la GUI ---
    public void ejecutarAccion(Personaje p, String tipoAccion) {
        if (!(p instanceof Heroe h)) return;

        switch (tipoAccion.toLowerCase()) {
            case "ataque" -> {
                Enemigo e = elegirEnemigoAleatorio();
                h.atacar(e);
                ventana.registrarEvento(h.getNombre() + " ataca a " + e.getNombre());
            }
            case "habilidad" -> {
                Enemigo e = elegirEnemigoAleatorio();
                h.usarHabilidadEspecial(e);
                ventana.registrarEvento(h.getNombre() + " usa magia en " + e.getNombre());
            }
            case "pasar" -> ventana.registrarEvento(h.getNombre() + " decide no hacer nada.");
        }

        synchronized (this) { this.notify(); }
    }

    // --- Esperar acción del jugador (modo GUI) ---
    private void esperarAccionJugador() {
        synchronized (this) {
            try { this.wait(); } catch (InterruptedException ignored) {}
        }
    }

    // --- Turno enemigo (IA simple) ---
    private void turnoEnemigo(Enemigo e) {
        Heroe objetivo = heroes.stream().filter(Heroe::estaVivo).findAny().orElse(null);
        if (objetivo == null) return;
        e.atacar(objetivo);
        ventana.registrarEvento(e.getNombre() + " ataca a " + objetivo.getNombre());
    }

    // --- Selección aleatoria de enemigo ---
    private Enemigo elegirEnemigoAleatorio() {
        List<Enemigo> vivos = enemigos.stream().filter(Enemigo::estaVivo).toList();
        return vivos.isEmpty() ? enemigos.getFirst() : vivos.get(new Random().nextInt(vivos.size()));
    }

    // --- Verifica si un equipo sigue vivo ---
    private boolean equipoVivo(List<? extends Personaje> equipo) {
        return equipo.stream().anyMatch(Personaje::estaVivo);
    }

    // --- Ataques y magia para héroes ---
    private void atacar(Heroe h) {
        Enemigo e = elegirEnemigoAleatorio();
        h.atacar(e);
    }

    private void usarMagia(Heroe h) {
        Enemigo e = elegirEnemigoAleatorio();
        h.usarHabilidadEspecial(e);
    }

    // --- Entrada del jugador ---
    private int leerEntero() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 1 && n <= 4) return n;
            } catch (Exception ignored) {}
            System.out.print("Opción inválida, intenta de nuevo: ");
        }
    }
}
