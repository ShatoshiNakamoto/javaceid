import java.util.*;

public class Service extends Entity {
    private List<Service> ServiceList;
    private double quantity,quantity1=0,quantity2=0;
    
    //constructor me orismata
    public Service(String name, double quantity, String description, int entityid) {
        this.setName(name);
        this.setDescription(description);
        this.setEntityid(entityid);
        this.quantity=quantity;
        this.ServiceList=new ArrayList<Service>();
    }
    
    //constructor xwris orismata
    public Service() {}
    
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

    //methodos gia na epistrefei thn metavlhth quantity
    public double getQuantity(){
        return this.quantity;
    }
    
    public double getQuantity2(){
        return this.quantity1;
    }
    
     //methodos gia na epistrefei thn metavlhth quantity1
    public double getQuantity1(){
        return this.quantity1;
    }
    
     //methodos gia na epistrefei thn lista ServiceList
    public List<Service> getServiceList(){
        return this.ServiceList;
    }
    
    //methodos gia na pros8etei sthn lista ServiceList kapoio Service pou dinw san orisma
    public void addInList(Service a){
        this.ServiceList.add(a);
    }
    
    //methodos gia na ektypwnei oti to antikeimeno einai typou Service
    public String getDetails() {
        return "Object: Service";
    }
}