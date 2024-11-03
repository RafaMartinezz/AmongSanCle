package Logica;

import java.util.Queue;

/**
 * Represents a student player in the game. 
 * Each student has an alias and a queue of tasks they must complete.
 * 
 * This class extends {@link Jugador}, inheriting its properties and behavior.
 */
public class Estudiante extends Jugador {
    
    /** Queue of tasks assigned to the student */
    private Queue<Tarea> tareas;

    /**
     * Constructs a new Estudiante with a specified alias and a queue of tasks.
     * 
     * @param alias  the alias or username of the student, inherited from {@link Jugador}
     * @param tareas the queue of tasks to be completed by this student
     */
    public Estudiante(String alias, Queue<Tarea> tareas) {
        super(alias);  // Calls the constructor of the superclass (Jugador) to set the alias
        this.tareas = tareas;  // Assigns the queue of tasks to this student's task list
    }
}
