package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Menu option that allows the user to delete a task from the game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to remove a {@link Tarea} based on the provided name.
 */
public class BorrarTarea extends ComponenteMenu {

    /**
     * Constructs a BorrarTarea menu component with a specified name, scanner, and
     * game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) from which the task will be
     *               removed
     */
    public BorrarTarea(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Executes the action to delete a task.
     * Prompts the user for the task's name, removes the task from the current game
     * round,
     * and confirms the deletion. Once the action is completed, it returns to the
     * parent menu.
     */
    @Override
    public void ejecutar() {
        System.out.println("Cual es el nombre de la tarea?");
        String nombreTarea = sc.nextLine(); // Reads the task's name from user input
        this.ronda.eliminarTarea(nombreTarea); // Removes the task from the round
        System.out.println("Tarea borrada"); // Confirms that the task was deleted
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
