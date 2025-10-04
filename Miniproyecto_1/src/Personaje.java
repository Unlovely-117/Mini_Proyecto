public abstract class Personaje {
    protected string nombre;
    protected int hpMax;
    protected int hpActual;
    protected int mpMax;
    protected int mpActual;
    protected int ataque;
    protected int defensa;
    protected int velocidad;
    protected boolean vivo = true;
    protected int edad;

    public Personaje(string nombre, int hpMax, int mpMax, int ataque, int defensa, int velocidad) {
        this.nombre = nombre;
        this.hpMax = hpActual = hpMax;
        this.mpMax = mpActual = mpMax;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.edad = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public int getHpActual() {
        return hpActual;
    }
    public int getHpMax() {
        return hpMax;
    }
    public int getMpActual() {
        return mpActual;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public boolean isVivo() {
        return vivo;
    }
    public int getEdad() {
        return edad;
    }
}

