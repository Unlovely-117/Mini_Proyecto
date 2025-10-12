package Combate;

import Personajes.Personaje;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Combate {
    private List<Personaje> heroes;
    private List<Personaje> enemigos;
    private Scanner scanner = new Scanner(System.in);

    public Combate(List<Personaje> heroes, List<Personaje> enemigos) {
        this.heroes = new ArrayList<>(heroes);
        this.enemigos = new ArrayList<>(enemigos);
    }

    public void iniciarCombate() {
        System.out.println("⚔️ ¡El combate comienza!\n");

        while (heroesVivos() && enemigosVivos()) {
            // Ordenar por velocidad
            List<Personaje> ordenTurno = new ArrayList<>();
            ordenTurno.addAll(heroes);
            ordenTurno.addAll(enemigos);
            ordenTurno.sort(Comparator.comparingInt(Personaje::getVelocidad).reversed());

            // Iterar por cada personaje en orden
            for (Personaje p : ordenTurno) {
                if (!p.estaVivo()) continue;

                if (heroes.contains(p)) {
                    // Turno de héroe controlado por jugador
                    turnoHeroe(p);
                } else {
                    // Turno de enemigo controlado por IA
                    turnoEnemigo(p);
                }

                // Revisar si el combate terminó
                if (!enemigosVivos()) {
                    System.out.println("\n🎉 ¡Los héroes han ganado!");
                    return;
                } else if (!heroesVivos()) {
                    System.out.println("\n💀 ¡Los enemigos han triunfado!");
                    return;
                }
            }
        }
    }

    private void turnoHeroe(Personaje heroe) {
        System.out.println("\n⭐ Turno de " + heroe.getNombre());
        System.out.println("1. Atacar");
        System.out.println("2. Pasar turno");
        System.out.print("👉 Elige una acción: ");

        int opcion = obtenerOpcion();
        switch (opcion) {
            case 1 -> {
                mostrarEnemigos();
                System.out.print("Selecciona enemigo: ");
                int index = obtenerOpcion() - 1;
                if (index >= 0 && index < enemigos.size() && enemigos.get(index).estaVivo()) {
                    heroe.atacar(enemigos.get(index));
                } else {
                    System.out.println("⚠️ Enemigo inválido, turno perdido.");
                }
            }
            default -> System.out.println(heroe.getNombre() + " decide esperar.");
        }
    }

    private void turnoEnemigo(Personaje enemigo) {
        // Enemigo ataca al primer héroe vivo
        Personaje objetivo = heroes.stream().filter(Personaje::estaVivo).findFirst().orElse(null);
        if (objetivo != null) {
            System.out.println("\n🔥 Turno del enemigo " + enemigo.getNombre());
            enemigo.atacar(objetivo);
        }
    }

    private boolean heroesVivos() {
        return heroes.stream().anyMatch(Personaje::estaVivo);
    }

    private boolean enemigosVivos() {
        return enemigos.stream().anyMatch(Personaje::estaVivo);
    }

    private void mostrarEnemigos() {
        System.out.println("\n👹 Enemigos disponibles:");
        for (int i = 0; i < enemigos.size(); i++) {
            Personaje e = enemigos.get(i);
            System.out.println((i + 1) + ". " + e.getNombre() + " (HP: " + (e.estaVivo() ? e.toString() : "Derrotado") + ")");
        }
    }

    private int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }
}

