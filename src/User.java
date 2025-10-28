import java.util.ArrayList;

public class User{
private String username,email;
private ArrayList<Media> purchaseMediaList,shoppingCart;
//------
public User(){}
public User(String username,String email){
this.username=username;
this.email=email; //both lists are empty
purchaseMediaList= new ArrayList<>();
shoppingCart= new ArrayList<>();
}
public ArrayList<Media> getPurchaseMediaList(){return purchaseMediaList;}
public String getUsername(){return username;}
public ArrayList<Media> getShoppingCart(){return shoppingCart;}
//=================================================
public void addToCart(Media m){
//check if physical copy(physical means limited number of stock, we have only media book which is physical, the rest are digitl)
boolean isBook = m.getMediaType().equals("Book")|| m.getMediaType().equals("BestSelling Book");
if(isBook){
Book temp = (Book)m;
if(temp.getStock()==0) System.out.println("this book is out of stock.");
else shoppingCart.add(m);
}else
shoppingCart.add(m);}
public void removeFromCart(Media m){shoppingCart.remove(m);}
public void checkOut(){
for(Media media: shoppingCart)
purchaseMediaList.add(media);
shoppingCart.clear(); //empty the cart
}
//public boolean isEmpty(ArrayList list){
//return list.isEmpty();
//
//}

}
