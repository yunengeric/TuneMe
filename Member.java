import java.util.*;
public class Member extends Record
{   
    private double balance;
    private Password word;
    private MediaFiles library = new MediaFiles();
    public Member(int id, String name, String password, double balance)
    {  
        super(id, name); 
        word = new Password(password);
        this.balance = balance;
    }
    public char checkMedia(MediaFile media)
    {
        char msg;
        if(media == null)
        {
            msg = 'a'; 
        }                // id not found
        else if(balance < media.price)
        {
            msg = 'b';
        }                // not enough money
        else if( has(media.getId()) )
        {
            msg = 'c';
        }             // media already owned
        else
        {
            msg = buyMedia(media);
        }            // buy media
        return msg;
    }
    public char buyMedia(MediaFile m)
    {
        char msg;
        balance = balance - m.price;
        library.add(m);
        return msg = 'd';//System.out.println(" " + media + "added")
    }
    public MediaFiles getLibrary()
    {
        return library;
    }
    public boolean isPassword(String password)
    {
        return word.matches(password);
    }
    public boolean has(int id)//check if the member already has a MediaFile
    {
        return library.find(id) != null;
    }
    public String toString()
    {   
        return super.toString() + " balance $" + In.twoDec(balance);   
    }
}
