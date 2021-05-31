import java.util.*;

public class Offers extends RequestDonationList {
    private Organization org=new Organization("KRONOS");
    private double quantity=0;
    
    public void commit(RequestDonation rd) {
        if(getRdEntities().contains(rd)) {
            //org.getCurrentDonations().add(rd);
            getRdEntities().remove(rd);
        }
    }
    
    public double getQuantity(){
        return this.quantity;
    }

    public void setQuantity(double a){
        this.quantity+=a;
    }
}