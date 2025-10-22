package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    public Employee employee = new Employee(0, "Brandin", "Front Desk", 50, 4);
    public double testTime = 12.5;

    @Test
    void punchIn() {
        employee.punchIn(testTime);

        assertTrue(employee.getTotalPay() != 0);
    }

    @Test
    void punchOut() {
        employee.punchOut(testTime);

        assertTrue(employee.getRegularHours() == employee.getRegularHours() + employee.getOvertimeHours());
    }
}