import java.util.*;

/**
 * class Records - class is complete
 */
public class Records
{
    protected LinkedList<Record> records = new LinkedList<Record>();
    protected int id = 0;
    protected Record find(int id)
    {   
        for(Record record: records)
        {  
            if (record.matches(id))
                return record;  
        }
        return null;    
    }  
    protected void add(Record record)
    {
        records.add(record);
    }
    public String readString(String msg)
    {   
        System.out.print(msg);
        return In.nextLine();    
    }
     public int readInt(String msg)
    {   
        System.out.print(msg);
        return In.nextInt();  
    } 
    public double readDouble(String msg)
    {   
        System.out.print(msg);
        return In.nextDouble();    
    }
    public int size()
    {
        return records.size();
    }
}
