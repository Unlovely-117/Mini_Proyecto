package Habilidades;

import Personajes.Personaje;

/**
 * Hechizo que intenta dormir al enemigo (50% de probabilidad).
 */
public class Dormir extends Habilidad {

    public Dormir() {
        super("Dormir", 0, 8);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        System.out.println("💤 " + usuario.getNombre() + " lanza " + nombre + " sobre " + objetivo.getNombre() + "...");
        if (Math.random() < 0.5) {
            objetivo.dormir();
        } else {
            System.out.println("Pero " + objetivo.getNombre() + " resistió el hechizo.");
        }
    }
}

