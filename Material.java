import java.util.*;

public class Material extends Entity {
    private double level1, level2, level3;
    private ArrayList<Material> MaterialList;
    private double quantity;


    public Material(String name, double quantity, String description,  double a, double b, double c, int entityid) {
        this.setName(name);
        this.quantity=quantity;
        this.setDescription(description);
        this.setEntityid(entityid);
        this.level1=a;
        this.level2=b;
        this.level3=c;

        this.MaterialList=new ArrayList<Material>();
    }
    
    public Material() {
        this.MaterialList=new ArrayList<>();
    }
    
    public double getQuantity(){
        return this.quantity;
    }
    
    public void addInList(Material a){
        this.MaterialList.add(a);
    }


    public ArrayList<Material> getMaterialList(){
        return this.MaterialList;
    }
    
    public void addQuantity(double quan){

        this.quantity = this.quantity+quan;

    }
    

    
    public Material(double a, double b, double c) {
        this.level1=a;
        this.level2=b;
        this.level3=c;
    }
    
    public String getDetails(){
        return "Object: Material " + " Level1: " + this.level1 + " Level2: " + this.level2 + " Level3: " + this.level3;
    }
}