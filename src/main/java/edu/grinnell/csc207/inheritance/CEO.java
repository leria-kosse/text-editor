package edu.grinnell.csc207.inheritance;

import java.util.List;

/**
 * A CEO.
 */
public class CEO extends ManagerAbstract {

    /**
     * Constructs a new CEO.
     *
     * @param name the CEO's name
     * @param id the CEO's ID
     * @param reportees the list of employees reporting to the CEO
     */
    public CEO(String name, String id, List<Employee> reportees) {
        super("(CEO)", name, id, reportees);
    }

    /**
     * Returns the CEO's salary.
     *
     * @return the CEO's salary
     */
    @Override
    public int getSalary() {
        return 80000 * 100;
    }

    /**
     * Returns the CEO's work noise.
     *
     * @return the CEO's work noise
     */
    @Override
    public String makeWorkNoise() {
        return "Do More Work More Do More Work More Do More Work";
    }
}