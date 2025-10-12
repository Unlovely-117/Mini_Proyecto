package Habilidades;

import Personajes.Personaje;

public class Habilidad {
    private final String nombre;
    private final int poder;
    private final int costoMP;

    //Constructora clase habilidad
    public Habilidad(String nombre, int poder, int costoMP) {
        this.nombre = nombre;
        this.poder = poder;
        this.costoMP = costoMP;
    }

    //Nombre de la habilidad
    public String getNombre() {
        return nombre;
    }

    //El coste de MP que se requiere para usar la habilidad
    public int getCostoMP() {
        return costoMP;
    }

    public void usar(Personaje usuario, Personaje objetivo) {
        int dano = poder + usuario.getAtaque();

        //Aplica el daño al objetivo
        objetivo.recibirDano(dano);

        //Muestra un mensaje del ataque
        System.out.println(usuario.getNombre() + " usa " + nombre + " contra " + objetivo.getNombre() +
                " causando " + dano + " de daño.");
    }
}


