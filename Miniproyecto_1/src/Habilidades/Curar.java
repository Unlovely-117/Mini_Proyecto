package Habilidades;

import Personajes.Personaje;

public class Curar extends Habilidad {
    public Curar() {
        super("Curar", 8);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        int curacion = usuario.getAtaque() + 10;
        System.out.println(usuario.getNombre() + " usa 💚 " + nombre + " y recupera " + curacion + " HP");
        usuario.curar(curacion);
    }
}

