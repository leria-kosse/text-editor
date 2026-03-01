package edu.grinnell.csc207.inheritance;

import java.util.List;

public abstract class ManagerAbstract extends EmployeeAbstract {

    private List<Employee> reportees;

    /**
     * Constructs a new CEO.
     *
     * @param name the CEO's name.
     * @param id the CEO's ID.
     * @param reportees the CEO's direct reports.
     */
    public ManagerAbstract(String prefix, String name, String id, List<Employee> reportees) {
        super(prefix, name, id);
        this.reportees = reportees;
    }

    
    public List<Employee> getReportees() {
        return reportees;
    }

}
