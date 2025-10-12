//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import Combate.Combate;
import Personajes.Enemigo;
import Personajes.Heroe;
/**
 * Clase principal del programa.
 *
 * Esta clase actúa como punto de entrada del juego.
 * Aquí se crean los personajes (héroes y enemigos),
 * se organizan los equipos y se da inicio al combate principal.
*/

void main() {

    // --- Héroes del equipo ---
    Heroe heroe = new Heroe("Héroe", 120, 40, 25, 10, 15);
    Heroe yangus = new Heroe("Yangus", 150, 20, 35, 15, 10);
    Heroe jessica = new Heroe("Jessica", 90, 70, 15, 8, 18);
    Heroe angelo = new Heroe("Angelo", 110, 60, 20, 12, 16);

    // === Configuración del combate ===
    // Se pasan las listas de héroes y enemigos al constructor de Combate
    Enemigo slime = new Enemigo("Slime", 80, 0, 15, 5, 10);
    Enemigo dragon = new Enemigo("Dragón", 200, 0, 35, 20, 8);
    Enemigo espectro = new Enemigo("Espectro", 100, 40, 20, 10, 14);
    Enemigo golem = new Enemigo("Gólem", 180, 0, 40, 25, 9);

    // === Iniciar el combate ===
    // Este metodo gestiona los turnos, ataques y habilidades de cada participante.
    Combate combate = new Combate(
            List.of(heroe, yangus, jessica, angelo),
            List.of(slime, dragon, espectro, golem)
    );

    combate.iniciarCombate();
}

