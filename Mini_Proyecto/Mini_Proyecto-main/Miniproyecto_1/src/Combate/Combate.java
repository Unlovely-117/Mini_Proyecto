package Combate;

import Habilidades.Habilidad;
import Personajes.Personaje;
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.Scanner;

public class Combate {
    private final List<Personaje> equipo1;
    private final List<Personaje> equipo2;
    private final Scanner scanner = new Scanner(System.in);

    public Combate(List<Personaje> equipo1, List<Personaje> equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void iniciarCombate() {
        LinkedList<Personaje> todos = new LinkedList<>();
        todos.addAll(equipo1);
        todos.addAll(equipo2);

        // Ordena todos los personajes por velocidad (de mayor a menor)
        todos.sort(Comparator.comparingInt(Personaje::getVelocidad).reversed());

        System.out.println("¡Comienza el combate!\n");

        while (equipoVivo(equipo1) && equipoVivo(equipo2)) {
            for (Personaje p : todos) {
                if (!p.estaVivo()) continue;

                // Determinar enemigos
                List<Personaje> enemigos = equipo1.contains(p) ? equipo2 : equipo1;
                if (!equipoVivo(enemigos)) break;

                // --- MENÚ DE TURNO ---
                int opcion = mostrarMenuTurno(p);

                // --- SELECCIÓN DE OBJETIVO ---
                Personaje objetivo = seleccionarObjetivo(enemigos);
                if (objetivo == null) continue;

                // --- ACCIÓN SEGÚN OPCIÓN ---
                if (opcion == 1) {
                    p.atacar(objetivo);
                } else {
                    usarHabilidad(p, objetivo);
                }

                if (!objetivo.estaVivo()) {
                    System.out.println(objetivo.getNombre() + " ha sido derrotado.");
                }
            }
        }

        System.out.println("\n" + (equipoVivo(equipo1) ? "¡Equipo 1 gana!" : "¡Equipo 2 gana!"));
    }

    // Verifica si hay al menos un personaje vivo en el equipo
    private boolean equipoVivo(List<Personaje> equipo) {
        for (Personaje p : equipo) {
            if (p.estaVivo()) return true;
        }
        return false;
    }

    // MENÚ DE TURNO
    private int mostrarMenuTurno(Personaje p) {
        int opcion = 0;
        do {
            System.out.println("\n====================================");
            System.out.println("          Turno de " + p.getNombre());
            System.out.println("====================================");
            System.out.println("1. Atacar normal");
            System.out.println("2. Usar habilidad");
            System.out.print("Elige una opción (1-2): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion < 1 || opcion > 2) {
                    System.out.println("Opción inválida, intenta de nuevo.");
                }
            } else {
                System.out.println("Debes ingresar un número.");
                scanner.nextLine(); // limpiar entrada inválida
            }
        } while (opcion < 1 || opcion > 2);
        return opcion;
    }

    // SELECCIÓN DE OBJETIVO
    private Personaje seleccionarObjetivo(List<Personaje> enemigos) {
        Personaje objetivo = null;
        do {
            System.out.println("\nElige objetivo:");
            for (int i = 0; i < enemigos.size(); i++) {
                System.out.println((i + 1) + ". " + enemigos.get(i).getNombre());
            }
            System.out.print("Opción (1-" + enemigos.size() + "): ");

            if (scanner.hasNextInt()) {
                int eleccion = scanner.nextInt();
                scanner.nextLine();
                if (eleccion >= 1 && eleccion <= enemigos.size()) {
                    objetivo = enemigos.get(eleccion - 1);
                } else {
                    System.out.println("Selección inválida, intenta de nuevo.");
                }
            } else {
                System.out.println("Debes ingresar un número.");
                scanner.nextLine(); // limpiar entrada inválida
            }
        } while (objetivo == null);
        return objetivo;
    }

    // USO DE HABILIDAD
    private void usarHabilidad(Personaje p, Personaje objetivo) {
        if (p.getHabilidades().isEmpty()) {
            System.out.println(p.getNombre() + " no tiene habilidades.");
            return;
        }

        Habilidad habilidadSeleccionada = null;
        do {
            System.out.println("\nElige habilidad:");
            for (int i = 0; i < p.getHabilidades().size(); i++) {
                Habilidad h = p.getHabilidades().get(i);
                System.out.println((i + 1) + ". " + h.getNombre() + " (Costo MP: " + h.getCostoMP() + ")");
            }
            System.out.print("Opción (1-" + p.getHabilidades().size() + "): ");

            if (scanner.hasNextInt()) {
                int eleccion = scanner.nextInt();
                scanner.nextLine();
                if (eleccion >= 1 && eleccion <= p.getHabilidades().size()) {
                    habilidadSeleccionada = p.getHabilidades().get(eleccion - 1);
                } else {
                    System.out.println("Selección inválida, intenta de nuevo.");
                }
            } else {
                System.out.println("Debes ingresar un número.");
                scanner.nextLine(); // limpiar entrada inválida
            }
        } while (habilidadSeleccionada == null);

        if (p.getMp() < habilidadSeleccionada.getCostoMP()) {
            System.out.println("No tienes suficiente MP para usar esta habilidad.");
            return;
        }

        p.setMp(p.getMp() - habilidadSeleccionada.getCostoMP());
        habilidadSeleccionada.usar(p, objetivo);
    }
}

