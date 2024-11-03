package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Represents an impostor player in the game.
 * The Impostor has the ability to eliminate students, who are then added to a
 * list of eliminated students.
 * 
 * This class extends {@link Jugador}, inheriting properties such as alias and
 * tasks.
 */
public class Impostor extends Jugador {

    /** List of students that have been eliminated by this impostor */
    private List<Estudiante> estudiantesEliminados;

    /**
     * Constructs a new Impostor with a specified alias and a queue of tasks.
     * 
     * @param alias  the alias or username of the impostor, inherited from
     *               {@link Jugador}
     * @param tareas the queue of tasks to be completed or managed by this impostor
     */
    public Impostor(String alias, Queue<Tarea> tareas) {
        super(alias); // Calls the superclass constructor (Jugador) to initialize the alias
        this.tareas = tareas; // Sets the queue of tasks for this impostor
        this.estudiantesEliminados = new ArrayList<>(); // Initializes the list of eliminated students
    }

    /**
     * Gets the list of students that have been eliminated by the impostor.
     * 
     * @return a list of {@link Estudiante} objects representing eliminated students
     */
    public List<Estudiante> getEstudiantesEliminados() {
        return estudiantesEliminados;
    }

    /**
     * Eliminates a specified student by adding them to the list of eliminated
     * students.
     * 
     * @param estudiante the student to be eliminated, added to the list of
     *                   eliminated students
     */
    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantesEliminados.add(estudiante); // Adds the student to the eliminated students list
    }
}
