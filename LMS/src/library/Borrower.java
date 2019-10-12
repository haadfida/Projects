package library;

import java.util.ArrayList;

public class Borrower extends Users {
    
    ArrayList <Loan> Loans;
    
    public Borrower(String id,int a,String user, String pass, String add,String email, double tele,long fine)
    {
        super(id,a,user,pass, add,email, tele,fine);
    }

    @Override
    void Update(String id,int a,String user, String pass, String add,String email, double tele){
        this.id=id;
        this.Age=a;
        this.username=user;
        this.password=pass;
        this.address=add;
        this.email=email;
        this.telephone=tele;
    }
    
    @Override
    void Update2(String pass){
    this.password=pass;
    }
     
}
