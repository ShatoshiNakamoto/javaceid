import java.util.*;

public class Offers extends RequestDonationList {
    //metavlhtes
    private Organization org=new Organization("KRONOS");
    private double quantity=0;
    
    //constructor xwris orismata
    public void Offers(){}
    
    //methodos gia na diagrafei to orisma pou dinw apo thn lista RdEntities an uparxei
    public void commit(RequestDonation rd) {
        if(getRdEntities().contains(rd)) {
            getRdEntities().remove(rd);
        }
    }
    
    //methodos gia na epistrefei thn metavlhth quantity
    public double getQuantity(){
        return this.quantity;
    }
    
    //methodos gia na pros8etei sthn metavlhth quantity to orisma pou dinw
    public void setQuantity(double a){
        this.quantity+=a;
    }
}