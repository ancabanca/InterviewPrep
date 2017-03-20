package com.github.ancabanca.interviewprep.ood.ems;

public class EmployeeReportFormatter {

    public static String getReport(Employee e, FormatType formatType) {
        switch(formatType) {
            case XML:
                return getXMLReport(e);
            case CSV:
                return getCSVReport(e);
            default:
                throw new IllegalArgumentException("Unsupported report format: " + formatType);
        }
    }
        
    public static String getXMLReport(Employee e) {
        return "<id>" + e.getId() + "</id>\n" + 
               "<name>" + e.getName() + "</name>";
    }

    public static String getCSVReport(Employee e) {
        return e.getId() + "," + e.getName();
    }
}