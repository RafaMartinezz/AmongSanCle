package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import Menu.AñadirJugador;
import Menu.AñadirTarea;
import Menu.BorrarJugador;
import Menu.BorrarTarea;
import Menu.Jugar;
import Menu.Menu;
import Menu.TiempoMaximoRespuesta;
import Menu.VerJugadores;
import Menu.VerTareas;

/**
 * Manages a round of gameplay where players (students and impostors) are
 * assigned tasks,
 * interact with each other, and attempt to complete or hinder task progress.
 * 
 * This class maintains lists of players, tasks, impostors, and students,
 * and provides methods for gameplay logic such as assigning roles and handling
 * rounds.
 */
public class Ronda {

    /** List of all players in the game */
    List<Jugador> jugadores;

    /** List of impostor players */
    List<Impostor> impostores;

    /** List of student players */
    List<Estudiante> estudiantes;

    /** General list of available tasks in the game */
    List<Tarea> tareasGeneral;

    /** Number of impostors in the game */
    int numeroImpostores;

    /** Maximum response time allowed for tasks */
    int tiempoRespuesta;

    /** The current round number */
    int ronda = 1;

    /** Main menu for the game */
    Menu AmongSanCle;

    /**
     * Initializes a new game round with predefined impostor count, response time,
     * and menu configuration. Configures nested menus for managing tasks, players,
     * and game settings.
     */
    public Ronda() {
        jugadores = new ArrayList<>();
        impostores = new ArrayList<>();
        estudiantes = new ArrayList<>();
        tareasGeneral = new ArrayList<>();
        numeroImpostores = 2;
        tiempoRespuesta = 60;

        // Configure the menu and submenus for the game
        AmongSanCle = new Menu("AmongSanCle", SingletonScanner.getInstance(), this);
        Menu Configuracion = new Menu("Configuracion", SingletonScanner.getInstance(), this);
        Menu Tareas = new Menu("Tareas", SingletonScanner.getInstance(), this);
        Menu Jugadores = new Menu("Jugadores", SingletonScanner.getInstance(), this);
        TiempoMaximoRespuesta TiempoMax = new TiempoMaximoRespuesta("Tiempo maximo de respuesta",
                SingletonScanner.getInstance(), this);

        Tareas.addMenu(new AñadirTarea("Añadir tarea", SingletonScanner.getInstance(), this));
        Tareas.addMenu(new BorrarTarea("Eliminar tarea", SingletonScanner.getInstance(), this));
        Tareas.addMenu(new VerTareas("Ver tareas", SingletonScanner.getInstance(), this));

        Jugadores.addMenu(new AñadirJugador("Añadir jugador", SingletonScanner.getInstance(), this));
        Jugadores.addMenu(new BorrarJugador("Eliminar jugador", SingletonScanner.getInstance(), this));
        Jugadores.addMenu(new VerJugadores("Ver jugadores", SingletonScanner.getInstance(), this));

        Configuracion.addMenu(Tareas);
        Configuracion.addMenu(Jugadores);
        Configuracion.addMenu(TiempoMax);

        AmongSanCle.addMenu(Configuracion);
        AmongSanCle.addMenu(new Jugar("Jugar", SingletonScanner.getInstance(), this));
    }

    /**
     * Adds a task to the general list of tasks.
     * 
     * @param tarea the task to be added
     */
    public void agregarTarea(Tarea tarea) {
        tareasGeneral.add(tarea);
    }

    /**
     * Removes a task from the general list by its name.
     * 
     * @param nombreTarea the name of the task to be removed
     */
    public void eliminarTarea(String nombreTarea) {
        Iterator<Tarea> itTareas = tareasGeneral.iterator();
        while (itTareas.hasNext()) {
            Tarea tareaActual = itTareas.next();
            if (tareaActual.getNombre().equals(nombreTarea)) {
                itTareas.remove();
            }
        }
    }

    /**
     * Displays the names of all tasks in the general task list.
     */
    public void verTareas() {
        for (Tarea tarea : tareasGeneral) {
            System.out.println(tarea.getNombre());
        }
    }

    /**
     * Adds a player to the game.
     * 
     * @param jugador the player to add
     */
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    /**
     * Removes a player from the game by their alias.
     * 
     * @param nombreJugador the alias of the player to remove
     */
    public void eliminarJugador(String nombreJugador) {
        Iterator<Jugador> itJugadores = jugadores.iterator();
        while (itJugadores.hasNext()) {
            Jugador jugadorActual = itJugadores.next();
            if (jugadorActual.getAlias().equals(nombreJugador)) {
                itJugadores.remove();
            }
        }
    }

    /**
     * Displays the aliases of all players currently in the game.
     */
    public void verJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getAlias());
        }
    }

    /**
     * Sets the maximum response time for tasks.
     * 
     * @param tiempoRespuesta the new maximum response time
     */
    public void setTiempoRespuesta(int tiempoRespuesta) {
        this.tiempoRespuesta = tiempoRespuesta;
    }

    /**
     * Begins the gameplay loop. Assigns tasks randomly to players,
     * divides them into students and impostors, and manages game rounds.
     */
    public void jugar() {

        // Assigns 5 random tasks from the general list to each player
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < 5; i++) {
                int numeroRandom = (int) (Math.random() * tareasGeneral.size());
                jugador.añadirTarea(tareasGeneral.get(numeroRandom));
            }
        }

        // Randomly selects players to assign as impostors
        int[] numerosRandom = new int[numeroImpostores];
        for (int i = 0; i < numerosRandom.length; i++) {
            numerosRandom[i] = (int) (Math.random() * (jugadores.size() - 1));
        }

        // Assigns selected players as impostors, others as students
        for (int i = 0; i < numerosRandom.length; i++) {
            Impostor impostor = new Impostor(jugadores.get(numerosRandom[i]).getAlias(),
                    jugadores.get(numerosRandom[i]).getTareas());
            impostores.add(impostor);
            jugadores.remove(numerosRandom[i]);
        }

        // Converts remaining players to students
        for (Jugador jugador : jugadores) {
            Estudiante estudiante = new Estudiante(jugador.getAlias(), jugador.getTareas());
            estudiantes.add(estudiante);
        }

        // Game loop continues until impostors and students reach equal numbers or other
        // end conditions
        while (estudiantes.size() > impostores.size()) {
            System.out.println("Ronda " + ronda);

            // Check if impostors are in the same room as students, and potentially
            // eliminate them
            for (Impostor impostor : impostores) {
                Iterator<Estudiante> itEstudiantes = estudiantes.iterator();
                while (itEstudiantes.hasNext()) {
                    Estudiante estudiante = itEstudiantes.next();
                    if (impostor.habitacion().equals(estudiante.habitacion())) {
                        if (Math.random() < 0.5) {
                            System.out.println(estudiante.getAlias() + " ha sido eliminado");
                            impostor.eliminarEstudiante(estudiante);
                            itEstudiantes.remove();
                        }
                    }
                }
            }

            // Display completed tasks for each student
            for (Estudiante estudiante : estudiantes) {
                System.out.println("El estudiante " + estudiante.getAlias() + " ha realizado la tarea "
                        + estudiante.completarTarea());
            }

            // Display completed tasks for each impostor
            for (Impostor impostor : impostores) {
                System.out.println(
                        "El impostor " + impostor.getAlias() + " ha realizado la tarea " + impostor.completarTarea());
            }

            // Check if all students have completed their tasks
            boolean tareasAcabadas = estudiantes.stream().allMatch(e -> e.getTareas().isEmpty());
            if (tareasAcabadas) {
                System.out.println("Los estudiantes han ganado");
                break;
            }

            // Ask user to expel a player and check if they are an impostor
            System.out.println("A quien quieres expulsar?");
            SingletonScanner scanner = SingletonScanner.getInstance();
            String aliasExpulsado = scanner.next();

            impostores.removeIf(impostor -> impostor.getAlias().equals(aliasExpulsado));
            estudiantes.removeIf(estudiante -> estudiante.getAlias().equals(aliasExpulsado));

            ronda++;
        }

        if (impostores.size() == estudiantes.size()) {
            System.out.println("Los impostores han ganado");
        }

        AmongSanCle.ejecutar();
    }

    /**
     * Entry point to start a sample game round with predefined tasks and players.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String args[]) {
        Ronda ronda = new Ronda();

        // Sample tasks
        ronda.agregarTarea(new Tarea("Recoger todos los cables", "Informatica"));
        // Other sample tasks...

        // Sample players
        ronda.agregarJugador(new Jugador("Pablo"));
        // Other sample players...

        ronda.AmongSanCle.ejecutar();
        ronda.jugar();
    }
}
