package Menu;

import java.util.ArrayList;
import java.util.List;
import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Represents a menu that can contain multiple sub-menu options (children),
 * allowing for
 * hierarchical navigation. This class extends {@link ComponenteMenu} and can
 * hold and
 * execute other {@link ComponenteMenu} items.
 */
public class Menu extends ComponenteMenu {

    /** List of sub-menu components contained within this menu */
    protected List<ComponenteMenu> hijos = new ArrayList<>();

    /**
     * Constructs a Menu with a specified name, scanner, and game round.
     *
     * @param nombre the name of this menu
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) with which this menu will
     *               interact
     */
    public Menu(String nombre, SingletonScanner sc, Ronda ronda) {
        super(nombre, sc, ronda);
    }

    /**
     * Displays the menu and its options, allowing the user to select and execute
     * a sub-menu option or exit the menu.
     * 
     * If the user selects the exit option, control is passed back to the parent
     * menu
     * if it exists, or the program exits if there is no parent menu.
     */
    @Override
    public void ejecutar() {
        System.out.println("Menú " + this.nombre);
        System.out.println("-----------");

        // Displays each sub-menu option
        for (int i = 0; i < hijos.size(); i++) {
            System.out.println(i + ". " + hijos.get(i).nombre);
            // Adds an "Exit" option at the end of the menu
            if (i == hijos.size() - 1) {
                System.out.println((i + 1) + ". Salir");
            }
        }

        // Prompt for user input
        System.out.println("Teclea número opcion");
        int opcion = sc.nextInt();

        // Handles the exit option
        if (opcion == hijos.size() && this.padre != null) {
            this.padre.ejecutar(); // Return to parent menu
        } else if (opcion == hijos.size() && this.padre == null) {
            System.out.println("Chao"); // Exit the application
        } else {
            hijos.get(opcion).ejecutar(); // Execute the chosen menu option
        }
    }

    /**
     * Adds a new sub-menu component to this menu and sets this menu as its parent.
     *
     * @param nuevoarchivo the {@link ComponenteMenu} to add as a sub-menu option
     */
    public void addMenu(ComponenteMenu nuevoarchivo) {
        nuevoarchivo.padre = this; // Sets this menu as the parent of the new component
        this.hijos.add(nuevoarchivo); // Adds the new component to the list of children
    }
}
