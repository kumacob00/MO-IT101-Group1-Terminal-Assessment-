/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeepayroll;

import java.time.*;
import java.time.temporal.*;
import java.util.*;
import java.util.Scanner;

public class EmployeePayroll {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
            
       Scanner strScanner = new Scanner(System.in);
       Scanner fltScanner = new Scanner(System.in);
   
       EmployeeProfile employee = new EmployeeProfile();
       
        // Get the employee number
        System.out.print("Enter employee number: ");
        employee.SetEmployeeNo(strScanner.nextLine());
       
        // Get the employee name
        System.out.print("Enter employee name: ");
        employee.SetEmployeeName(strScanner.nextLine());
       
        // Get the employee birth date
        System.out.print("Enter employee birthdate: ");
        employee.SetEmployeeBirthdate(strScanner.nextLine());
       
        // Get the employee's hourly rate
        System.out.print("Enter the employee's hourly rate: ");
        float hourlyRate = fltScanner.nextFloat();

        // Define the work week as starting on Monday and ending on Sunday
        DayOfWeek firstDayOfWeek = DayOfWeek.MONDAY;
        DayOfWeek lastDayOfWeek = DayOfWeek.SUNDAY;
        
        // Create a list of work periods for the week
        List<LocalDateTime[]> workPeriods = new ArrayList<>();
        
        // Get user input for work periods until the user enters "done"
        while (true) {
            System.out.print("Enter the date (yyyy-mm-dd) or type 'done' to finish: ");
            String inputDate = strScanner.nextLine();
            if (inputDate.equalsIgnoreCase("done")) {
                break;
            }
            
            LocalDate date = LocalDate.parse(inputDate);
            
            System.out.print("Enter the time in (hh:mm): ");
            LocalTime timeIn = LocalTime.parse(strScanner.nextLine());
            
            System.out.print("Enter the time out (hh:mm): ");
            LocalTime timeOut = LocalTime.parse(strScanner.nextLine());
            
            LocalDateTime[] workPeriod = { LocalDateTime.of(date, timeIn), LocalDateTime.of(date, timeOut) };
            workPeriods.add(workPeriod);
        }
        
        // Calculate the total worked hours in the week
        int totalWorkedHours = 0;
        for (LocalDateTime[] workPeriod : workPeriods) {
            DayOfWeek dayOfWeek = workPeriod[0].getDayOfWeek();
            if (dayOfWeek.compareTo(firstDayOfWeek) >= 0 && dayOfWeek.compareTo(lastDayOfWeek) <= 0) {
                int workedHours = (int) ChronoUnit.HOURS.between(workPeriod[0], workPeriod[1]);
                totalWorkedHours += workedHours;
            }
        }
        
        // Calculate the employee's weekly pay
        float weeklyPay = hourlyRate * totalWorkedHours;
        
        // Get the employee's additional allowances
        System.out.println("Enter additional allowances: ");
        float additonalAllowances = fltScanner.nextFloat();
        
     // Calculate the deductions
        double sssDeduction = 0;
        float pagibigDeduction = 0;
        float philhealthDeduction = 0;

        if (weeklyPay < 3250) {
            sssDeduction = 135;
        } else if (weeklyPay < 3750) {
            sssDeduction = 157.50; }
          else if (weeklyPay < 4250) {
            sssDeduction = 180;
          }  else if (weeklyPay < 4750) {
            sssDeduction = 202.50; }
          else if (weeklyPay < 5250) {
              sssDeduction = 225; }
          else if (weeklyPay < 5750) {
              sssDeduction = 247.50; }
          else if (weeklyPay < 6250) {
              sssDeduction = 270; }
          else if (weeklyPay < 6750) {
              sssDeduction = 292.50; }
          else if (weeklyPay < 7250) {
              sssDeduction = 315; }
          else if (weeklyPay < 7750) {
              sssDeduction = 337.50; }
          else if (weeklyPay < 8250) {
              sssDeduction = 360; }
          else if (weeklyPay < 8750) {
              sssDeduction = 382.50; }
          else if (weeklyPay < 9250) {
              sssDeduction = 405; }
          else if (weeklyPay < 9750) {
              sssDeduction = 427.50; }
          else  if (weeklyPay < 10250) {
              sssDeduction = 450; }
          else if (weeklyPay < 10750) {
              sssDeduction = 472.50; }
          else   if (weeklyPay < 11250) {
              sssDeduction = 495; }
          else if (weeklyPay < 11750) {
              sssDeduction = 517.50; }
          else if (weeklyPay < 12250) {
              sssDeduction = 540; }
          else  if (weeklyPay < 12750) {
              sssDeduction = 562.50; }
          else if (weeklyPay < 13250) {
              sssDeduction = 585; }
          else if (weeklyPay < 13750) {
              sssDeduction = 607.50; }
          else if (weeklyPay < 14250) {
              sssDeduction = 630; }
          else if (weeklyPay < 14750) {
              sssDeduction = 652.50; }
          else if (weeklyPay < 15250) {
              sssDeduction = 675; }
       

        if (weeklyPay > 1500) {
            pagibigDeduction = (weeklyPay * 2) / 100;
        } else {
            pagibigDeduction = 0;
        }

        if (pagibigDeduction > 100) {
            pagibigDeduction = 100;
        }

        philhealthDeduction = (weeklyPay * 3) / 100;
        
        float TotalDeductions = (float) (sssDeduction + pagibigDeduction + philhealthDeduction);

        // Calculate the net weekly salary
        float NetWeeklySalary = (float) (weeklyPay + additonalAllowances - TotalDeductions);

        // Calculate the tax
        float withholdtax = 0;

        if (NetWeeklySalary < 20832) {
        	withholdtax = 0;
        } else {
        	withholdtax = (NetWeeklySalary - 20832) * 20 / 100;
        }


        // Set the company title and sub-heading
        String companyTitle = "MOTOR PH";
        String subheading = "PAYROLL SUMMARY";
        

        // Print the company title and sub-heading
        System.out.println("** " + companyTitle + " **");
        System.out.println(subheading);

        // Display the employee's number, name, birthday and hourly rate
        System.out.println("Employee Number: " + employee.GetEployeeNo());
        System.out.println("Employee Name: " + employee.GetEmployeeName());
        System.out.println("Employee Birthdate: " + employee.GetEmployeeBirthdate());
        System.out.println("Hourly Rate: " + hourlyRate);
   
        // Prints the total worked hours in the week
        System.out.println("Total worked hours in the week: " + totalWorkedHours);
        
        // prints gross weekly pay
        System.out.println("Gross Weekly Pay: " + weeklyPay);
        
        // prints allowances
        System.out.println("Additional Allowances: " + additonalAllowances);
        
        //displays sub-heading 
        String deductions = "DEDUCTIONS";
        System.out.println(deductions);
        
        //prints the generic deductions and total sum of it
        System.out.println("SSS deduction:" + sssDeduction);
        System.out.println("PhilHealth deduction:" + philhealthDeduction);
        System.out.println("Pag-Ibig deduction:" + pagibigDeduction);    
        System.out.println("Total deductions:" + TotalDeductions);
        
        //displays withholding tax if there is any
        System.out.println("Withholding Tax:" + withholdtax);
        
        //prints the net weekly salary after deducting the deductions and tax if any
        System.out.println("NET Weekly Salary:" + NetWeeklySalary);
        
        
        
        System.out.println("coded by: Kenneth U.");	
        System.exit(0);
        
    }
}
