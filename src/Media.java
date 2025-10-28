public class Media {
private String title,auteur,ISBN;
private double price;
//-
public Media(){}
public Media(String title,String auteur,String ISBN,double price)
{this.title=title; this.auteur=auteur; this.ISBN=ISBN; this.price=price;}
//-
public void setTitle(String title){this.title=title;}
public void setAuteur(String auteur){this.auteur=auteur;}
public void seISBN(String ISBN){this.ISBN=ISBN;}
public void setPrice(double price){this.price=price;}
public String getTitle(){return title;}
public String getAuteur(){return auteur;}
public String getISBN(){return ISBN;}
public double getPrice(){return price;}
//================================================================
public String toString(){
return "media title: "+title+" | auteur: "+auteur+" | ISBN #"+ISBN+" | price: "+price+"SR";
}
public String getMediaType(){return "Media";}
}
