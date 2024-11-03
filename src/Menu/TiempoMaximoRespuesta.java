package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that allows the user to set the maximum response time for the
 * game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to update the maximum allowed response time.
 */
public class TiempoMaximoRespuesta extends ComponenteMenu {

    /**
     * Constructs a TiempoMaximoRespuesta menu component with a specified name,
     * scanner, and game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) whose response time will be
     *               updated
     */
    public TiempoMaximoRespuesta(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to update the maximum response time.
     * Prompts the user to enter a new maximum response time, updates the game round
     * with this value,
     * confirms the change, and then returns control to the parent menu.
     */
    @Override
    public void ejecutar() {
        System.out.println("Cual es el tiempo maximo de respuesta?");
        int tiempoMaximo = sc.nextInt(); // Reads the new maximum response time from user input
        this.ronda.setTiempoRespuesta(tiempoMaximo); // Updates the response time in the game round
        System.out.println("Tiempo maximo de respuesta cambiado"); // Confirms the change
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
