import java.util.*;

public class MediaFiles extends Records
{   
    private final int SONG = 1;
    public void add(MediaFile resource)
    {  
        super.add(resource);
    }     
    protected MediaFile find(int id)
    {   
        return (MediaFile) super.find(id);  
    }
    public void show()
    {   
        for(Record record: records)
            ((MediaFile)record).show();   
    }   

}
