import java.util.*;

public class Donator extends User {
    private Offers offersList;
    private String name;
    private int phone;
    private Organization org;
    private double quan=0;
    private ArrayList<Entity> requestDonation=new ArrayList<Entity>();
    private List<Material> materialList=new ArrayList<>(); 
    private List<Service> serviceList=new ArrayList<>();
    private Material mat;
    
    //constructor xwris orismata
    public Donator(){}
    
    //constructor me orismata
    public Donator(String name, int phone, Organization org){
        this.name=name;
        this.phone=phone;
        this.org=org;
    }
    
    //methodos gia na epistrefei to antikeimeno Organization
    public Organization getOrg(){
        return this.org;
    }
    
    //methodos gia na epistrefei thn metavlhth phone
    public int getPhone(){
        return this.phone;
    }
    
    //methodos gia na epistrefei thn metavlhth name
    public String getName(){
        return this.name;
    }
    
    //methodos gia na pros8etei sthn lista requestDonation kapoio Entity pou dinw san orisma
    public void addInList(Entity a){
        this.requestDonation.add(a);
    }
}