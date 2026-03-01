package edu.grinnell.csc207.inheritance;

/** An accountant. */
public class Accountant extends EmployeeAbstract {

    /**
     * Constructs a new accountant
     * @param name the accountant's name
     * @param id the accountant's ID
     */
    public Accountant(String name, String id, String prefixString) {
       super("(ACCT)", name, id);
    }
    
    @Override
    /** @return the account's salary */
    public int getSalary() {
        return 80000;
    }

    @Override
    /** @return the account's noise */
    public String makeWorkNoise() {
        return "$$$";
    }
}