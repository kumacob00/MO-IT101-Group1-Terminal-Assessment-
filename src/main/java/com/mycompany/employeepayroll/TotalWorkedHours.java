/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TotalWorkedHours {
    private double _totalWorkedHours;
    private String _employeeNo;
    private String _month;

    public double getTotalWorkedHours() {
        return _totalWorkedHours;
    }

    public void setEmployeeNo(String employeeNo) {
        _employeeNo = employeeNo;
    }

    public String getMonth() {
        return _month;
    }

    public void setMonth(String month) {
        _month = month;
    }

    public void _month(String[] args) {
        String month;
       
        Scanner strScanner = new Scanner(System.in);
        System.out.print("Enter month to check pay (e.g., 01 for January): ");
        month = strScanner.nextLine();

        TotalWorkedHours monthObject = new TotalWorkedHours();
        monthObject.setMonth(month);

        System.out.println("Month entered: " + monthObject.getMonth());

        strScanner.close();
    }

    public void calculateTotalHours() throws IOException, FileNotFoundException, CsvValidationException {
        String filename = "AttendanceRecord.csv";
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] header = reader.readNext();
        String[] data;
        double totalWorkedHours = 0.0;

        while ((data = reader.readNext()) != null) {
            if (data[0].equals(_employeeNo) && data[3].startsWith("2022-" + getMonth())) {
                
                System.out.println("Date: " + data[3]);
                System.out.println("Time-in: " + data[4]);
                System.out.println("Time-out: " + data[5]);
                System.out.println("# of Hours: " + data[6]);
                // Calculate total hours worked
                String[] hours = data[6].split(":");
                double hoursWorked = Double.parseDouble(hours[0]) + Double.parseDouble(hours[1]) / 60.0;
                totalWorkedHours += hoursWorked;
                _totalWorkedHours = totalWorkedHours;
            }
        }
    }
}
