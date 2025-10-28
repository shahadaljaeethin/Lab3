import java.util.ArrayList;

public class Music extends Media {
private String artist;
public Music(){}
public Music(String title,String auteur,String ISBN,double price,String artist)
{
super(title,auteur,ISBN,price);
this.artist=artist;}
//================================================
public void lisen(User user)throws Exception{
boolean isPurches=false;
//1. Check if user own this music
for(Media item: user.getPurchaseMediaList()) {
    if (item.getTitle().equals(super.getTitle()))
    isPurches=true;
}
//2.if not prevent playing it
if(!isPurches) throw new Exception("Dear: "+ user.getUsername()+", you don't own this music yet.");
System.out.println(super.getTitle()+" is playing..");
}

public ArrayList<Music> generalPlayList(ArrayList<Music> musicCatalog,Store store)
{
    ArrayList<Music> newList = new ArrayList<>();
    ArrayList<String> authors = new ArrayList<>();
    //1. collect authors' names from the givin list
    for(Music music: musicCatalog)
    {
    if(!authors.contains(music.getAuteur())) //# if the author didnt add before add it
    authors.add(music.getAuteur());
    }

    //2. get all exisence music in the system.
    ArrayList<Media> all = store.displayMedia();
    boolean isMusic ;
    //3. create a music list from these authors' work
        //3.2 do two loops, one for all authors, second for all music in store
    for(String author:authors){
    for(Media media: all)
    {
    isMusic = media.getMediaType().equals("Premieum Music")||media.getMediaType().equals("Music");
    if(isMusic)
    {
    if(media.getTitle().equals(author))
    newList.add((Music) media);
    }
    } }

     // newList.add();

    return  newList;
}
public String getMediaType(){
if(super.getPrice()>=10) return "Premieum Music";
return "Music";}
public String toString(){
return getMediaType()+" "+super.toString()+", artist: "+artist;
}



}
