package Personajes;

import Habilidades.*;

/**
 * Clase Heroe: representa a un personaje controlado por el jugador.
 * Contiene habilidades básicas, de fuego y curación.
 */
public class Heroe extends Personaje {

    public Heroe(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        // orden: 0 -> AtaqueBasico, 1 -> Fuego, 2 -> Curar
        habilidades.add(new AtaqueBasico());
        habilidades.add(new Fuego());
        habilidades.add(new Curar());
    }

    @Override
    public void atacar(Personaje objetivo) {
        habilidades.getFirst().usar(this, objetivo);
    }

    public void usarHabilidadEspecial(Personaje objetivo) {
        if (habilidades.size() > 1) {
            Habilidad magia = habilidades.get(1); // Fuego
            if (mp >= magia.getCostoMP()) {
                mp -= magia.getCostoMP();
                magia.usar(this, objetivo);
            } else {
                System.out.println("No tienes suficiente MP para lanzar " + magia.getNombre());
            }
        } else {
            System.out.println("No tienes habilidades mágicas.");
        }
    }
}







