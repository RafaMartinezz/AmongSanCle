package Menu;

import Logica.Ronda;
import Logica.SingletonScanner;

/**
 * Abstract class representing a component in the menu structure. Each component
 * can execute an action and may have a parent component, enabling nested menus.
 * 
 * This class provides a base for concrete menu options that interact with the
 * {@link Ronda} instance to modify the game state.
 */
abstract class ComponenteMenu {

    /** Reference to the current game round, used to interact with game data */
    protected Ronda ronda;

    /**
     * Reference to the parent menu component, allowing navigation back up the menu
     * hierarchy
     */
    protected ComponenteMenu padre;

    /** The name of this menu component, used for display purposes */
    protected String nombre;

    /** Singleton scanner instance for reading user input */
    protected SingletonScanner sc;

    /**
     * Constructs a menu component with a specified name, scanner, and game round.
     * 
     * @param nombre the name of this menu component
     * @param sc     the {@link SingletonScanner} instance for reading user input
     * @param ronda  the game round ({@link Ronda}) that this component will
     *               interact with
     */
    protected ComponenteMenu(String nombre, SingletonScanner sc, Ronda ronda) {
        this.padre = null; // Initializes with no parent by default
        this.nombre = nombre; // Sets the name of the menu component
        this.sc = sc; // Assigns the scanner for user input
        this.ronda = ronda; // Links the component to the current game round
    }

    /**
     * Executes the action associated with this menu component.
     * Each subclass must define its specific behavior for this method.
     */
    abstract void ejecutar();
}
