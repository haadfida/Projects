package library;

public class Clerk extends Users{
    
    public Clerk(String id,int a,String user, String pass, String add,String email, double tele,long fine)
    {
        super(id,a,user,pass, add,email, tele,fine);
    }
    
     @Override
    void Update(String id,int a, String user, String pass, String add,String email, double tele){
    //does nothing
    }
    
      @Override
    void Update2(String pass){
    //does nothing
    }
    
}
