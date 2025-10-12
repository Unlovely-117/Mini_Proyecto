package Habilidades;

import Personajes.Personaje;

public class AtaqueBasico extends Habilidad {

    public AtaqueBasico() {
        super("Ataque Básico", 0, 0); // nombre, poder, costoMP
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        System.out.println(usuario.getNombre() + " usa " + getNombre() + " contra " + objetivo.getNombre());
        objetivo.recibirDano(usuario.getAtaque());
    }
}


