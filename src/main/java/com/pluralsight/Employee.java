package com.pluralsight;

import java.time.LocalDateTime;

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

    public void punchIn(double time) {
        this.startTime = time;
    }

    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        this.startTime = now.getHour() + (now.getMinute() / 60);
    }

    public void punchOut(double time) {
        this.hoursWorked += (time - this.startTime);
        this.startTime = -1;
    }

    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        this.hoursWorked += ((now.getHour() + (now.getMinute() / 60)) - this.startTime);
        this.startTime = -1;
    }
}