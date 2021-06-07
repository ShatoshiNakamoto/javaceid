import java.util.*;

public class Beneficiary extends User {
    private int noPersons;
    List<Material> requestMaterialList=new ArrayList<>(); 
    List<Service> requestServiceList=new ArrayList<>();
    private Organization org;
    private RequestDonationList rdl=new RequestDonationList();
    private Requests rq;
    private String name;
    private int phone;
    private double quantity;
    private List<Material> materialList=new ArrayList<>(); 
    private List<Service> serviceList=new ArrayList<>();
    private ArrayList<Entity> receivedList=new ArrayList<Entity>();
    
    //constructor xwris orismata
    public Beneficiary(){}
    
    //constructor me orismata
    public Beneficiary(String name, int phone, Organization org) {
        this.name=name;
        this.phone=phone;
        this.org=org;
        this.rq = new Requests(this);
        this.noPersons=1;
        Main.BeneficiaryPhone.add(phone);
    }
    
    //methodos gia na epistrefei thn metavlhth name
    public String getName(){
        return this.name;
    }
    
    //methodos gia na epistrefei thn metavlhth phone
    public int getPhone(){
        return this.phone;
    }
    
    //methodos gia na epistrefei to antikeimeno Organization
    public Organization getOrg(){
        return this.org;
    }
    
    //methodos gia na orizei ton ari8mo atomwn sthn oikogeneia
    public int setPersons(int persons){
        this.noPersons=persons;
        return persons;
    }
    
    //methodos gia na epistrefei ton ari8mo atomwn sthn oikogeneia
    public int getPersons(){
        return this.noPersons;
    }
    
    //methodos me orisma gia na pros8etei mia posothta sthn arxikh
    public void addQuantity(double quan){
        this.quantity = this.quantity+quan;
    }
    
    //methodos gia na pros8etei sthn lista receivedList kapoio Entity pou dinw san orisma
    public void addInList(Entity a){
        this.receivedList.add(a);
    }
}