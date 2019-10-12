/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 *
 * @author haadfida
 */
public abstract class Users {
    public int Age;
    public String id,username, password, address, email;
    long Fine = 0;
    double telephone;
    ArrayList<Loan> Loans = new ArrayList<>();
    ArrayList<Reservation> Res = new ArrayList<>();
    
    Library lib;
    
    public Users(String id,int a, String user, String pass, String add,String email, double tele,long fine)
    {
        this.id=id;
        Age = a;
        this.username = user;
        this.password = pass;
        this.address = add;
        this.email=email;
        this.telephone = tele;
        this.Fine=fine;
    }
    
    public String getUserId()
    {
        return id;
    }
    
     public void setUserId(String id1)
    {
        id=id1;
    }
    
    public String getUserName()
    {
        return username;
    }
    
    public void setUserName(String name)
    {
        username = name;
    }
    
     public String getemail()
    {
        return email;
    }
    
    public void setemail(String e)
    {
        email=e;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String p)
    {
        password = p;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String p)
    {
        address = p;
    }
    
    public double getTelephone()
    {
        return telephone;
    }
    
    public void setTelephone(int p)
    {
        telephone = p;
    }
    
    public int getAge()
    {
        return Age;
    }
    
    public void setAge(int p)
    {
        Age = p;
    }
    
    public Users getUser()
    {
        return this;
    }
    
    public void addLoan(Loan L)
    {
            this.Loans.add(L);
    }
    
     public long getFine()
    {
        return Fine;
    }
    
    public void setFine(long f)
    {
        Fine = f;
    }
    
    public void Print()
    {
         for (Loan x: Loans)
        {
            System.out.println(x.getUser().getUserName());
        }
    }
    
    public boolean LoanExists(Items i)
    {
        for (Loan x: Loans)
        {
            if (x.getItem().getItemId().equalsIgnoreCase(i.getItemId()))
            {
                return true;
            }
        }
        return false;
    }
    
 public void RemoveLoan(Loan templ)
    {
        if(Loans!=null){
        Iterator<Loan> iter=Loans.iterator();
        
        while(iter.hasNext()){
            Loan l=iter.next();
            if (l.getUser().getUserId().equals(templ.getUser().getUserId()) && l.getItem().getItemId().equals(templ.getItem().getItemId()))
            {
                iter.remove();
            }
        }
    }
    }
   
     public void setLoaned(ArrayList<Loan> Loans) {
        this.Loans= Loans;
    }
     
    public void addReservation(Reservation r)
    {
        Res.add(r);
    }
    
    public ArrayList<Reservation> getRes()
    {
        return Res;
    }
    
    public ArrayList<Loan> getLoans()
    {
        return Loans;
    }
    public void RemoveReservation(String uname, String iname)
    {
        if(Res!=null){
        Iterator<Reservation> iter=Res.iterator();
        
        while(iter.hasNext()){
            Reservation r=iter.next();
            if (r.getUser().getUserId().equals(uname) && r.getItem().getItemId().equals(iname))
            {
                System.out.println("works");
                iter.remove();
            }
        }
        }
    }
     abstract void Update(String id,int a, String user, String pass, String add,String email, double tele) ;
     abstract void Update2(String pass) ;
}
