/**
 * class Song - class is complete 
 */
public class Song extends MediaFile
{
    private String artist;
    private String album;
    public Song(int id, String name, double price, String artist, String album)
    {
       super(id, name, price);
       this.artist = artist;
       this.album = album;
    }
    public String toString()
    {
        return super.toString() + " artist: " + artist + " album:" + album;
    }    
}
