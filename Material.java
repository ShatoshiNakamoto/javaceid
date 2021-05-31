import java.util.*;

public class Material extends Entity {
    private double level1, level2, level3;
    private ArrayList<Material> MaterialList;



    public Material(String name, double quantity, String description,  double a, double b, double c, int entityid) {
        this.setName(name);
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
    
    public void addInList(Material a){
        this.MaterialList.add(a);
    }


    public ArrayList<Material> getMaterialList(){
        return this.MaterialList;
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
