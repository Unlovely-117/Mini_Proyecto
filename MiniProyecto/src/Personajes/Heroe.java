package Personajes;

import Habilidades.*;
import java.util.Scanner;

public class Heroe extends Personaje {
    //Escanea la decision del jugador durante el combate
    private final Scanner scanner = new Scanner(System.in);

    public Heroe(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        //Agrega habilidades al inicializar al héroe
        super(nombre, hp, mp, ataque, defensa, velocidad);
        habilidades.add(new AtaqueBasico());
        habilidades.add(new Fuego());
        habilidades.add(new Curar());
    }

    //Controlador de turnos de ataque del héroe
    @Override
    public void atacar(Personaje objetivo) {
        System.out.println("\nTurno de " + nombre);
        System.out.println("1. Ataque físico");
        System.out.println("2. Usar habilidad mágica");
        System.out.println("3. Pasar turno");
        System.out.print("Elige una opción: ");
        int opcion = obtenerOpcion();

        switch (opcion) {
            case 1 -> habilidades.getFirst().usar(this, objetivo); // Ataque físico
            case 2 -> usarMagia(objetivo);
            default -> System.out.println(nombre + " decide esperar.");
        }
    }

    //Permite elegir al jugador y usar sus habilidades mágicas
    private void usarMagia(Personaje objetivo) {
        System.out.println("\nHabilidades disponibles:");
        for (int i = 1; i < habilidades.size(); i++) {
            System.out.println(i + ". " + habilidades.get(i).getNombre() +
                    " (Costo MP: " + habilidades.get(i).getCostoMP() + ")");
        }
        System.out.print("Elige una habilidad: ");
        int eleccion = obtenerOpcion();

        if (eleccion >= 1 && eleccion < habilidades.size()) {
            Habilidad habilidad = habilidades.get(eleccion);

            //Verifica si el héroe tiene suficiente MP antes de usar la habilidad
            if (mp >= habilidad.getCostoMP()) {
                mp -= habilidad.getCostoMP();
                habilidad.usar(this, objetivo); //Ejecuta la habilidad seleccionada
            } else {
                System.out.println("No tienes suficiente MP para usar " + habilidad.getNombre());
            }
        } else {
            System.out.println("Opción invalida.");
        }
    }


    //Método auxiliar para obtener la opcion numerica del jugador
    private int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
    }
}






