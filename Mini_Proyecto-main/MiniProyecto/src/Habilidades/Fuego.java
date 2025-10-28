package Habilidades;

import Personajes.Personaje;

/**
 * Hechizo de fuego que causa daño mágico.
 */
public class Fuego extends Habilidad {

    public Fuego() {
        super("Fuego", 25, 10);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        int dano = poder + usuario.getAtaque();
        System.out.println("🔥 " + usuario.getNombre() + " lanza " + nombre + " sobre " + objetivo.getNombre() +
                " causando " + dano + " de daño mágico.");
        objetivo.recibirDano(dano);
    }
}




