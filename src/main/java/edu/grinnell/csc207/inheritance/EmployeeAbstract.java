package edu.grinnell.csc207.inheritance;

public abstract class EmployeeAbstract implements Employee {

    private String name;
    private String id;

    public EmployeeAbstract(String prefix, String name, String id) {
        this.name = prefix + " " + name;
        this.id = id;

    }

    @Override
    public String getName(){
        return name;
    }

    @Override 
    public String getId(){
        return id;
    }
    
}
