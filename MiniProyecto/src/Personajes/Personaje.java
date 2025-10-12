package Personajes;

import Habilidades.Habilidad;
import java.util.LinkedList;

//--- Atributos principales ---
public abstract class Personaje {
    protected final String nombre;
    protected int hp, mp, ataque, defensa, velocidad, hpmax;
    protected boolean vivo = true;
    protected LinkedList<Habilidad> habilidades = new LinkedList<>();

    /**
     *Constructor del personaje
     * Se inicializan las estadisticas basicas de combate
     *
     */
    public Personaje(String nombre, int hp, int mp, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hp = hp;
        this.hpmax = hp;
        this.mp = mp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
    }
    // Metodos Getters y Setters
    public String getNombre() { return nombre; }
    public int getVelocidad() { return velocidad; }
    public boolean estaVivo() { return vivo; }
    public int getAtaque() { return ataque; }
    public int getMp() { return mp; }
    public void setMp(int mp) { this.mp = mp; }
    public LinkedList<Habilidad> getHabilidades() {return habilidades;}

    /**
     * Aplica daño al personaje y actualiza estado
     * Si la vida es =< 0, se marca como Muerto
     * También se imprime un mensaje con informacion de la vida restante
     */

    public void recibirDano(int dano) {
        hp -= dano; //Resta el daño recibido
        if (hp <= 0) {
            hp = 0;
            vivo = false; // Se marca el personaje como derrotado
        }
        System.out.println(nombre + " recibe " + dano + " de daño. Vida restante: " + hp + "/" + hpmax);
    }


    /**
     * Restaura una cantidad de vida al personaje
     * No permite que la vida actual supere la vida maxima
     * y se muestra por consola la cantidad de curacion que recibe el personaje y la vida actual
     *
     */

    public void curar(int cantidad) {
        hp += cantidad;
        if (hp > hpmax) hp = hpmax;
        System.out.println(nombre + " recupera " + cantidad + " puntos de vida. Vida actual: " + hp + "/" + hpmax);
    }

    @Override
    public String toString() {
        return nombre + " (HP: " + hp + "/" + hpmax + ")";
    }

    //Método abstracto
    public abstract void atacar(Personaje objetivo);
}


