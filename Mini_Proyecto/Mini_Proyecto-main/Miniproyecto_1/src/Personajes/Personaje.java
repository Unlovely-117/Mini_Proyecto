package Personajes;

import Habilidades.Habilidad;
import java.util.LinkedList;

public abstract class Personaje {
    protected final String nombre;
    protected int hp, mp, ataque, defensa, velocidad, hpmax;
    protected boolean vivo = true;
    protected LinkedList<Habilidad> habilidades = new LinkedList<>();

    public Personaje(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.hpmax = hp;
        this.mp = mp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }

    public String getNombre() { return nombre; }
    public int getVelocidad() { return velocidad; }
    public boolean estaVivo() { return vivo; }
    public int getAtaque() { return ataque; }
    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }
    public LinkedList<Habilidad> getHabilidades() {return habilidades;}

    public void recibirDano(int dano) {
        hp -= dano;
        if (hp <= 0) {
            hp = 0;
            vivo = false;
        }
        System.out.println(nombre + " recibe " + dano + " de daño. Vida restante: " + hp + "/" + hpmax);
    }

    public void curar(int cantidad) {
        hp += cantidad;
        if (hp > hpmax) hp = hpmax;
        System.out.println(nombre + " recupera " + cantidad + " puntos de vida. Vida actual: " + hp + "/" + hpmax);
    }

    @Override
    public String toString() {
        return nombre + " (HP: " + hp + "/" + hpmax + ")";
    }

    public abstract void atacar(Personaje objetivo);
}


