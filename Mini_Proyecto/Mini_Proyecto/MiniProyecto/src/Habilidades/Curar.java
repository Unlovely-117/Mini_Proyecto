package Habilidades;

import Personajes.Personaje;

public class Curar extends Habilidad {

    public Curar() {
        super("Curar", 8, 0); // nombre, poder, costoMP (Curar no gasta MP)
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        //cantidad de curacion se basa en el ataque del usuario + poder base
        int curacion = usuario.getAtaque() + 10;

        //mensaje del efecto de la habilidad
        System.out.println(usuario.getNombre() + " usa 💚 " + getNombre() + " y recupera " + curacion + " HP");

        //Aplica la curacion al personaje
        usuario.curar(curacion);
    }
}


