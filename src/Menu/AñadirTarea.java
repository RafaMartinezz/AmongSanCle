package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;
import Logica.Tarea;

/**
 * Menu option that allows the user to add a new task to the game round.
 * This class extends {@link ComponenteMenu} and interacts with the
 * {@link Ronda}
 * to create and add a new {@link Tarea}.
 */
public class AñadirTarea extends ComponenteMenu {

    /**
     * Constructs an AñadirTarea menu component with a specified name, scanner, and
     * game round.
     *
     * @param nombre the name of this menu option
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) to which the task will be added
     */
    public AñadirTarea(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
        this.ronda = ronda;
    }

    /**
     * Executes the action to add a new task.
     * Prompts the user for the task's name and room, creates a new {@link Tarea}
     * with these details, adds it to the current game round, and confirms the
     * addition.
     * Once the action is completed, it returns to the parent menu.
     */
    @Override
    public void ejecutar() {
        sc.nextLine(); // Clears the scanner buffer
        System.out.println("Cual es el nombre de la tarea?");
        String nombreTarea = sc.nextLine(); // Reads the task's name from user input
        System.out.println("Cual es la habitacion de la tarea?");
        String habitacionTarea = sc.nextLine(); // Reads the task's room from user input
        this.ronda.agregarTarea(new Tarea(nombreTarea, habitacionTarea)); // Adds the new task to the round
        System.out.println("Tarea añadida"); // Confirms that the task was added
        this.padre.ejecutar(); // Returns control to the parent menu
    }
}
