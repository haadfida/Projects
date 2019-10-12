package library;

import java.util.*;

public abstract class Items {
    
    private String ItemId;
    Loan loan;
     
    Items(String ItemId1)
    {
        ItemId = ItemId1;
    }
    
    public String getItemId()
    {
        return ItemId;
    }
    
    public void setItemId(String b)
    {
        ItemId= b;
    }
     
    public void addLoan(Loan l)
    {
        this.loan = l;
    }
    
    public void removeLoan()
    {
        this.loan = null;
    }
    
    public boolean isAvailable()
    {
        if (loan == null)
            return true;
        else
            return false;
    }
    
    public Loan getLoan()
    {
        return loan;
    }
    
    abstract void Update(String title, String author, String subject) ;
    public abstract String getAuthor();
    public abstract String getTitle();
    public abstract String getSubject();

    
}
