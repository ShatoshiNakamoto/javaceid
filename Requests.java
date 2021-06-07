import java.lang.Boolean;

public class Requests extends RequestDonationList{
    //metavlhtes
    private double y;
    private Entity x;
    private Beneficiary ben;
    private Organization org= new Organization("KRONOS");
    private RequestDonation rd=new RequestDonation(x, 50.0);
    private boolean t=true, f=false;
    private double l1=100, l2=250, l3=450;
    
    //constructor me orisma antikeimeno beneficiary
    public Requests(Beneficiary ben) {
        this.ben=ben;
    }
    
    //methodos pou pros8etei to orisma pou dinw se mia lista an afto den uparxei
    public void add(RequestDonation requestDonation){
        if(this.getRdEntities().contains(requestDonation)) super.add(requestDonation);
    }
    
    //methodos gia na elegxei an to atomo threi tis proipo8eseis twn levels gia na lavei ena antikeimeno h mia yphresia
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
}
