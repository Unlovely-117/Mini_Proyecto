//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Combate.Combate;
import Personajes.Heroe;
import Personajes.Enemigo;
import Personajes.Personaje;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Heroe heroe = new Heroe("Héroe", 120, 30, 25, 10, 15);
        Heroe jessica = new Heroe("Jessica", 100, 50, 18, 8, 20);

        Enemigo slime = new Enemigo("Slime", 70, 0, 10, 5, 12);
        Enemigo dragon = new Enemigo("Dragón", 150, 20, 30, 15, 10);

        // 👉 Combate recibe listas de tipo List<Personaje>
        Combate combate = new Combate(
                List.of(heroe, jessica),
                List.of(slime, dragon)
        );

        combate.iniciarCombate();
    }
}

