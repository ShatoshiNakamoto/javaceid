import java.util.List;

public class RequestDonationList {
    private List<RequestDonation> rdEntities;
    
    public RequestDonationList() {}
    
    public List<RequestDonation> getRdEntities(){
        return this.rdEntities;
    }
    
    
    public RequestDonation get(int entityId) { //dinw id, psaxnei thn lista, an vrei shmainei oti uparxei RD
        RequestDonation rd=null;
        for(RequestDonation r: this.rdEntities)
        {
            if(r.getEntity().getId()==entityId)
            {
                rd=r;
                break; //an vrei RD, stamataei
            }
        }
        return rd; //an epistrepsei null, den exei vrei apotelesma
    }
    
    public void add(RequestDonation requestDonation) {
        RequestDonation rd=this.get(requestDonation.getEntity().getId());
        if(rd!=null) //an uparxei hdh to RD, 8a pairnei thn posothta poy yparxei kai 8a pros8etei thn kainouria
        {
            rd.incrementQuantity(requestDonation.getQuantity());
        }
        else 
        {
            rdEntities.add(requestDonation); 
        }
        //EDW PREPEI NA 3ANAER8W GIA TO ORGANIZATION
    
    }
    
    public void remove(RequestDonation a) {
        if(this.get(a.getEntity().getId())!=null) rdEntities.remove(a);
        else System.out.println("This request does not exist!");
    }
    
    public void modify(RequestDonation a, double b) {
        RequestDonation rd=this.get(a.getEntity().getId());
        if(rd!=null) rd.setQuantity(b);
        else System.out.println("This request does not exist!");
    }
    
    public void monitor(){ 
        System.out.println("Request Donation List: ");
        for(RequestDonation r: this.rdEntities)
        {
            System.out.println("Name: " + r.getEntity().getName() + " Quantity: " + r.getQuantity());
        }
    }
    
    public void reset(){
        this.rdEntities.clear();
    }
}
