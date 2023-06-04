/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeepayroll;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EmployeePayroll {

    public static void main(String[] args) throws IOException, FileNotFoundException, CsvValidationException {
        String employeeNo;
        String month;
        Scanner strScanner = new Scanner(System.in);
        System.out.print("Enter Employee No.: ");
        employeeNo = strScanner.nextLine();
        System.out.print("Enter month to check pay (e.g., 01 for January): ");
        month = strScanner.nextLine();

        // Set the company title and sub-heading
        String companyTitle = "MOTOR PH";
        String subheading = "PAYROLL SUMMARY";

        // Print the company title and sub-heading
        System.out.println();
        System.out.println("** " + companyTitle + " **");
        System.out.println(subheading);

        EmployeeProfile _employee = new EmployeeProfile();
        _employee.DisplayEmployeeDetails(employeeNo);

        // Display the employee's number, name, birthday and hourly rate
        System.out.println("Employee Number: " + _employee.getEmployeeNo());
        System.out.println("Employee Name: " + _employee.getEmployeeName());
        System.out.println("Employee Birthdate: " + _employee.getEmployeeBirthdate());
        System.out.println("Hourly Rate: " + _employee.getHourlyRate());
     
        TotalWorkedHours hours = new TotalWorkedHours();
        hours.setEmployeeNo(employeeNo);
        hours.setMonth(month);
        hours.calculateTotalHours();

        // Prints the total worked hours in the week
        System.out.println("Total worked hours: " + hours.getTotalWorkedHours());

    double Hours = hours.getTotalWorkedHours();
    double Allowances = Double.parseDouble(_employee.getRiceSubsidy().replace(",", ""))+ Double.parseDouble(_employee.getPhoneAllowance().replace(",", "")) + Double.parseDouble(_employee.getClothingAllowance().replace("," , ""));
    double HourlyRate = Double.parseDouble(_employee.getHourlyRate());
       
    System.out.println();
        System.out.println("MONTHLY SALARY");
        
        PayCalculation.computeSalary(Hours, HourlyRate, Allowances);
        
        System.out.println("coded by: Kenneth U. MO-IT101_Gr#1");
        System.exit(0);
    }
}
