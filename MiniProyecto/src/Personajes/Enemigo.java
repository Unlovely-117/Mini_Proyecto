package Personajes;

import Habilidades.AtaqueBasico;
import Habilidades.Habilidad;
import java.util.Random;

/**
 * Clase que representa a un enemigo dentro del combate.
 * Un enemigo es un tipo de personaje que actúa de manera automática (IA simple),
 * eligiendo aleatoriamente una habilidad disponible para atacar a un objetivo.
 */

public class Enemigo extends Personaje {

    //Constructor de enemigo
    public Enemigo(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        super(nombre, hp, mp, ataque, defensa, velocidad);

        //Agrega una habilidad básica por defecto para el enemigo
        habilidades.add(new AtaqueBasico());
    }

    //Método para definir como ataca el enemigo durante su turno
    @Override
    public void atacar(Personaje objetivo) {
        Random rand = new Random();

        //Se selecciona una habilidad al azar del conjunto disponible
        Habilidad habilidad = habilidades.get(rand.nextInt(habilidades.size()));
        System.out.println("\nTurno del enemigo " + nombre);

        //Ejecuta la habilidad seleccionada
        habilidad.usar(this, objetivo);
    }
}


