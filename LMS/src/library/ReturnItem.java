/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Date;

/**
 *
 * @author haadfida
 */
public class ReturnItem {
     private Items Item;

    private Users User;
    
    private Date ReturnDate;
    
    private Date DueDate;
    
     public ReturnItem(Items Item, Users User, Date DueDate) {
        this.Item = Item;
        this.User =  User;
        this.ReturnDate = new Date();
        this.DueDate = DueDate;
    }
    
    public ReturnItem(Items Item, Users User, Date DueDate, Date ReturnDate) {
       this.Item = Item;
        this.User =  User;
        this.DueDate = DueDate;
        this.ReturnDate = ReturnDate;
    }
    
      public Items getItem() {
        return Item;
    }

    public void setItem(Items Item) {
        this.Item = Item;
    }

    public Users getUser() {
        return User;
    }

    public void setUser(Users User) {
        this.User = User;
    }
    
    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }

}
