package Logica;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a player in the game, characterized by an alias and a queue of
 * tasks.
 * Each player can add tasks, complete them in order, and check the location of
 * the next task.
 */
public class Jugador {

    /** Alias or username of the player */
    protected String alias;

    /** Queue of tasks assigned to the player */
    protected Queue<Tarea> tareas;

    /**
     * Constructs a new player with the specified alias and initializes an empty
     * queue of tasks.
     * 
     * @param alias the alias or username of the player
     */
    public Jugador(String alias) {
        this.alias = alias; // Sets the player's alias
        this.tareas = new LinkedList<>(); // Initializes an empty queue of tasks for the player
    }

    /**
     * Adds a new task to the player's queue.
     * 
     * @param tarea the task to be added to the queue
     */
    public void añadirTarea(Tarea tarea) {
        tareas.add(tarea); // Adds the task to the end of the queue
    }

    /**
     * Completes the next task in the queue and removes it from the queue.
     * 
     * @return the next {@link Tarea} in the queue, or null if the queue is empty
     */
    public Tarea completarTarea() {
        return tareas.poll(); // Removes and returns the task at the front of the queue
    }

    /**
     * Gets the location or room of the next task in the queue.
     * 
     * @return the room of the next task, or null if the queue is empty
     */
    public String habitacion() {
        return (tareas.peek() != null) ? tareas.peek().getHabitacion() : null; // Retrieves the room of the next task
                                                                               // without removing it
    }

    /**
     * Gets the player's alias.
     * 
     * @return the alias of the player
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Gets the queue of tasks assigned to the player.
     * 
     * @return a queue containing the player's tasks
     */
    public Queue<Tarea> getTareas() {
        return tareas;
    }
}
