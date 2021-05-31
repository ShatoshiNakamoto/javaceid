import java.lang.Boolean;
public class Requests extends RequestDonationList{
    private double y;
    private Entity x;
    private Beneficiary ben;
    private Organization org= new Organization("KRONOS");
    private RequestDonation rd=new RequestDonation(x, 50.0);
    private boolean t=true, f=false;
    private double l1=100, l2=250, l3=450;
    public Requests(Beneficiary ben) {
        this.ben=ben;
    }
    
    public void add(RequestDonation requestDonation){
        
        if(this.getRdEntities().contains(requestDonation)) super.add(requestDonation);
        
        //if(validRequestDonation(rd)==a) System.out.println("This person is allowed to have the requested ammount.");
    }
    
    public void validRequestDonation(RequestDonation a){
        
        if(a.getEntity() instanceof Material) {
            System.out.println("This is a Material!");
            if(ben.getPersons()==ben.setPersons(1)) System.out.println("This person belongs to level1."); 
            else if (ben.getPersons()==ben.setPersons(2)|| ben.getPersons()==ben.setPersons(3)|| ben.getPersons()==ben.setPersons(4)) System.out.println("This person belongs to level2."); 
            else System.out.println("This person belongs to level3.");
            
            if(rd.setQuantity(y)+ rd.getQuantity()>100) System.out.println("The quantity exceeds the allowed one!");
            else System.out.println("The quantity is acceptable!");
        }
        
        else if(a.getEntity() instanceof Service) {
            System.out.println("This is a Service!");
        }
    }
    
    public void commit(RequestDonation rd) {
        if(org.getCurrentDonations().contains(rd)) {
            super.remove(rd);
            getRdEntities().remove(rd);
            ben.getReceivedList().add(rd);
        }
        else System.out.println("This quantity is not available!");
        
        /* if(validRequestDonation(rd)==a) System.out.println("This person is allowed to have the requested ammount."); {
            super.remove(rd);
            getRdEntities().remove(rd);
            ben.getReceivedList().add(rd);
        }
        
        else System.out.println("This person is not allowed to have the requested ammount!"); */
    
    
    }
}