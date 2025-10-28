package Personajes;

import Habilidades.Habilidad;
import java.util.LinkedList;

/**
 * Clase base para héroes y enemigos.
 * Define los atributos y comportamientos comunes.
 */
public abstract class Personaje {
    protected final String nombre;
    protected int hp, mp, ataque, defensa, velocidad, hpmax;
    protected boolean vivo = true;
    protected boolean dormido = false;
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

    // === Getters y Setters ===
    public String getNombre() { return nombre; }
    public int getVelocidad() { return velocidad; }
    public boolean estaVivo() { return vivo; }
    public int getHp() { return hp; }
    public int getHpMax() { return hpmax; }
    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }
    public int getAtaque() { return ataque; }
    public LinkedList<Habilidad> getHabilidades() { return habilidades; }
    public boolean estaDormido() { return dormido; }

    // === Estado "Dormir" ===
    public void dormir() {
        dormido = true;
        System.out.println(nombre + " se ha quedado dormido...");
    }

    public void intentarDespertar() {
        if (!dormido) return;
        if (Math.random() < 0.5) {
            dormido = false;
            System.out.println(nombre + " se ha despertado!");
        } else {
            System.out.println(nombre + " sigue dormido...");
        }
    }

    // === Combate ===
    public void recibirDano(int dano) {
        int danoReal = Math.max(1, dano - defensa / 2);
        hp -= danoReal;
        if (hp <= 0) {
            hp = 0;
            vivo = false;
            System.out.println(nombre + " ha sido derrotado.");
        } else {
            System.out.println(nombre + " recibe " + danoReal + " de daño. Vida restante: " + hp + "/" + hpmax);
        }
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

    // === Métodos abstractos / personalizables ===
    public abstract void atacar(Personaje objetivo);

    // Método opcional (no obligatorio para enemigos)
    public void usarHabilidadEspecial(Personaje objetivo) {
        // Por defecto no hace nada, solo lo usan los héroes
    }
}




