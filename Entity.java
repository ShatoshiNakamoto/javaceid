import java.util.*;

public abstract class Entity{ //den exei constructor, epeidh einai abstract
    private String name;
    private String description;
    private int id;
    
    //methodos gia na epistrefei tis metavlhtes 
    public String getEntityInfo() {
        return "Name: " + this.name + " Description: " + this.description + " ID: " + this.id; 
    }
    
    public abstract String getDetails(); 
        
    @Override 
    public String toString() {
        return this.getEntityInfo() + this.getDetails();
    }
    
    //methodos gia na epistrefei thn metavlhth id
    public int getId(){
        return this.id;
    }
    
    //methodos gia na orizei to id enos entity
    public void setEntityid(int entityid){
        this.id=entityid;
    }
    
    //methodos gia na orizei thn metavlhth description
    public void setDescription(String description){
        this.description=description;
    }
    
    //methodos gia na orizei thn metavlhth name
    public void setName(String set){
        this.name=set;
    }
    
    //methodos gia na epistrefei thn metavlhth name
    public String getName() {
        return this.name;
    }
}