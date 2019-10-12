package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;

public class Library 
{


    ArrayList <Items> ItemList=new ArrayList<>();
    ArrayList <Users> UserList= new ArrayList<>();
    ArrayList <Loan> LoanList= new ArrayList<>();
     ArrayList <Loan> LoanHistory= new ArrayList<>();
    ArrayList <Reservation> Res= new ArrayList<>();
    private static final String username= "root";
    private static final String password= "password";
    private static final String conn_string= "jdbc:mysql://localhost:3306/dblink";
    
    public Library()    //Done
    {
        ItemList = new ArrayList<>();
        UserList = new ArrayList<>();
    }
    
    public Library(ArrayList <Items> i, ArrayList <Users> u, ArrayList <Loan> L)    //Done
    {
        this.ItemList = i;
        this.UserList = u;
        this.LoanList = L;
    }
    
    public ArrayList<Items> getItems()  //Done
    {
        return ItemList;
    }
    
    public void setItems(ArrayList<Items> i)    //Done
    {
        this.ItemList = i;
    }
    
    public ArrayList<Users> getUsers()  //Done
    {
        return UserList;
    }
    
    public void setUsers(ArrayList<Users> u)    //Done
    {
        this.UserList = u;
    }
    
    public ArrayList<Loan> getLoans()  //Done
    {
        return LoanList;
    }
    
    public void setLoans(ArrayList<Loan> u)    //Done
    {
        this.LoanList = u;
    }
    
    public boolean AddBook(Book NewBook)    //Done
    {
        for (Items x: ItemList)
        {
            if (x instanceof Book)
            {
                if (x.getItemId().equalsIgnoreCase(NewBook.getItemId())) 
                {
                     JOptionPane.showMessageDialog(null,"Error, Book ID already exists!");
                    return false;
                }
            }
        }
        Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String id=NewBook.getItemId();
           String title=NewBook.getTitle();
           String author=NewBook.getAuthor();
           String subject=NewBook.getSubject();
           int itemtype=1;
           String insert = "INSERT INTO dblink.Items(id,title,author,genre,itemtype) VALUES('"+id+"','"+title+"','"+author+"','"+subject+"',"+itemtype+")";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
        ItemList.add(NewBook);
        return true;
    }
    
    public boolean AddCDs(CDs NewCD)//Done
    {
        for (Items x: ItemList)
        {
            if (x instanceof CDs)
            {
                if (x.getItemId().equalsIgnoreCase(NewCD.getItemId())) 
                {
                    JOptionPane.showMessageDialog(null,"Error, CD ID already exists!");
                    return false;
                }
            }
        }
          Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String id=NewCD.getItemId();
           String title=NewCD.getTitle();
           String author=NewCD.getAuthor();
           String subject=NewCD.getSubject();
           int itemtype=2;
           String insert = "INSERT INTO dblink.Items(id,title,author,genre,itemtype) VALUES('"+id+"','"+title+"','"+author+"','"+subject+"',"+itemtype+")";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
        ItemList.add(NewCD);
        return true;
    }
     
    public boolean AddBorrower(Borrower NewBor)//Done
    {
        
        if(UserList==null)
        {
            UserList = new ArrayList<>();
        }
        for (Users x: UserList)
        {
            if (x instanceof Borrower)
            {
                if (x.getUserId().equalsIgnoreCase(NewBor.getUserId()))
                {
                    return false;
                }
            }
        }
          Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String id=NewBor.getUserId();
           int age=NewBor.getAge();
           String username=NewBor.getUserName();
           String password=NewBor.getPassword();
           String address=NewBor.getAddress();
           String email=NewBor.getemail();
           double tele=NewBor.getTelephone();
           double fine=0;
           int usertype=1;
           String insert = "INSERT INTO dblink.users(id,age,username, password, address, email, telephone,fine,usertype) VALUES('"+id+"',"+age+",'"+username+"','"+password+"','"+address+"','"+email+"',"+tele+","+fine+","+usertype+")";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
        UserList.add(NewBor);
        return true;
    }
    
    public boolean AddClerk(Clerk NewClerk)//Done
    {
        for (Users x: UserList)
        {
            if (x instanceof Clerk)
            {
                if (x.getUserId().equalsIgnoreCase(NewClerk.getUserId()))
                {
                    return false;
                }
            }
        }
        UserList.add(NewClerk);
        return true;
    }
    
    public boolean Addlibrarian(Librarian NewLibrarian)//Done
    {
        for (Users x: UserList)
        {
            if (x instanceof Librarian)
            {
                if (x.getUserId().equalsIgnoreCase(NewLibrarian.getUserId())) 
                {
                    return false;
                }
            }
        }
        UserList.add(NewLibrarian);
        return true;
    }
    
    public String DisplayName(String id){
        
         for (Users x: UserList)
        {
            if (x.getUserId().contains(id))
            {
                return x.getUserName();
            }
           
        }
         return null;
    }
    
    public ArrayList<Users> searchBorrower(String search)//Done
    {
        ArrayList<Users> temp = new ArrayList<>();
        Book tempBook;
        CDs tempCD;
        
        for (Users x: UserList)
        {
             if (x instanceof Borrower)
            {
            if (x.getUserId().contains(search))
            {
                temp.add(x);
            }
            }
           
        }
        
        if (temp.isEmpty())
            temp = null;
        
        return temp;
    }
    
   public Items getItembyID(String search)//Done
    {
        Items temp=null;
        
        for (Items x: ItemList)
        {
            
            if (x.getItemId().equals(search))
            {
                temp=x;
            }
           
        }
        
        
        return temp;
    }
   
    public Users getUserbyID(String search)//Done
    {
        Users temp=null;
        
        for (Users x: UserList)
        {
            
            if (x.getUserId().equals(search))
            {
                temp=x;
            }
           
        }
        
        
        return temp;
    }
    public ArrayList<Items> searchItem(String search)//Done
    {
        ArrayList<Items> temp = new ArrayList<>();
        Book tempBook;
        CDs tempCD;
        
        for (Items x: ItemList)
        {
            
            if (x.getItemId().contains(search))
            {
                temp.add(x);
            }
           
        }
        
        if (temp.isEmpty())
            temp = null;
        
        return temp;
    }
    
    public ArrayList<Items> searchItemByTitle(String s)     //Done returns collection of books and cds
    {
        ArrayList<Items> temp = new ArrayList<>();
        Book tempBook;
        CDs tempCD;
        
        for (Items x: ItemList)
        {
            
            if (x.getTitle().contains(s))
            {
                temp.add(x);
            }
            else if (x.getTitle().toLowerCase().contains(s))
            {
                temp.add(x);
            }
            else if(x.getTitle().toUpperCase().contains(s))
            {
                temp.add(x);
            }
           
        }
        
        if (temp.isEmpty())
            temp = null;
        return temp;
    }
    
    public ArrayList<Items> searchItembyAuthor(String s)    //Done
    {
        ArrayList<Items> temp = new ArrayList<>();
        
        for (Items x: ItemList)
        {
            if (x.getAuthor().contains(s))
            {
                temp.add(x);
            }
            else if (x.getAuthor().toLowerCase().contains(s))
            {
                temp.add(x);
            }
            else if(x.getAuthor().toUpperCase().contains(s))
            {
                temp.add(x);
            }
        }
        
        if (temp.isEmpty())
            return null;
        return temp;
    }
    
      public ArrayList<Items> searchItembySubject(String s)  //Done
    {
        ArrayList<Items> temp = new ArrayList<>();
        
        for (Items x: ItemList)
        {
              if (x.getSubject().contains(s))
            {
                temp.add(x);
            }
            else if (x.getSubject().toLowerCase().contains(s))
            {
                temp.add(x);
            }
            else if(x.getSubject().toUpperCase().contains(s))
            {
                temp.add(x);
            }
        }
        
        if (temp.isEmpty())
            return null;
        return temp;
    }
    
    public ArrayList<Items> searchBookByCategory(String s)  //Done
    {
        ArrayList<Items> temp = new ArrayList<>();
        
        for (Items x: ItemList)
        {
            if (x instanceof Book)
            {
                Book b = (Book) x;
                if (b.getSubject().contains(s))
                {
                    temp.add(x);
                }
            }
        }
 
        if (temp.isEmpty())
            return null;
        return temp;
    }
    
    public ArrayList<Items> searchCDbyWriter(String s)    //Done
    {
        ArrayList<Items> temp = new ArrayList<>();
        
        for (Items x: ItemList)
        {
            if (x instanceof CDs)
            {
                CDs c = (CDs) x;
                if (c.getAuthor().equalsIgnoreCase(s))
                {
                    temp.add(x);
                }
            }
        }
        
        if (temp.isEmpty())
            return null;
        return temp;
    }
    
    public ArrayList<Items> searchCDbyGenre(String s)   //Done
    {
        ArrayList<Items> temp = new ArrayList<>();
        
        for (Items x: ItemList)
        {
            if (x instanceof CDs)
            {
                CDs c = (CDs) x;
                if (c.getSubject().equalsIgnoreCase(s))
                {
                    temp.add(x);
                }
            }
        }
        
        if (temp.isEmpty())
            return null;
        return temp;
    }
    
       public boolean UpdateBookItem(Items item, String title, String author, String subject)
    {
        
         for (Items x: ItemList)
        {
            
                if (x==item)
                {
                    Items i = x;
                    i.Update(title,author,subject);
                    return true;
                }
            
        }
        return false;
    }
       
      public boolean UpdateBookItembyId(String id, String title, String author, String subject)
    {
           String curritem,curritem1,curritem2,curritem3;
         for (Items x: ItemList)
        {
                
                curritem=x.getItemId();
                
                if (curritem.equals(id))
                {
                    Items i = x;
                    i.Update(title,author,subject);
                    
                    Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String insert = "Update dblink.Items Set title='"+title+"',author='"+author+"',genre='"+subject+"' WHERE id='"+id+"'";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
                    
                    return true;
                    
                }
        }
     for (Items x: ItemList)
        {
            
                curritem=x.getItemId();
                curritem1=x.getTitle();
                curritem2=x.getAuthor();
                curritem3=x.getSubject();
        if((!curritem.equals(id) &&curritem1.equals(title) && curritem2.equals(author) && curritem3.equals(subject)) ){
                 
                              Connection conn=null;
                         try{
                                conn=DriverManager.getConnection(conn_string,username,password);
                                System.out.println("Connected");
                                Statement stmt= (Statement) conn.createStatement();
                                String insert = "Update dblink.Items Set id='"+id+"' WHERE author='"+author+"'AND genre='"+subject+"'AND title='"+title+"'";
                                stmt.executeUpdate(insert);
             
                                x.setItemId(id);
                             }catch(SQLException e)
                             {
                                 System.out.println(e);
                             }
                                   return true;
                }
              
         
        
}
        
        return false;
        
    }
      
    public boolean UpdateBorrower(String userid, String pass){
        String curritem;
         for (Users x: UserList)
        {
             if(x instanceof Borrower){
                curritem=x.getUserId();
                if (curritem.equals(userid))
                {
                    x.Update2(password);
                     Connection conn=null;
                     try{
                     conn=DriverManager.getConnection(conn_string,username,password);
                      System.out.println("Connected");
                       Statement stmt= (Statement) conn.createStatement();
                         String insert = "Update dblink.users Set password='"+pass+"' WHERE id='"+userid+"'";
                    stmt.executeUpdate(insert);
             
          
                     }catch(SQLException e)
                    {
                     System.out.println(e);
                     }
                    return true;
                }
        }
    }
          return false;
    }
      
    public boolean UpdateBorrower(String id,int age,String user,String pass, String address, String email, double tele)
    {
           String curritem,curritem1,curritem2,curritem3,curritem4;
           int a;
           double te;
         for (Users x: UserList)
        {
            if(x instanceof Borrower){
                curritem=x.getUserId();
                
                if (curritem.equals(id))
                {
                    
                    x.Update(id,age,user,pass,address,email,tele);
                    
                    Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String insert = "Update dblink.users Set age="+age+",username='"+user+"',password='"+pass+"',address='"+address+"',email='"+email+"',telephone="+tele+" WHERE id='"+id+"'";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
                    
                    return true;
                    
                }
        }
        }
    
           for (Users x: UserList)
        {
            
                curritem=x.getUserId();
                a=x.getAge();
                curritem1=x.getUserName();
                curritem2=x.getPassword();
                curritem3=x.getAddress();
                curritem4=x.getemail();
                te=x.getTelephone();

        if((curritem1.equals(user))&&(curritem2.equals(pass))&&(curritem3.equals(address))&&(curritem4.equals(email)) && (a==age) && (te==tele)){
                    
                    Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String insert = "Update dblink.users Set id='"+id+"' WHERE age="+age+" AND username='"+user+"' AND password='"+pass+"' AND address='"+address+"' AND email='"+email+"' AND telephone="+tele+"";
           stmt.executeUpdate(insert);
            x.setUserId(id);
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
                    
                    return true;
                    
            
        }
        
}
        
        return false;
        
    }
     
    public boolean DeleteUser(String username)  //Done
    {
        for (Users x: UserList)
        {
            if (x.getUserName().equalsIgnoreCase(username))
            {
                UserList.remove(x);
                return true;
            }
        }
        return false;
    }
     
    public boolean DeleteItemID(String id)  //Done
    {
        for (Items x: ItemList)
        {
            
                if (x.getItemId().equalsIgnoreCase(id))
                {
                     Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String delete = "Delete from dblink.Items where id='"+id+"'";
           stmt.executeUpdate(delete);
               JOptionPane.showMessageDialog(null,"Item successfully deleted");
                    ItemList.remove(x);
                    return true;
          
       }catch(SQLException e)
       {
        System.out.println(e);
          JOptionPane.showMessageDialog(null,"Item is loaned to a user");
                    return false;
       }
        
                }
            
        }
        return false;
    }
    
    public boolean DeleteBookByAuthor(String a) //Done
    {
        boolean found = false;
        for (Items x: ItemList)
        {
            if (x instanceof Book)
            {
                Book temp = (Book) x;
                if (temp.getAuthor().equalsIgnoreCase(a))
                {
                    ItemList.remove(x);
                    found = true;
                }
            }
        }
        return found;
    }
    
    public boolean DeleteBookByCategory(String a)   //Done
    {
        boolean found = false;
        for (Items x: ItemList)
        {
            if (x instanceof Book)
            {
                Book temp = (Book) x;
                if (temp.getSubject().equalsIgnoreCase(a))
                {
                    ItemList.remove(x);
                    found = true;
                }
            }
        }
        return found;
    }
    
    public boolean DeleteCDByTitle(String title)  //Done
    {
        for (Items x: ItemList)
        {
            if (x instanceof CDs)
            {
                if (x.getItemId().equalsIgnoreCase(title))
                {
                    ItemList.remove(x);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean DeleteCDbyComposer(String comp)  //Done
    {
        boolean found = false;
        for (Items x: ItemList)
        {
            if (x instanceof CDs)
            {
                CDs temp = (CDs) x;
                if (temp.getAuthor().equalsIgnoreCase(comp))
                {
                    ItemList.remove(x);
                    found = true;
                }
            }
        }
        return found;
    }
    
    public boolean DeleteCDbyGenre(String G)    //Done
    {
        boolean found = false;
        for (Items x: ItemList)
        {
            if (x instanceof CDs)
            {
                CDs temp = (CDs) x;
                if (temp.getSubject().equalsIgnoreCase(G))
                {
                    ItemList.remove(x);
                    found = true;
                }
            }
        }
        return found;
    }
     
    public Users FindUser(String username, String password) //Done
    {
        for (Users x: UserList)
        {
            if (x.getUserName().equals(username) && x.getPassword().equals(password))
            {
                return x;
            }
        }
        
        return null;
    }
    
    
 public Loan LoanItemToUser(Items I, Users U)     //  
    {    
        if(LoanList==null)
        {
            LoanList = new ArrayList<>();
        }
        Loan L=null;
        if (I.isAvailable())
        {
            L = new Loan(U, I);
            Connection conn=null;
             try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();   
           String itemid=I.getItemId();
           String userid=U.getUserId();
           String issueDate = new SimpleDateFormat("yyyy-MM-dd").format(L.getIssueDate());
           String retDate = new SimpleDateFormat("yyyy-MM-dd").format(L.getReturnDate());
           String insert = "INSERT INTO dblink.Loan(itemid,userid,issueDate,retDate) VALUES('"+itemid+"','"+userid+"','"+issueDate+"','"+retDate+"')";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       } 
            
            LoanList.add(L);
            I.addLoan(L);
            U.addLoan(L);
              conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();   
           String itemid=I.getItemId();
           String userid=U.getUserId();
           String delete = "DELETE FROM dblink.Reservation WHERE itemid='"+itemid+"' AND userid='"+userid+"'";
           stmt.executeUpdate(delete);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }     
            U.RemoveReservation(U.getUserId(),I.getItemId());
            RemoveReservation(U.getUserId(),I.getItemId());
            JOptionPane.showMessageDialog(null,"Item loaned to " +L.getUser().getUserId());
        }
        return L;
    }
 
     public void RegisterReservation(String userid, String itemid)    //returns -1 if borrower has a fine. returns 1 if item has been sucesfully reserved
    {
         Items i = null;
        for (Items x: ItemList)
        {
            
            if (x.getItemId().equals(itemid))
            {
                i=x;
                break;
            }
           
        }
        Users u = null;
        for (Users x: UserList)
        {
            
            if (x.getUserId().equals(userid))
            {
                u=x;
                break;
            }
           
        }
        if(u!=null && i!=null){
            Date currentdate = new Date(); 
        int status=reserveItem(u,i,currentdate);
        if(status==0){
         JOptionPane.showMessageDialog(null," Item already reserved");
        }
        else if(status==-1)
        {
            JOptionPane.showMessageDialog(null,u.getUserName() +" must pay fine first");
        }
         else if(status==1)
        {
            JOptionPane.showMessageDialog(null,"Item Reserved to "+u.getUserName() );
        }
         else if(status==2)
         {
         
         }
        }
    }
    
   public boolean ReservationExists(String UserName, String ItemName)
    {
        if(Res!=null){
        for (Reservation r: Res)
        {
            if (UserName.equalsIgnoreCase(r.getUser().getUserName()) && ItemName.equalsIgnoreCase(r.getItem().getTitle()))
            {
                return true;
            }
        }
        }
        
        return false;
    }
   
   public boolean LoanExists(String UserName, String ItemName)
{
for (Loan l: LoanList)
{
if (UserName.equalsIgnoreCase(l.getUser().getUserName()) && ItemName.equalsIgnoreCase(l.getItem().getTitle()))
{
return true;
}
} 
return false;
}
   
   public void loadBooks(Book b){
                 if(ItemList==null)
        {
                ItemList =  new ArrayList<>(); 
        }
             
        ItemList.add(b);
    }
   
   public void loadCDs(CDs c){
                 if(ItemList==null)
        {
                ItemList =  new ArrayList<>(); 
        }
             
        ItemList.add(c);
    }
    public void loadBorrowers(Borrower b){
                 if(UserList==null)
        {
                UserList =  new ArrayList<>(); 
        }
             
        UserList.add(b);
    }
    
     public void loadClerk(Clerk c){
                 if(UserList==null)
        {
                UserList =  new ArrayList<>(); 
        }
             
        UserList.add(c);
    }
     
     public void loadLibrarian(Librarian l){
                 if(UserList==null)
        {
                UserList =  new ArrayList<>(); 
        }
             
        UserList.add(l);
    }
    public void loadReservations(Reservation r,Users u){
                 if(Res==null)
        {
                Res =  new ArrayList<>(); 
        }
             
        u.addReservation(r);
        Res.add(r);
    }
    
        public void loadLoans(Loan l,Users u,Items i){
                 if(LoanList==null)
        {
                LoanList =  new ArrayList<>(); 
        }
             
        u.addLoan(l);
        i.addLoan(l);
        LoanList.add(l);
    }
        
        public void loadHistory(Loan l){
                 if(LoanHistory==null)
        {
                LoanHistory =  new ArrayList<>(); 
        }
             
        LoanHistory.add(l);
    }
    public int reserveItem(Users u, Items i,Date currentdate)    //returns 0 if item already reserved. returns -1 if borrower has a fine. returns -2 if already loaned .returns 1 if item has been sucesfully reserved
    {
        if (u.getFine() > 0)
            return -1;
        else if (LoanExists(u.getUserName(), i.getTitle()))
        {
            return -2;
        }
        else if (ReservationExists(u.getUserName(), i.getTitle()))
        {
            return 0;
        }
        
        Reservation r = new Reservation(i, u,currentdate);
                   if(Res==null)
        {
                Res =  new ArrayList<>(); 
        }
             
         u.addReservation(r);
        Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();   
           String itemid=i.getItemId();
           String userid=u.getUserId();
           String date = new SimpleDateFormat("yyyy-MM-dd").format(currentdate); 
           String insert = "INSERT INTO dblink.Reservation(itemid,userid,resdate) VALUES('"+itemid+"','"+userid+"','"+date+"')";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }           
        Res.add(r);
        return 1;
    }
    
public boolean receiveFine(Users User, long payment)   //returns false if user has no fine or payment is more than
    {    
        if (User.getFine() > 0)
        {
            if (payment > User.getFine())
            {
                User.setFine(0);
            }
            else
            {
                User.setFine(User.getFine() - payment);
            }
            
             Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           long fine=User.getFine();
           String Uid=User.getUserId();
           String insert = "Update dblink.users Set fine='"+fine+"' WHERE id='"+Uid+"'";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
       
            return true;
        }
        return false;
    }
     
 
    public boolean ReturnItem(Users u, Items i)        //This funciton computes fine as well. Returns false if user never borrowed the book
    {
        Date d = new Date(), ret;
        long days;
        for (Loan L: LoanList)
        {
            if (L.getUser().getUserName().equalsIgnoreCase(u.getUserName()) && L.getItem().getTitle().equalsIgnoreCase(i.getTitle()))
            {
                ret = L.getReturnDate();
                Connection conn=null;
                  try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();   
           String itemid=i.getItemId();
           String userid=u.getUserId();
           String delete = "DELETE FROM dblink.Loan WHERE itemid='"+itemid+"' AND userid='"+userid+"'";
           stmt.executeUpdate(delete);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }  
                RemoveLoan(L);
                i.removeLoan();
                u.RemoveLoan(L);
                
                   conn=null;
             try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();   
           String itemid=i.getItemId();
           String userid=u.getUserId();
           String issueDate = new SimpleDateFormat("yyyy-MM-dd").format(L.getIssueDate());
           String retDate = new SimpleDateFormat("yyyy-MM-dd").format(L.getReturnDate());
           String insert = "INSERT INTO dblink.LoanHistory(itemid,userid,issueDate,retDate) VALUES('"+itemid+"','"+userid+"','"+issueDate+"','"+retDate+"')";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       } 
                
                L.setReturnDate(d);
                LoanHistory.add(L);
                if (ret.after(d))
                {
                    days = (d.getTime() - L.getReturnDate().getTime())/(24*60*60*1000);     //$1 for everyday overdue
                    u.setFine(days);
                }
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Reservation> GetReservedItems() 
    {
        return Res;
    }
    
      public boolean checkBorrowerLogin(String id, String password){
         
     boolean found = false;
String curItem;
String curItem2;

 for(Users tempU : UserList)
            {
                if(tempU instanceof Borrower){
                    curItem=tempU.getUserId();
                    curItem2=tempU.getPassword();
                  
                    if (curItem.equals(id) && curItem2.equals(password) ) 
                    {
                    found = true;
                      break;
                    }
                }
            }
 
 return found;
     }
      
         public boolean checkClerkLogin(String id, String password){
         
     boolean found = false;
String curItem;
String curItem2;

 for(Users tempU : UserList)
            {
                if(tempU instanceof Clerk){
                    curItem=tempU.getUserId();
                    curItem2=tempU.getPassword();
                  
                    if (curItem.equals(id) && curItem2.equals(password) ) 
                    {
                    found = true;
                      break;
                    }
                }
            }
 
 return found;
     }
      
       public boolean checkLibrarianLogin(String id, String password){
         
     boolean found = false;
String curItem;
String curItem2;

 for(Users tempU : UserList)
            {
                if(tempU instanceof Librarian){
                    curItem=tempU.getUserId();
                    curItem2=tempU.getPassword();
                  
                    if (curItem.equals(id) && curItem2.equals(password) ) 
                    {
                    found = true;
                      break;
                    }
                }
            }
 
 return found;
     }
    
    public ArrayList<Reservation> getItemReservations(String ItemId)
    {
        ArrayList<Reservation> R = new ArrayList<>();
        if(Res!=null){
        for (Reservation x: Res)
        {
            if (x.getItem().getItemId().contains(ItemId))
            {
                R.add(x);
            }
        }
        }
        if (!R.isEmpty())
            return R;
        return null;
    }
    
 public void RemoveReservation(String uname, String iname)
    {
        if(Res!=null){
        Iterator<Reservation> iter=Res.iterator();
        
        while(iter.hasNext()){
            Reservation r=iter.next();
            if (r.getUser().getUserId().equals(uname) && r.getItem().getItemId().equals(iname))
            {
                iter.remove();
            }
        }
    }
    }
 
  public void RemoveLoan(Loan templ)
    {
        if(LoanList!=null){
        Iterator<Loan> iter=LoanList.iterator();
        
        while(iter.hasNext()){
            Loan l=iter.next();
            if (l.getUser().getUserId().equals(templ.getUser().getUserId()) && l.getItem().getItemId().equals(templ.getItem().getItemId()))
            {
                iter.remove();
            }
        }
    }
    }
  
  public boolean RenewLoan(String Uid, String Iid)
    {
        if (LoanList != null)
        {
            for (Loan L: LoanList)
            {
                if (L.getUser().getUserId().equals(Uid) && L.getItem().getItemId().equals(Iid))
                {
                    L.extendDeadline();
                    Date retDate=L.getReturnDate();
                                      Connection conn=null;
       try{
           conn=DriverManager.getConnection(conn_string,username,password);
           System.out.println("Connected");
           Statement stmt= (Statement) conn.createStatement();
           String insert = "Update dblink.Loan Set retDate='"+retDate+"' WHERE itemid='"+Iid+"' AND userid='"+Uid+"'";
           stmt.executeUpdate(insert);
             
          
       }catch(SQLException e)
       {
        System.out.println(e);
       }
                    return true;
                }
            }
        }
        return false;
    }
  
  public ArrayList<Loan> SearchLoanHistory(String ItemID)
  {
      ArrayList<Loan> L = new ArrayList<>();
      for (Loan x: LoanHistory)
      {
          if (x.getItem().getItemId().contains(ItemID))
          {
              L.add(x);
          }
      }
      return L;
  }
  
}


