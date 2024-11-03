package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that allows the user to delete a player from the game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to remove a {@link Jugador} based on the provided name.
 */
public class BorrarJugador extends ComponenteMenu {

    /**
     * Constructs a BorrarJugador menu component with a specified name, scanner, and
     * game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) from which the player will be
     *               removed
     */
    public BorrarJugador(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to delete a player.
     * Prompts the user for the player's name, removes the player from the current
     * game round,
     * and confirms the deletion. Once the action is completed, it returns to the
     * parent menu.
     */
    @Override
    public void ejecutar() {
        System.out.println("Cual es el nombre del jugador?");
        String nombreJugador = sc.nextLine(); // Reads the player's name from user input
        this.ronda.eliminarJugador(nombreJugador); // Removes the player from the round
        System.out.println("Jugador borrado"); // Confirms that the player was deleted
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
