package edu.grinnell.csc207.inheritance;

/**
 * An abstract employee.
 */
public abstract class EmployeeAbstract implements Employee {

    private String name;
    private String id;

    /**
     * Constructs a new abstract employee.
     *
     * @param prefix the prefix string for the employee
     * @param name the employee's name
     * @param id the employee's ID
     */
    public EmployeeAbstract(String prefix, String name, String id) {
        this.name = prefix + " " + name;
        this.id = id;
    }

    /**
     * Returns the employee's name.
     *
     * @return the employee's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the employee's ID.
     *
     * @return the employee's ID
     */
    @Override
    public String getId() {
        return id;
    }
}