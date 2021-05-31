import java.util.Comparator;

public class RequestDonation { //implements Comparator {
    private Entity entity;
    private double quantity=100.0;
    
    public RequestDonation() {}
    
    public RequestDonation(Entity entity, double quantity) {
        this.entity=entity;
        this.quantity=quantity;
    }
    
    public boolean compareTo(RequestDonation a) {
        if(this.entity.getId() == a.entity.getId())
            return true;
        else return false;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
    
    public double setQuantity(double a) {
        this.quantity=a;
        return this.quantity;
    }
    
    public double getQuantity(){
        return this.quantity;
    }
    
    public void incrementQuantity(double a) {
        this.quantity += a;
    } 
    
    
}
