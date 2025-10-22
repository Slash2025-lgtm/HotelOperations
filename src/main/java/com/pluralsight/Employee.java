package com.pluralsight;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int employeeId;
    private String name, department;
    private double payRate, hoursWorked, startTime;

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

    public void punchTimeCard(double time) {
        if (this.startTime > 0) {
            this.hoursWorked += (time - this.startTime);
            this.startTime = 0;
        } else {
            this.startTime = time;
        }
    }

    public void punchTimeCard() {
        LocalTime nowTime = LocalTime.now();
        int hours = nowTime.getHour();
        int minutes = nowTime.getMinute();

        double time = Double.parseDouble(hours + "." + minutes);
        System.out.println(time);
        if (this.startTime > 0) {
            this.hoursWorked += (time - this.startTime);
            this.startTime = 0;
        } else {
            this.startTime = time;
        }
    }
}