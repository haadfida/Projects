package library;

import java.time.Instant;
import java.util.Date;

public class Loan {
    Users User;
    Items Item;
    Date issueDate;
    Date returnDate;
    
    Loan(Users u, Items i, Date id, Date rd)
    {
        User = u;
        Item = i;
        issueDate = id;
        returnDate = rd;
    }
    
    public Loan(Users u, Items i) {
        this.Item = i;
        this.User = u;
        this.issueDate = new Date();
        this.returnDate = new Date (issueDate.getYear(), issueDate.getMonth(), issueDate.getDate() + 14);
    }
    
    public Items getItem() {
        return Item;
    }

    public void setItem(Items i) 
    {
        Item = i;
    }

    public Users getUser() {
        return User;
    }   //Done

    public void setUser(Users u) {
        this.User = u;
    }   //Done
    
    public Date getReturnDate() {
        return returnDate;
    }   

    public void setReturnDate(Date DueDate) {
        this.returnDate = DueDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date IssueDate) {
        this.issueDate = IssueDate;
    }
    
    public void extendDeadline()
    {
        this.returnDate.setDate(returnDate.getDate() + 7);
    }
    
}