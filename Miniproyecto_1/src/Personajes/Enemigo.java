package Personajes;

import Habilidades.AtaqueBasico;
import Habilidades.Habilidad;
import java.util.Random;

public class Enemigo extends Personaje {

    public Enemigo(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        habilidades.add(new AtaqueBasico());
    }

    @Override
    public void atacar(Personaje objetivo) {
        Random rand = new Random();
        Habilidad habilidad = habilidades.get(rand.nextInt(habilidades.size()));
        habilidad.usar(this, objetivo);
    }
}

