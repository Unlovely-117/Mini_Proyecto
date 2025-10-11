//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Combate.Combate;
import Personajes.Heroe;
import Personajes.Enemigo;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // --- Héroes del equipo ---
        Heroe heroe = new Heroe("Héroe", 120, 40, 25, 10, 15);
        Heroe yangus = new Heroe("Yangus", 150, 20, 35, 15, 10);
        Heroe jessica = new Heroe("Jessica", 90, 70, 15, 8, 18);
        Heroe angelo = new Heroe("Angelo", 110, 60, 20, 12, 16);

        // --- Enemigos ---
        Enemigo slime = new Enemigo("Slime", 80, 0, 15, 5, 10);
        Enemigo dragon = new Enemigo("Dragón", 200, 0, 35, 20, 8);
        Enemigo espectro = new Enemigo("Espectro", 100, 40, 20, 10, 14);
        Enemigo golem = new Enemigo("Gólem", 180, 0, 40, 25, 9);

        // --- Iniciar combate ---
        Combate combate = new Combate(
                List.of(heroe, yangus, jessica, angelo),
                List.of(slime, dragon, espectro, golem)
        );

        combate.iniciarCombate();
    }
}

