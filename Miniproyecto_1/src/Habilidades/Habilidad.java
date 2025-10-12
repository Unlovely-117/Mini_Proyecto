package Habilidades;

import Personajes.Personaje;

public abstract class Habilidad {
    protected String nombre;
    protected int costoMP;

    public Habilidad(String nombre, int costoMP) {
        this.nombre = nombre;
        this.costoMP = costoMP;
    }

    public abstract void usar(Personaje usuario, Personaje objetivo);
}

