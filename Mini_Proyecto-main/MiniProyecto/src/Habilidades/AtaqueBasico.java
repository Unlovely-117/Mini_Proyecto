package Habilidades;

import Personajes.Personaje;

/**
 * Ataque físico básico sin coste de MP.
 */
public class AtaqueBasico extends Habilidad {

    public AtaqueBasico() {
        super("Ataque básico", 10, 0);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        int dano = usuario.getAtaque() + poder;
        System.out.println(usuario.getNombre() + " ataca físicamente a " + objetivo.getNombre() +
                " causando " + dano + " de daño.");
        objetivo.recibirDano(dano);
    }
}


