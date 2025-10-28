import java.util.ArrayList;

public class Book extends Media{
private int stock;
private ArrayList<Review> reviews;
//-
public boolean noRates(){
return reviews.isEmpty();
}
public Book(String title,String auteur,String ISBN,double price,int stock)
{
super(title,auteur,ISBN,price);
this.stock=stock;
reviews = new ArrayList<>();
}
public Book(){}

public int getStock(){return stock;}
//===========================================
public void addReview(Review r){
reviews.add(r);
}
public double getAverageRating()throws Exception{       //******************
if(noRates()) throw new Exception("this book has no rating yet.");
//-
int sum=0;
for(Review r: reviews){
sum+=r.getRating();   }
return sum/reviews.size();
}
public boolean isBestSeller(){
try{
if(noRates()) return false;
if(getAverageRating()>=4.5) return true; }catch (Exception e){System.out.println(e.getMessage());}
return false;
}
public void restock(int stock){
this.stock+=stock;
System.out.println("stock of book "+super.getTitle()+" has restock to be total of "+stock+".");
}
public String getMediaType(){
if(isBestSeller()) return "BestSelling book";
return "Book";}
public String toString(){
String rates = noRates()? "no rates":""+reviews.size()+" rates";
return getMediaType()+" "+super.toString()+", with stock of: "+stock+", with "+rates+".";}
}
