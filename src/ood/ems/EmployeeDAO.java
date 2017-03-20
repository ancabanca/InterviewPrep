package com.github.ancabanca.interviewprep.ood.ems;

public class EmployeeDAO {
    
    public Employee getEmployee(long id) {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        // connectionManager.connect();
        // connectionManager.getConnectionObject().prepareStatement("insert into employee");
        // connectionManager.disconnect();
        int connectionId = connectionManager.getConnection();
        // get employee from database
        connectionManager.closeConnection(connectionId);
        return new Employee("Mock employee");
    }

    public void addEmployee(Employee e) {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        int connectionId = connectionManager.getConnection();
        // add employee to database
        connectionManager.closeConnection(connectionId);
    }

    public void removeEmployee(Employee e) {
        DatabaseConnectionManager connectionManager = DatabaseConnectionManager.getInstance();
        int connectionId = connectionManager.getConnection();
        // remove employee from database
        connectionManager.closeConnection(connectionId);
    }
}