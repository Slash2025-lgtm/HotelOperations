package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void punchIn() {
        Employee employee = new Employee(0, "Brandin", "Front Desk", 50, 4);
        double testTime = 12.5;

        employee.punchIn(testTime);
        assertTrue(employee.getTotalPay() != 0);
    }

    @Test
    void punchOut() {
        Employee employee = new Employee(0, "Brandin", "Front Desk", 50, 4);
        double testTime = 12.5;

        employee.punchOut(testTime);
        assertTrue(employee.getRegularHours() == employee.getRegularHours() + employee.getOvertimeHours());
    }
}