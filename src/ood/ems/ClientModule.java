package com.github.ancabanca.interviewprep.ood.ems;

public class ClientModule {
	EmployeeDAO dao;
    EmployeeReportFormatter formatter;

	public ClientModule() {
		dao = new EmployeeDAO();
	}

	public void hireNewEmployee(String name) {
		Employee e = new Employee(name);
        dao.addEmployee(e);
	}

    public void terminateEmployee(long id) {
        Employee e = dao.getEmployee(id);
        dao.removeEmployee(e);
    }

    public void printEmployeeReport(long id, FormatType format) {
        Employee e = dao.getEmployee(id);
        String report = formatter.getReport(e, format);
        System.out.println(report);
    }
}