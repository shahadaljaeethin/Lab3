public class Review {
private String username,comment;
private int rating;
Review(){
username="unknown";
comment="";
rating=1; //1 to 5stars
}
Review(String username,String comment,int rating)
{this.username=username;this.comment=comment;this.rating=rating;
}
//===============================================================
public String getUsername(){return username;}
public String getComment(){return comment;}
public int getRating(){return rating;}
//=
public void setUsername(String username){this.username=username;}
public void updateComment(String comment){this.comment=comment;}
public void updateRating(int rating){this.rating=rating;}
}
