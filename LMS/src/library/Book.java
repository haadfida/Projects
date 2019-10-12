/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import java.util.ArrayList;

/**
 *
 * @author haadfida
 */
public class Book extends Items {
    
    
    private String Title;

    private String Author;

    private String Category;
    ArrayList<Loan> Loans;
    
    
    public Book(String ItemId,String title, String author, String genre)
    {
        super(ItemId);
        this.Title=title;
        this.Author = author;
        this.Category = genre;
    }
    
    @Override
    public String getTitle()
    {
        return Title;
    }
    
    public String getAuthor()
    {
        return Author;
    }
    
    @Override
    public String getSubject()
    {
        return Category;
    }
    
    public void setCategory(String b)
    {
        Category = b;
    }
    
    public void setAuthour(String b)
    {
        Author = b;
    }
    @Override
     void Update(String title, String author, String subject) {
      this.Title = title;
        this.Author = author;
        this.Category= subject;
    }
   
}
