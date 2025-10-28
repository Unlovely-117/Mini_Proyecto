package Personajes;

import Habilidades.*;
import java.util.Random;

/**
 * MiniJefe: enemigo más fuerte que usa magia además de ataques físicos.
 */
public class MiniJefe extends Enemigo {

    private final Random rand = new Random();

    public MiniJefe(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        habilidades.add(new Fuego());
        habilidades.add(new Dormir());
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (!estaVivo()) return;

        if (dormido) {
            System.out.println(nombre + " está dormido y no puede atacar.");
            intentarDespertar();
            return;
        }

        Habilidad habilidad = habilidades.get(rand.nextInt(habilidades.size()));
        System.out.println("\n🔥 Turno del MiniJefe " + nombre + " 🔥");
        habilidad.usar(this, objetivo);
    }
}
