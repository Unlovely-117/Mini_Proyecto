package Habilidades;

import Personajes.Personaje;

public class Habilidad {
    private final String nombre;
    private final int poder;
    private final int costoMP;

    public Habilidad(String nombre, int poder, int costoMP) {
        this.nombre = nombre;
        this.poder = poder;
        this.costoMP = costoMP;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoMP() {
        return costoMP;
    }

    public void usar(Personaje usuario, Personaje objetivo) {
        int dano = poder + usuario.getAtaque();
        objetivo.recibirDano(dano);
        System.out.println(usuario.getNombre() + " usa " + nombre + " contra " + objetivo.getNombre() +
                " causando " + dano + " de daño.");
    }
}


