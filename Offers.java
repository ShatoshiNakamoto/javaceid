import java.util.*;

public class Offers extends RequestDonationList {
    private Organization org=new Organization("KRONOS");
    
    public void commit(RequestDonation rd) {
        if(getRdEntities().contains(rd)) {
            //org.getCurrentDonations().add(rd);
            getRdEntities().remove(rd);
        }
    }

}