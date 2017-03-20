package com.github.ancabanca.interviewprep.ood.ems;

public class Employee {
    private static long idCounter;
    private long id;
    private String name;
    private String department;
    private boolean working;

    public Employee(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Employee [id=" + id + ", name=" + name +
            ", department=" + department + ", working=" + working + "]";
    }
}