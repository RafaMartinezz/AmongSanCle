package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that displays the list of tasks in the current game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to retrieve and show the tasks' details.
 */
public class VerTareas extends ComponenteMenu {

    /**
     * Constructs a VerTareas menu component with a specified name, scanner, and
     * game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) from which task information will
     *               be displayed
     */
    public VerTareas(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to display the list of tasks.
     * Calls the {@link Ronda#verTareas()} method to print each task's details
     * and then returns control to the parent menu.
     */
    @Override
    public void ejecutar() {
        System.out.println("Tareas:");
        System.out.println("-----------");
        this.ronda.verTareas(); // Displays the list of tasks in the game round
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
