package Habilidades;

import Personajes.Personaje;

/**
 * Hechizo de curación que restaura vida.
 */
public class Curar extends Habilidad {

    public Curar() {
        super("Curar", 15, 5);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        int curacion = poder + usuario.getAtaque();
        System.out.println("💚 " + usuario.getNombre() + " usa " + nombre + " y restaura " + curacion + " puntos de vida.");
        objetivo.curar(curacion);
    }
}



