package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that displays the list of players in the current game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to retrieve and show the players' names.
 */
public class VerJugadores extends ComponenteMenu {

    /**
     * Constructs a VerJugadores menu component with a specified name, scanner, and
     * game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) from which player information
     *               will be displayed
     */
    public VerJugadores(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to display the list of players.
     * Calls the {@link Ronda#verJugadores()} method to print each player's name
     * and then returns control to the parent menu.
     */
    @Override
    public void ejecutar() {
        System.out.println("Jugadores:");
        System.out.println("-----------");
        this.ronda.verJugadores(); // Displays the list of players in the game round
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
