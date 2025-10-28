//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

package Principal;

import GUI.VentanaCombate;
import Personajes.*;
import java.util.List;

public class Main {
    static void main(String[] args) {
        Heroe heroe = new Heroe("Héroe", 120, 40, 25, 10, 15);
        Heroe yangus = new Heroe("Yangus", 150, 20, 35, 15, 10);
        Heroe jessica = new Heroe("Jessica", 90, 70, 15, 8, 18);
        Heroe angelo = new Heroe("Angelo", 110, 60, 20, 12, 16);

        Enemigo slime = new Enemigo("Slime", 80, 0, 15, 5, 10);
        Enemigo espectro = new Enemigo("Espectro", 100, 40, 20, 10, 14);
        Enemigo golem = new Enemigo("Gólem", 180, 0, 40, 25, 9);
        MiniJefe dragon = new MiniJefe("Dragón Infernal", 250, 50, 45, 25, 12);

        List<Personaje> heroes = List.of(heroe, yangus, jessica, angelo);
        List<Personaje> enemigos = List.of(slime, espectro, golem, dragon);

        new VentanaCombate(heroes, enemigos).setVisible(true);
    }
}
