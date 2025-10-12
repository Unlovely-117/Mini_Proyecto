package Habilidades;

import Personajes.Personaje;

public class Fuego extends Habilidad {

    public Fuego() {
        super("Fuego", 10, 5); // nombre, poder, costoMP
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        if (usuario.getMp() < getCostoMP()) {
            System.out.println(usuario.getNombre() + " no tiene suficiente MP para usar " + getNombre() + ".");
            return;
        }

        usuario.setMp(usuario.getMp() - getCostoMP());

        int dano = objetivo.getAtaque() + usuario.getAtaque(); // usa el getPoder() de la clase Habilidad
        System.out.println(usuario.getNombre() + " lanza " + getNombre() +
                " sobre " + objetivo.getNombre() + ", causando " + dano + " de daño.");

        objetivo.recibirDano(dano);
    }
}



