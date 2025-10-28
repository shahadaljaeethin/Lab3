import java.util.ArrayList;

public class Movie extends Media{
private int duration;
public Movie(){}
 public Movie(String title,String auteur,String ISBN,double price,int duration){
super(title,auteur,ISBN,price);
this.duration=duration;
 }


public void watch(User user)throws Exception{
        boolean isPurches=false;
        //1. Check if user own this movie
        for(Media item: user.getPurchaseMediaList()) {
            if (item.getTitle().equals(super.getTitle()))
                isPurches=true;
        }
        //2.if not prevent playing it
        if(!isPurches) throw new Exception("Dear: "+ user.getUsername()+", you don't own this movie yet.");
        System.out.println("The movie: "+super.getTitle()+" is playing..");
    }

        public ArrayList<Movie> generalPlayList(ArrayList<Movie> movieCatalog, Store store)
    {
        ArrayList<Movie> newList = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();
        //1. collect authors' names from the givin list
        for(Movie movie: movieCatalog)
        {
            if(!authors.contains(movie.getAuteur())) //# if the author didnt add before add it
                authors.add(movie.getAuteur());
        }

        //2. get all exisence music in the system.
        ArrayList<Media> all = store.displayMedia();
        boolean isMovie ;
        //3. create a music list from these authors' work
        //3.2 do two loops, one for all authors, second for all music in store
        for(String author:authors){
            for(Media media: all)
            {
                isMovie = media.getMediaType().equals("Long movie")||media.getMediaType().equals("Movie");
                if(isMovie)
                {
                    if(media.getTitle().equals(author))
                        newList.add((Movie)media);
                }
            } }

        // newList.add();

        return  newList;
    }


    public String getMediaType(){
        if(duration>=120) return "Long movie";
        return "Movie";}
    public String toString(){
        return getMediaType()+" "+super.toString()+", with duration(in min): "+duration;
    }

}
