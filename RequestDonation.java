import java.util.Comparator;

public class RequestDonation {
    //metavlhtes
    private Entity entity;
    private double quantity;;
    
    //constructor xwris orismata
    public RequestDonation() {}
    
    //constructor me orismata
    public RequestDonation(Entity entity, double quantity) {
        this.entity=entity;
        this.quantity=quantity;
    }
    
    //methodos gia na elegxei an to id tou orismatos pou dinw uparxei hdh
    public boolean compareTo(RequestDonation a) {
        if(this.entity.getId() == a.entity.getId())
            return true;
        else return false;
    }
    
    //methodos gia na epistrefei to antikeimeno entity
    public Entity getEntity() {
        return this.entity;
    }
    
    //methodos gia na orizei thn metavlhth quantity
    public double setQuantity(double a) {
        this.quantity=a;
        return this.quantity;
    }
    
    //methodos gia na epistrefei thn metavlhth quantity
    public double getQuantity(){
        return this.quantity;
    }
    
    //methodos gia na pros8etei to orisma pou dinw sthn metavlhth quantity
    public void incrementQuantity(double a) {
        this.quantity += a;
    } 
}