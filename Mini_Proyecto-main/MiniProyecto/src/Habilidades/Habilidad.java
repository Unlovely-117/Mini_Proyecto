package Habilidades;

import Personajes.Personaje;

/**
 * Clase base para todas las habilidades del juego.
 */
public class Habilidad {
    protected final String nombre;
    protected final int poder;
    protected final int costoMP;

    public Habilidad(String nombre, int poder, int costoMP) {
        this.nombre = nombre;
        this.poder = poder;
        this.costoMP = costoMP;
    }

    public String getNombre() { return nombre; }
    public int getCostoMP() { return costoMP; }

    /**
     * Usa la habilidad: por defecto inflige daño físico simple.
     */
    public void usar(Personaje usuario, Personaje objetivo) {
        int dano = poder + usuario.getAtaque();
        System.out.println(usuario.getNombre() + " usa " + nombre + " contra " + objetivo.getNombre() +
                " causando " + dano + " de daño.");
        objetivo.recibirDano(dano);
    }
}




