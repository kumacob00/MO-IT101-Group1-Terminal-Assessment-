/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeepayroll;

/**
 *
 * @author ADMIN
 */
public class EmployeeProfile {
    
    private String _employeeNo;
    private String _employeeName;
    private String _employeeBirthdate;
    
    
    public String GetEployeeNo(){
        return _employeeNo;
    }
    
    public String GetEmployeeName(){
        return _employeeName;
        
    }    
        
    public String GetEmployeeBirthdate(){
        return _employeeBirthdate;
    
    }
    
    public void SetEmployeeNo(String EmployeeNo){
        _employeeNo = EmployeeNo;
    }
    
    public void SetEmployeeName(String EmployeeName){
        _employeeName = EmployeeName;
    }
    
    public void SetEmployeeBirthdate(String EmployeeBirthdate){
        _employeeBirthdate = EmployeeBirthdate;
    }

   
}
