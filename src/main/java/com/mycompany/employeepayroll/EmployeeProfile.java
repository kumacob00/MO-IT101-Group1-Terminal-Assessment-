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
/**
 *
 * @author ADMIN
 */
public class EmployeeProfile {
    
    private String _employeeNo;
    private String _employeeName;
    private String _employeeBirthdate;
    private String _hourlyRate;
    private String _riceSubsidy;
    private String _phoneAllowance;
    private String _clothingAllowance;
    
    
    
    public String getEmployeeNo(){
        return _employeeNo;
    }
    public String getEmployeeName(){
        return _employeeName;   
    }        
    public String getEmployeeBirthdate(){
        return _employeeBirthdate;
    }
    public String getHourlyRate(){
        return _hourlyRate;
    }
    public String getRiceSubsidy(){
        return _riceSubsidy;
    }
    public String getPhoneAllowance(){
        return _phoneAllowance;
    }
     public String getClothingAllowance(){
        return _clothingAllowance;
    }
    
     
    public void SetEmployeeNo(String EmployeeNo){
        _employeeNo = EmployeeNo;
    }
    
    public void DisplayEmployeeDetails(String employeeNo) throws FileNotFoundException, IOException, CsvValidationException{
        String filename = "EmployeeData.csv";
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] header = reader.readNext();
        String[] record;
        while((record = reader.readNext()) != null){
            if(record[0].equals(employeeNo)){
                _employeeNo = record[0];
                _employeeName = (record[1] + "," + record[2]);
                _employeeBirthdate = record[3];
                _hourlyRate = record[18];
                _riceSubsidy = record[14];
                _phoneAllowance = record[15];
                _clothingAllowance = record[16];              
            }
        }
    }
}

