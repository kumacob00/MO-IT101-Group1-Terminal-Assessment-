/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll;

/**
 *
 * @author ADMIN
 */
public class Employee {

    private String _employeeNo;
    private String _employeeName;
    private float _employeeBirthdate;

    public Employee(String employeeNo, String employeeName, float employeeBirthdate) {
        _employeeNo = employeeNo;
        _employeeName = employeeName;
        _employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeNo() {
        return _employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        _employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return _employeeName;
    }

    public void setEmployeeName(String employeeName) {
        _employeeName = employeeName;
    }

    public float getEmployeeBirthdate() {
        return _employeeBirthdate;
    }

    public void setEmployeeBirthdate(float employeeBirthdate) {
        _employeeBirthdate = employeeBirthdate;
    }

    public static void main(String[] args) {

        Employee employee = new Employee("123456789", "John Doe", 1980.0f);

        System.out.println("Employee Number: " + employee.getEmployeeNo());
        System.out.println("Employee Name: " + employee.getEmployeeName());
        System.out.println("Employee Birthdate: " + employee.getEmployeeBirthdate());
    }
}


