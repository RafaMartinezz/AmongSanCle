package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that starts the game round.
 * This class extends {@link ComponenteMenu} and initiates the main gameplay
 * by calling the {@link Ronda#jugar()} method.
 */
public class Jugar extends ComponenteMenu {

    /**
     * Constructs a Jugar menu component with a specified name, scanner, and game
     * round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) that will be started
     */
    public Jugar(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to start the game round.
     * Calls the {@link Ronda#jugar()} method to begin gameplay.
     */
    @Override
    public void ejecutar() {
        this.ronda.jugar(); // Starts the main game loop in the Ronda instance
    }
}
