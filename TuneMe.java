import java.util.*;
public class TuneMe  
{   
    public static int today = 1;
    private final String NAME = "TuneMe";
    private double balance = 0.0;
    private MediaFiles resources;
    private Members members;
    private Member current = null;//used for login
    public TuneMe()
    {    
        members = new Members();
        resources = new MediaFiles();
        menu();
    }
    private void menu()
    {
        char action = readAction();
        switch (action)
        {
            case 'R': register(); break;
            case 'A': addMedia(); break;
            case 'B': browse(); break;
            case 'L': login(); break;
            case 'Y': 
            case 'M':
            case 'O': menu(action);break;
            case 'S': siteReport(); break;
            case 'X': exit(); break;
            case '?': help(); break;
            default: error();
        }
    }
    private char readAction()
    {
         if(isLoggedIn())
            System.out.print("Please enter your choice (Y, M, O): ");
        else
        System.out.print("Please enter your choice (R, A, B, L, S, X, ?): ");
        return In.nextUpperChar();
    }
    public void register()
    {   
       String name = readString("Add a member \nName: ");
       String password = readString("Password: ");
       double balance = readDouble("Balance: $");
       members.add(new Member((today - resources.size()), name, password,balance));
       System.out.println((today - resources.size()) + " " + name +" added");
       today ++;
       menu();
    } 
    public void addMedia()
    {   
        MediaFile mf = null;
        int type = readInt("Add a resource \nMedia type(1 - Song, 2-Movie): ");  //get info of media type
        String name = readString("Name: ");
        double price = readDouble("Price: $");
        if(type == 1)
        {
            mf = buySong(name,price);   
        }
        else{
            mf = buyMovie(name,price);
        } 
        resources.add(mf);
        System.out.println(" " + resources.find(today - members.size()) + " added"); 
        today++;
        menu();
    }
    public MediaFile buySong(String name, double price)
    {
        String artist = readString("Artist: ");
        String album = readString("Album: ");
        MediaFile mf = new Song((today - members.size()),name,price,artist, album); 
        return mf;
    }
    public MediaFile buyMovie(String name, double price)
    {
        int year = readInt("Year: ");
        String actors = readString("Actors: ");
        MediaFile mf = new Movie((today - members.size()),name, price,year, actors);
        return mf;
    }
    public void browse()
    {   
        resources.show();
        menu();
    }
    private void login()
    {
        int id = readInt("Please enter member id: ");
        if(members.find(id) == null)
        {
            System.out.println("Login failed - id not found");
            menu();
        }
        String password = readString("Please enter password: ");
        if(members.find(id).isPassword(password))
        {
            current = members.find(id);
            System.out.println("Login successful");
            menu();  
        }
        System.out.println("Login failed - password incorrect");
        menu();
    }
    private void menu(char action)
    {
        if(isLoggedIn())
        {
            switch (action)
            {
                case 'Y': buy(); break;
                case 'M': memberReport(); break;
                case 'O': logout();break;
            }
        }
        else
            System.out.println("Not logged in");
        menu();
    }
    private boolean isLoggedIn()
    {
        return current != null;
    }
    public void buy()
    {   
        MediaFile media = resources.find(readInt("Media id: "));
        switch (current.checkMedia(media))
        {
            case 'a': System.out.println("Buy failed - media not found"); break;
            case 'b': System.out.println("Buy failed - not enough money"); break;
            case 'c': System.out.println("Buy failed - media already owned"); break;
            case 'd': System.out.println(" " + media + "added");
            this.balance += media.price;
        }
    }
    private void memberReport()
    {
        System.out.println("Members: ");
        System.out.println(" " + current.toString());
        System.out.println("Media owned");
        current.getLibrary().show();
    }
    private void logout()
    {
        current = null;
        menu();
    }
    public void siteReport()
    {   
        System.out.println("Members: "); 
        members.show();
        System.out.println("Media Available: ");
        resources.show();
        System.out.println(toString());
        menu();  
    } 
    private void exit()
    {
        if (!confirm())
        {
             menu();
        }       
        else
        {
            System.out.println("Goodbye");
        }
    }
    private boolean confirm()
    {
        System.out.print("Are you sure (y/n)?: ");
        return In.nextUpperChar() == 'Y';
    }
    private void help()
    {
        System.out.println("Welcome to TuneMe; enter");
        System.out.println("R for Register Member");
        System.out.println("A for Add Media");
        System.out.println("B for Browse Media");
        System.out.println("L for Login");
        System.out.println("Y for Buy Media");
        System.out.println("O for Logout");
        System.out.println("S for Site Report");
        System.out.println("X to exit");
        menu();
    }
    private void error()
    {
        System.out.println("No action found. Try again");
        menu();
    }
    private String readString(String msg)
    {
        System.out.print(msg);
        return In.nextLine();
    }
    private int readInt(String msg)
    {
        System.out.print(msg);
        return In.nextInt();
    }
    private double readDouble(String msg)
    {
        System.out.print(msg);
        return In.nextDouble();
    }
    public void show()
    {
        System.out.println(toString());
    } 
    public String toString()
    {   
        String s =  NAME;
        s += " has $" + In.twoDec(balance) + " balance";
        s += ", " + resources.size() + " resources";
        s += ", " + members.size() + " members";
        return s;   
    }    
}
