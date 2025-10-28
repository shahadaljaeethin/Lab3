import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static void main(String[] args){
//1. create shop
Store jarir = new Store();
//2.create users by system and by user
    User[] manyUsers = new User[3];
    manyUsers[0]= new User("Mohammed","Mo@gmail.com");
    manyUsers[1]= new User("Sarah","sara6@gmail.com");
    manyUsers[2]= new User("Nadeen","Nadeen@gmail.com");

    //3.create many media by the system
    //3.1 books
    Book[] books1 = new Book[4];
    books1[0] = new Book("How to talk better to anyone","Sonya Harbor","360089",70,15);
    books1[1] = new Book("Atomic Habits","Ahmed bin Khalid","360888",59,10);
    books1[2] = new Book("Draw Anatomy","Ayaso yami","609222",120,2);
    books1[3] = new Book("Super Rare Book","Emaan omran","360089",10,0);
//----------------
Novel horror = new Novel("Scary City","John Rose","400032",30,3,"horror");
Novel action = new Novel("My cool grandfather","Moonerah Salman","400030",25,15,"action");
//-
    AcademicBook math = new AcademicBook("Math","Dr.Laylya salwan","100230",90,35,"Pre-calculus");
    AcademicBook programming = new AcademicBook("Learn Programming","Dr.Majd","100260",80,40,"Java");
//=============================================================================================
    //3.2 Movies
    Movie[] movies = new Movie[4];
    movies[0]= new Movie("Titanic","Salman Aziz","01",15,130);
    movies[1]= new Movie("Tom&Jerry","Wejdan habeeb","02",10,40);
    movies[2]= new Movie("Java my bestfriend","Shahad Mohammed","03",35,60);
    movies[3]= new Movie("Cats war","Renaad Saleeh","04",45,80);
    //3.3 Music
    Music[] musics = new Music[4];
    musics[0]= new Music("Costarica","Kairookee","01",15,"Ameer Aid");
    musics[1]= new Music("Brooklyn baby","Lana Del Rey","02",10,"Lana Del Rey");
    musics[2]= new Music("Remember Me","Shahad Mohammed","03",5,"Arcane");
    musics[3]= new Music("Heavenly","Renaad Saleeh","04",6,"C.A.S");

 //4.add all media to the store.
    for(int i=0;i<4;i++)
    jarir.addMedia(books1[i]);

    for(int i=0;i<4;i++)
     jarir.addMedia(movies[i]);

    for(int i=0;i<4;i++)
      jarir.addMedia(musics[i]);

    jarir.addMedia(horror);
    jarir.addMedia(action);
    jarir.addMedia(math);
    jarir.addMedia(programming);
    //add default users by system
        for (int i = 0; i < manyUsers.length; i++)
        jarir.addUser(manyUsers[i]);
    //****finally interact with the user****
    int choice = 0;  Scanner r = new Scanner(System.in);  int keyUser = 0;

    //Home page (log in\register)
    try {
       System.out.println("Welcome to Jarir, please create your account\n1.log in\n2.create account: ");
       choice = r.nextInt();
       if (choice==2) {
       jarir.addUser(createAcc(r));
       }else {jarir.displayUsers();
       keyUser = r.nextInt()-1;
       r.nextLine();
       }

   }catch (Exception e){}


//after entering user account
    Media addThisItem;
while(choice!=9) {
        try {
        System.out.println("\n#Choose from menu:#\n1.show my cart\n2.show my previous perches\n3.show items(Media) in Jarir store\n4.search for a book\n5.switch account(change user)\n6.add media to cart\n7.complete purchase of my cart\n8.remove a media from my cart\n9.exit");
        choice=r.nextInt();
         switch (choice) {
            case 1:
            if(jarir.getUser(keyUser).getShoppingCart().isEmpty())System.out.println("Cart is empty.");
               else {
               for(Media m:jarir.getUser(keyUser).getShoppingCart())
               System.out.println(m);}
               break;

            case 2:
                if(jarir.getUser(keyUser).getPurchaseMediaList().isEmpty())System.out.println("no purchase yet.");
                //-
                for(Media m:jarir.getUser(keyUser).getPurchaseMediaList())
                System.out.println(m);
                break;

            case 3:
            jarir.displayMedia();
            break;

            case 4: System.out.println("write the title: ");
            r.nextLine();
            String title = r.nextLine();
            jarir.searchBook(title);
            break;


            case 5: System.out.println("log in with which account?\n0.create account");
                     r.nextLine();
                    for(int i=0;i<jarir.getUsers().size();i++)
                    System.out.println((i+1)+"-"+jarir.getUser(keyUser).getUsername());
                    keyUser=r.nextInt()-1;

                    if(keyUser>=jarir.getUsers().size()){keyUser=0; throw new Exception("please choose from shown menu");}
                    if(keyUser==-1)    jarir.addUser(createAcc(r));

               break;
            case 6:
                jarir.getUser(keyUser).addToCart(horror); break;
            case 7:
                jarir.getUser(keyUser).checkOut(); break;

            case 8:
            jarir.getUser(keyUser).removeFromCart(horror);
            break;

            case 9:
                System.out.println("Thank you for visiting us!"); break;
            default: throw new Exception("choose from 1 to 8.");

        }


    } catch (Exception e) { System.out.println("#: "+e.getMessage());
    }
}
}
public static User createAcc(Scanner r){
    System.out.println("Username:");
    r.nextLine();
    String username = r.nextLine();
    System.out.println("email: ");
    String email = r.nextLine();
    System.out.println("Welcome! your account was made successfully, you have empty cart now, you can add media and perches them. ");
    return new User(username,email);
}

}
