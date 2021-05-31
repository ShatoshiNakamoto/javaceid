import java.util.*;

public abstract class Entity{ 
    private String name;
    private String description;
    private int id;
    private Material mat;
    public String getEntityInfo() {
        return "Name: " + this.name + " Description: " + this.description + " ID: " + this.id; 
    }
    
    public abstract String getDetails(); 
        
    @Override 
    public String toString() {
        return this.getEntityInfo() + this.getDetails();
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setEntityid(int entityid){

        this.id=entityid;

    }

    public void addQuantityMaterial(double quan){
        mat.addQuantity(quan);
    }
    

    public void setDescription(String description){

        this.description=description;

    }

    public void setName(String set){

        this.name=set;

    }

    public String getName() {
        return this.name;
    }
}