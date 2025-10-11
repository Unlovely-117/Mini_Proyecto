package Habilidades;

import Personajes.Personaje;

public class Fuego extends Habilidad {
    public Fuego() {
        super("Fuego", 10);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        int daño = usuario.getAtaque() + 15;
        System.out.println(usuario.getNombre() + " lanza 🔥 " + nombre + " sobre " + objetivo.getNombre());
        objetivo.recibirDaño(daño);
    }
}
