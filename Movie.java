/**
 * class Movie - class is complete 
 */
public class Movie extends MediaFile
{
    private int year;
    private String actors;
    public Movie(int id, String name , double price, int year, String actors)
    {
       super(id, name, price);
       this.year = year;
       this.actors = actors;
    }
    public String toString()
    {
        return super.toString() + " year: " + year + " actors:" + actors;
    }    
}