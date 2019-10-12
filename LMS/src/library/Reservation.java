/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Date;

public class Reservation {
    
    Items RItem;
    Users RUser;
    Date resDate;
    
   public Reservation(Items b, Users u,Date resDate)
    {
        RItem = b;
        RUser = u;
        this.resDate=resDate;
    }

    public Date getDate()
    {
        return resDate;
    }
    public Items getItem()
    {
        return RItem;
    }
    
    public void setItem(Items b)
    {
        RItem = b;
    }
    
    public Users getUser()
    {
        return RUser;
    }
    
    public void setUser(Users u)
    {
        RUser = u;
    }
    
}
