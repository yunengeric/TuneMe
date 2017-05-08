/**
 * class Password - class is complete 
 */
public class Password
{
    private String word;
    public Password(String word)
    {
        this.word = word;
    }
    public boolean matches(String word)
    {
        return this.word.equals(word);
    }
}
