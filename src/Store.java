import java.util.ArrayList;

public class Store {
private ArrayList<User> users = new ArrayList<>();
private ArrayList<Media> medias = new ArrayList<>();
public Store(){
}
public ArrayList<Media> getMedias(){return medias;}
//===========================================================
public void addUser(User user){users.add(user);}
public void addMedia(Media media){medias.add(media);}
public ArrayList<User> displayUsers(){
int i=1;
for(User u: users){
System.out.println(i+"."+u.getUsername());
i++;}

return users;
}
public ArrayList<Media> displayMedia(){
    int index=0;
    for(Media m:medias) {
        System.out.println(index+". {" + m + "}\n___________________________________________________________________________________________________________________________________________________________________________");
        index++;
    }

return medias;}
public User getUser(int index)throws Exception{
if(index>=users.size()) throw new Exception("index wrong");
return users.get(index);}
public ArrayList<User> getUsers(){return users;}

public Book searchBook(String title)throws Exception{
boolean isBook ;
for(Media media: medias)
{
isBook = media.getMediaType().equals("BestSelling book")||media.getMediaType().equals("Book");
if(media.getTitle().equals(title)&&isBook) return (Book)media;//cast to book
}
throw new Exception("Book not found");}

}
