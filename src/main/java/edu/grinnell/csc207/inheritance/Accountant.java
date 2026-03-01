package edu.grinnell.csc207.inheritance;

/**
 * An accountant.
 */
public class Accountant extends EmployeeAbstract {

    /**
     * Constructs a new accountant.
     *
     * @param name the accountant's name
     * @param id the accountant's ID
     * @param prefixString the prefix string for the accountant
     */
    public Accountant(String name, String id, String prefixString) {
        super("(ACCT)", name, id);
    }

    /**
     * Returns the accountant's salary.
     *
     * @return the accountant's salary
     */
    @Override
    public int getSalary() {
        return 80000;
    }

    /**
     * Returns the accountant's work noise.
     *
     * @return the accountant's work noise
     */
    @Override
    public String makeWorkNoise() {
        return "$$$";
    }
}