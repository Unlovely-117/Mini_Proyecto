package Personajes;

import Habilidades.Habilidad;
import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
    protected String nombre;
    protected int hp, mp, ataque, defensa, velocidad;
    protected boolean vivo = true;
    protected List<Habilidad> habilidades = new ArrayList<>();

    public Personaje(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.mp = mp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    public String getNombre() { return nombre; }
    public int getVelocidad() { return velocidad; }
    public boolean estaVivo() { return vivo; }
    public int getAtaque() {return ataque;}


    public void recibirDaño(int daño) {
        int dañoFinal = Math.max(0, daño - defensa);
        hp -= dañoFinal;
        if (hp <= 0) {
            hp = 0;
            vivo = false;
        }
        System.out.println(nombre + " recibe " + dañoFinal + " de daño. (HP: " + hp + ")");
    }
    public void curar(int cantidad) {
        hp += cantidad;
        if (hp > 999) hp = 999; // límite por estética
        System.out.println(nombre + " ahora tiene " + hp + " HP");
    }


    public abstract void atacar(Personaje objetivo);
}



