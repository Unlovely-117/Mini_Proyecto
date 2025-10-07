package Personajes;

import Habilidades.*;
import java.util.Random;
import java.util.Scanner;

public class Heroe extends Personaje {
    private Scanner scanner = new Scanner(System.in);

    public Heroe(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        habilidades.add(new AtaqueBasico());
        habilidades.add(new Fuego());
        habilidades.add(new Curar());
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println("\n⭐ Turno de " + nombre);
        System.out.println("1. Ataque físico");
        System.out.println("2. Usar habilidad mágica");
        System.out.println("3. Pasar turno");
        System.out.print("👉 Elige una opción: ");
        int opcion = obtenerOpcion();

        switch (opcion) {
            case 1 -> habilidades.get(0).usar(this, objetivo); // Ataque físico
            case 2 -> usarMagia(objetivo);
            default -> System.out.println(nombre + " decide esperar.");
        }
    }

    private void usarMagia(Personaje objetivo) {
        System.out.println("\n🔮 Habilidades disponibles:");
        for (int i = 1; i < habilidades.size(); i++) {
            System.out.println(i + ". " + habilidades.get(i).getNombre() +
                    " (Costo MP: " + habilidades.get(i).getCostoMP() + ")");
        }
        System.out.print("👉 Elige una habilidad: ");
        int eleccion = obtenerOpcion();

        if (eleccion >= 1 && eleccion < habilidades.size()) {
            Habilidad habilidad = habilidades.get(eleccion);
            if (mp >= habilidad.getCostoMP()) {
                mp -= habilidad.getCostoMP();
                habilidad.usar(this, objetivo);
            } else {
                System.out.println("⚠️ No tienes suficiente MP para usar " + habilidad.getNombre());
            }
        } else {
            System.out.println("⚠️ Opción inválida.");
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




