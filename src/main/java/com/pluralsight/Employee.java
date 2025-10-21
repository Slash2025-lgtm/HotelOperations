package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private int employeeId;
    private String name, department;
    private double payRate, hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getTotalPay() {
        double regularPay = this.payRate * this.getRegularHours();

        double overtimePay = (this.payRate * 1.5) * this.getOvertimeHours();

        return regularPay + overtimePay;
    }

    public double getRegularHours() {
        if (this.hoursWorked <= 40) {
            return this.hoursWorked;
        } else {
            return 40;
        }
    }

    public double getOvertimeHours() {
        if (this.hoursWorked > 40) {
            return this.hoursWorked - 40;
        } else {
            return 0;
        }
    }

    public String punchIn(double time) {
        String newTime = "";
        String[] timeList = String.valueOf(time).split("[.]");
        String hours = timeList[0];
        String minutes = timeList[1];
        int valueOfMinutes = Integer.valueOf(minutes);
        if (valueOfMinutes > 59) {
            newTime = "Error The time you entered is invalid";
        } else {
            if (valueOfMinutes > 9) {
                newTime = hours + ":" + minutes;
            } else {
                newTime = hours + ":" + minutes + "0";
            }

        }
        return newTime;
    }

    public double punchOut(double time) {
        return time;
    }
}