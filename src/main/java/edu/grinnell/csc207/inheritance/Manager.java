package edu.grinnell.csc207.inheritance;

import java.util.List;

/**
 * A manager.
 */
public class Manager extends ManagerAbstract {

    /**
     * Constructs a new manager.
     *
     * @param name the manager's name
     * @param id the manager's ID
     * @param reportees the list of employees reporting to the manager
     */
    public Manager(String name, String id, List<Employee> reportees) {
        super("(MGR)", name, id, reportees);
    }

    /**
     * Returns the manager's salary.
     *
     * @return the manager's salary
     */
    @Override
    public int getSalary() {
        return 120000 * 3;
    }

    /**
     * Returns the manager's work noise.
     *
     * @return the manager's work noise
     */
    @Override
    public String makeWorkNoise() {
        return "Do Work Do Work Do Work";
    }
}