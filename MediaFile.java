import java.util.*;

public class MediaFile extends Record 
{
    double price;
    public MediaFile(int id, String name, double price)
    {
       super(id, name);
       this.price = price;
    }
    public String toString()
    {
        return super.toString() + " price: $" +  price;
    }
}
