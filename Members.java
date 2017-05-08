import java.util.*;
public class Members extends Records
{   
    
    public Member find(int id)
    {    
        return (Member) super.find(id); 
    }
    public void show()
    {   
        for(Record record: records)
            ((Member)record).show(); 
    }   
    
        
}