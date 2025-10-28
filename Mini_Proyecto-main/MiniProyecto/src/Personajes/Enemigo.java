package Personajes;

import Habilidades.Habilidad;
import Habilidades.AtaqueBasico;
import java.util.Random;

/**
 * Enemigo: IA simple que elige una habilidad al azar.
 */
public class Enemigo extends Personaje {

    protected final Random rand = new Random();

    public Enemigo(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        habilidades.add(new AtaqueBasico());
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (!estaVivo()) return;

        if (dormido) {
            System.out.println(nombre + " está dormido y no puede atacar.");
            intentarDespertar();
            return;
        }

        // Escoge habilidad aleatoria entre las disponibles
        Habilidad h = habilidades.get(rand.nextInt(habilidades.size()));
        h.usar(this, objetivo);
    }
}


