package library;

public class CDs extends Items{
    private String Title;

    private String Writer;

    private String Category;
  
    public CDs(String ItemId,String title, String Writer, String Category)
    {
        super(ItemId);
        this.Writer = Writer;
        this.Title=title;
        this.Category=Category;
    }
    @Override
     public String getTitle()
    {
        return Title;
    }
    
    @Override
    public String getAuthor()
    {
        return Writer;
    }
    @Override
    public String getSubject()
    {
        return Category;
    }
    
    
    public void setGenre(String n)
    {
        Category = n;
    }
    
    @Override
    void Update(String title, String author, String subject) {
      this.Title = title;
        this.Writer = author;
        this.Category= subject;
    }
   
}
