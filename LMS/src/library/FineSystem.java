/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author haadfida
 */
public class FineSystem {
     private String Department;
    
    private int totalmoney;
    
    public FineSystem( String Department) {
        this.Department = Department;
        this.totalmoney = 0;
    }

    public FineSystem(String Department, int totalmoney) {
        
        this.Department = Department;
        this.totalmoney = totalmoney;
    }


    public String getDepartmentAddress() {
        return Department;
    }

    public void setDepartmentAddress(String DepartmentAddress) {
        this.Department = DepartmentAddress;
    }

    public float gettotalMoney() {
        return totalmoney;
    }

    public void settotalMoney(int totalmoney) {
        this.totalmoney = totalmoney;
    }
}
