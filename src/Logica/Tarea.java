package Logica;

/**
 * Represents a task within the game, with each task having a specific name and
 * associated room.
 * Tasks are assigned to players, who complete them in different rooms.
 */
public class Tarea {

    /** The name of the task */
    private String nombre;

    /** The room where the task is located */
    private String habitacion;

    /**
     * Constructs a new task with a specified name and room.
     *
     * @param nombre     the name of the task
     * @param habitacion the room where the task must be completed
     */
    public Tarea(String nombre, String habitacion) {
        this.nombre = nombre;
        this.habitacion = habitacion;
    }

    /**
     * Gets the name of the task.
     *
     * @return the name of the task
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Gets the room where the task is located.
     *
     * @return the room associated with the task
     */
    public String getHabitacion() {
        return habitacion;
    }

    /**
     * Returns a string representation of the task, including its name and room.
     *
     * @return a formatted string describing the task
     */
    @Override
    public String toString() {
        return nombre + " en la habitacion " + habitacion;
    }
}
