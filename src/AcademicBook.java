public class AcademicBook extends Book{
private String subject;
    public String getMediaType(){
        if(super.isBestSeller()) return "BestSelling Academic Book";
        return "Academic Book";}
    public String toString(){
    return super.toString()+",Academicbook with subject: "+subject;
    }
    public String getSubject(){return subject;}
    public void setSubject(String subject){this.subject=subject;}
    AcademicBook(){}
    AcademicBook(String title,String auteur,String ISBN,double price,int stock,String subject)
    {super(title,auteur,ISBN,price,stock);
    this.subject=subject;
    }
}
