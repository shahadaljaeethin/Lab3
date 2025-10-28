public class Novel extends Book{
private String genre;


    public String getMediaType(){
        if(super.isBestSeller()) return "BestSelling Novel";
        return "Novel";}
    public String toString(){
        return super.toString()+",a Novel with genre: "+genre;
    }
public Novel(String title,String auteur,String ISBN,double price,int stock,String genre)
{super(title,auteur,ISBN,price,stock);
    this.genre=genre;
}
public Novel(){}

 public String getGenre(){return genre;}
 public void setGenre(String genre){this.genre=genre;}
}
