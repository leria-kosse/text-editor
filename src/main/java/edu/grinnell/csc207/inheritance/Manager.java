package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A manager. */
public class Manager extends ManagerAbstract {

    
    public Manager(String name, String id, List<Employee> reportees) {
        super("(MGR)", name, id, reportees);
    }

    @Override
    /** @return the manager's salary. */
    public int getSalary() {
        return 120000 * 3;
    }

    @Override
    /** @return the manager's work noise. */
    public String makeWorkNoise() {
        return "Do Work Do Work Do Work";
    }

}
