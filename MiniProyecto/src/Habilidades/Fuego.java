package Habilidades;

import Personajes.Personaje;

public class Fuego extends Habilidad {

    public Fuego() {
        super("Fuego", 10, 5); // nombre, poder, costoMP
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {

        //Verifica si el usuario tiene MP
        if (usuario.getMp() < getCostoMP()) {
            System.out.println(usuario.getNombre() + " no tiene suficiente MP para usar " + getNombre() + ".");
            return;
        }

        //Resta el costo de MP al usuario
        usuario.setMp(usuario.getMp() - getCostoMP());

        //Calcula el daño total
        int dano = objetivo.getAtaque() + usuario.getAtaque(); // usa el getPoder() de la clase Habilidad

        //Mensaje del ataque
        System.out.println(usuario.getNombre() + " lanza " + getNombre() +
                " sobre " + objetivo.getNombre() + ", causando " + dano + " de daño.");

        //Aplica el daño al objetivo
        objetivo.recibirDano(dano);
    }
}



