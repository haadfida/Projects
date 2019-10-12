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
public class Librarian extends Users
{
    public Librarian(String id,int a,String user, String pass, String add,String email, double tele,long fine)
    {
        super(id,a, user, pass, add,email, tele,fine);
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
