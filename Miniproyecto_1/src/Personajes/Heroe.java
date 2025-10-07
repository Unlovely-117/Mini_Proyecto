package Personajes;

import Habilidades.AtaqueBasico;
import Habilidades.Habilidad;
import java.util.Random;

public class Heroe extends Personaje {

    public Heroe(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);
        habilidades.add(new AtaqueBasico());
    }

    @Override
    public void atacar(Personaje objetivo) {
        if (habilidades.isEmpty()) {
            System.out.println(nombre + " no tiene habilidades disponibles.");
            return;
        }

        Random rand = new Random();
        Habilidad habilidad = habilidades.get(rand.nextInt(habilidades.size()));
        System.out.println(nombre + " prepara una acción...");
        habilidad.usar(this, objetivo);
    }
}



