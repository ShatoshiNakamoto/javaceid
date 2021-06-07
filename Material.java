import java.util.*;

public class Material extends Entity {
    private double level1, level2, level3;
    private ArrayList<Material> MaterialList;
    private double quantity,quantity1=0,quantity2=0;
    private Organization org;

    //constructor me orismata
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
    
    //constructor me orismata ta levels 
     public Material(double a, double b, double c) {
        this.level1=a;
        this.level2=b;
        this.level3=c;
    }
    
    //constructor xwris orismata h opoia dhmiourgei ArrayList
    public Material() {
        this.MaterialList=new ArrayList<>();
    }
    
    //methodos gia na orizei thn metavlhth quantity1
    public void setQuantity1(double quan){
        this.quantity1=quan;
    }
    
    public void setQuantity2(double quan){
        this.quantity2=quan;
    }
    
    //methodos gia na 8etei thn timh ths metavlhths quantity1 0
    public void deleteQuantity(){
        this.quantity1=0;
    }  
    
    //methodos gia na epistrefei thn metavlhth quantity
    public double getQuantity(){
        return this.quantity;
    }
    
    //methodos gia na epistrefei thn metavlhth quantity1
    public double getQuantity1(){
        return this.quantity1;
    }
    
    public double getQuantity2(){
        return this.quantity2;
    }
    
    //methodos gia na pros8etei sthn lista MaterialList kapoio Material pou dinw san orisma
    public void addInList(Material a){
        this.MaterialList.add(a);
    }
    
    //methodos gia na epistrefei thn lista MaterialList
    public ArrayList<Material> getMaterialList(){
        return this.MaterialList;
    }
    
    //methodos gia na pros8etei sthn metavlhth quantity to orisma pou dinw
    public void addQuantity(double quan){
        this.quantity = this.quantity+quan;
    }
    
    //methodos gia na pros8etei sthn metavlhth quantity1 to orisma pou dinw
    public void addQuantity1(double quan){
        this.quantity1 = this.quantity1+quan;
    }
    
    public void addQuantity2(double quan){
        this.quantity2 = this.quantity2+quan;
    }
    
    //methodos gia na aferei apo thn metavlhth quantity to orisma pou dinw
    public void removeQuantity(double quan){
        this.quantity-=quan;
    }
    
    //methodos gia na epistrefei ta levels
    public String getDetails(){
        return "Object: Material " + " Level1: " + this.level1 + " Level2: " + this.level2 + " Level3: " + this.level3;
    }
}