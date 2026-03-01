package edu.grinnell.csc207.inheritance;

import java.util.List;

/** A CEO. */
public class CEO extends ManagerAbstract {

    public CEO(String name, String id, List<Employee> reportees) {
        super("(CEO)", name, id, reportees);
    }
    
    @Override
    /** @return the CEO's salary. */
    public int getSalary() {
        return 80000 * 100;
    }

    @Override
    /** @return the CEO's work noise. */
    public String makeWorkNoise() {
        return "Do More Work More Do More Work More Do More Work";
    }

}
