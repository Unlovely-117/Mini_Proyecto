package Habilidades;

import Personajes.Personaje;

public class AtaqueBasico extends Habilidad {

    public AtaqueBasico() {
        super("Ataque Básico", 0);
    }

    @Override
    public void usar(Personaje usuario, Personaje objetivo) {
        System.out.println(usuario.getNombre() + " usa " + nombre + " contra " + objetivo.getNombre());
        objetivo.recibirDaño(usuario.getAtaque());
    }
}

