package edu.grinnell.csc207.inheritance;

import java.util.List;

/**
 * An abstract manager.
 */
public abstract class ManagerAbstract extends EmployeeAbstract {

    private List<Employee> reportees;

    /**
     * Constructs a new manager.
     *
     * @param prefix the prefix string for the manager
     * @param name the manager's name
     * @param id the manager's ID
     * @param reportees the manager's direct reports
     */
    public ManagerAbstract(String prefix, String name, String id, List<Employee> reportees) {
        super(prefix, name, id);
        this.reportees = reportees;
    }

    /**
     * Returns the list of employees reporting to this manager.
     *
     * @return the list of reportees
     */
    public List<Employee> getReportees() {
        return reportees;
    }
}