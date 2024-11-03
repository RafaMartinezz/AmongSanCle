package Menu;

import Logica.Jugador;
import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that allows the user to add a new player to the game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to create and add a new {@link Jugador}.
 */
public class AñadirJugador extends ComponenteMenu {

    /**
     * Constructs an AñadirJugador menu component with a specified name, scanner,
     * and game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) to which the player will be
     *               added
     */
    public AñadirJugador(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to add a new player.
     * Prompts the user for the player's name, creates a new {@link Jugador} with
     * that name,
     * adds it to the current game round, and confirms the addition.
     * Once the action is completed, it returns to the parent menu.
     */
    @Override
    void ejecutar() {
        System.out.println("Cual es el nombre del jugador?");
        String nombreJugador = sc.nextLine(); // Reads the player's name from user input
        this.ronda.agregarJugador(new Jugador(nombreJugador)); // Adds the new player to the round
        System.out.println("Jugador añadido"); // Confirms that the player was added
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
